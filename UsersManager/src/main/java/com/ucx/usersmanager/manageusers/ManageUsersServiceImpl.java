/*
 * Copyright (C) 2022. Smart Bits GmbH. All rights reserved.
 * Created by Arbër Pllana on 03/03/2022.
 */

package com.ucx.usersmanager.manageusers;

import com.ucx.usersmanager.manageusers.models.UserModel;
import com.ucx.usersmanager.manageusers.rabbitmqmessaging.RabbitMQSender;
import com.ucx.usersmanager.utils.EncodePassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ManageUsersServiceImpl implements ManageUsersService {
  private final ManageUsersRepository manageUsersRepository;
  private final EncodePassword encodePassword;
  private final RabbitMQSender rabbitMQSender;

  @Autowired
  public ManageUsersServiceImpl(ManageUsersRepository manageUsersRepository, EncodePassword encodePassword, RabbitMQSender rabbitMQSender) {
    this.manageUsersRepository = manageUsersRepository;
    this.encodePassword = encodePassword;
    this.rabbitMQSender = rabbitMQSender;
  }

  @Override
  public UserModel createUser(UserModel userModel) {
    boolean userExists = userExists(userModel.getEmail());
    if (userExists) {
      throw new ResponseStatusException(HttpStatus.CONFLICT, "409x01 - Invalid user email! User with the email address already exists.");
    }

    String encryptedPassword = encodePassword.encrypt(userModel.getPassword());
    userModel.setPassword(encryptedPassword);

    return manageUsersRepository.save(userModel);
  }

  private boolean userExists(String email) {
    return manageUsersRepository.findByEmail(email) != null;
  }

  @Override
  public Page<UserModel> getUserByFirstName(String firstName, Pageable pageable) {
    rabbitMQSender.sender("User data requested!");
    return manageUsersRepository.findByFirstName(firstName, pageable);
  }

  @Override
  public UserModel getUser(Long id) {
    return null;
  }

  @Override
  public UserModel updateUser(UserModel userModel) {
    return null;
  }

  @Override
  public UserModel deleteUser(Long id) {
    return null;
  }
}
