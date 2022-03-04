/*
 * Copyright (C) 2022. Smart Bits GmbH. All rights reserved.
 * Created by Arbër Pllana on 03/03/2022.
 */

package com.ucx.usersmanager.manageusers;

import com.ucx.usersmanager.manageusers.models.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ManageUsersRepository extends PagingAndSortingRepository<UserModel, Long>, JpaSpecificationExecutor<UserModel> {
  UserModel findByEmail(String email);

  Page<UserModel> findByFirstName(String firstName, Pageable pageable);
}
