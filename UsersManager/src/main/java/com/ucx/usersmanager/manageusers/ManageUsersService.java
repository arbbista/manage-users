/*
 * Copyright (C) 2022. Smart Bits GmbH. All rights reserved.
 * Created by Arbër Pllana on 03/03/2022.
 */

package com.ucx.usersmanager.manageusers;

import com.ucx.usersmanager.manageusers.models.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ManageUsersService {
  UserModel createUser(UserModel userModel);

  UserModel getUser(Long id);

  UserModel updateUser(UserModel userModel);

  UserModel deleteUser(Long id);

  Page<UserModel> getUserByFirstName(String firstName, Pageable pageable);
}
