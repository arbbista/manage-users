/*
 * Copyright (C) 2022. Smart Bits GmbH. All rights reserved.
 * Created by Arbër Pllana on 03/03/2022.
 */

package com.ucx.usersmanager.manageusers.builders;

import com.ucx.usersmanager.manageusers.models.UserModel;

public final class UserModelBuilder {
  private Long id;
  private String firstName;
  private String lastName;
  private String email;
  private String password;

  private UserModelBuilder() {
  }

  public static UserModelBuilder anUserModel() {
    return new UserModelBuilder();
  }

  public UserModelBuilder withId(Long id) {
    this.id = id;
    return this;
  }

  public UserModelBuilder withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public UserModelBuilder withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public UserModelBuilder withEmail(String email) {
    this.email = email;
    return this;
  }

  public UserModelBuilder withPassword(String password) {
    this.password = password;
    return this;
  }

  public UserModel build() {
    UserModel userModel = new UserModel();
    userModel.setId(id);
    userModel.setFirstName(firstName);
    userModel.setLastName(lastName);
    userModel.setEmail(email);
    userModel.setPassword(password);
    return userModel;
  }
}
