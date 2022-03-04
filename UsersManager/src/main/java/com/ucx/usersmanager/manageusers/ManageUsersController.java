/*
 * Copyright (C) 2022. Smart Bits GmbH. All rights reserved.
 * Created by Arbër Pllana on 03/03/2022.
 */

package com.ucx.usersmanager.manageusers;

import com.ucx.usersmanager.manageusers.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class ManageUsersController {
  private final ManageUsersService manageUsersService;

  @Autowired
  public ManageUsersController(ManageUsersService manageUsersService) {
    this.manageUsersService = manageUsersService;
  }

  @PostMapping(value = "")
  public UserModel createUser(@RequestBody UserModel userModel) {
    return manageUsersService.createUser(userModel);
  }

  @GetMapping(params = {"firstName"})
  public Page<UserModel> getUserByFirstName(@RequestParam String firstName, Pageable pageable) {
    return manageUsersService.getUserByFirstName(firstName, pageable);
  }

  @GetMapping("")
  public UserModel getUser(@RequestParam Long id) {
    return manageUsersService.getUser(id);
  }

  @PutMapping("/{id}")
  public UserModel updateUser(@RequestBody UserModel userModel) {
    return manageUsersService.updateUser(userModel);
  }

  @DeleteMapping("/{id}")
  public UserModel deleteUser(@PathVariable Long id) {
    return manageUsersService.deleteUser(id);
  }
}
