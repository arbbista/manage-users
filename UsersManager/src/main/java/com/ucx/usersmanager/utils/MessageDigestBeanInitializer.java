/*
 * Copyright (C) 2022. Smart Bits GmbH. All rights reserved.
 * Created by Arbër Pllana on 03/03/2022.
 */

package com.ucx.usersmanager.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Bean initialization of MessageDigest that uses SHA-256 algorithm.
 */
@Configuration
public class MessageDigestBeanInitializer {
  private final String ENCRYPTION_ALGORITHM = "SHA-256";

  @Bean
  public MessageDigest passwordEncoderSHA256() throws NoSuchAlgorithmException {
    return MessageDigest.getInstance(ENCRYPTION_ALGORITHM);
  }
}
