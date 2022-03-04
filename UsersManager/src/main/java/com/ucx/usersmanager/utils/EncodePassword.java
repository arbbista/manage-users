/*
 * Copyright (C) 2022. Smart Bits GmbH. All rights reserved.
 * Created by Arbër Pllana on 03/03/2022.
 */

package com.ucx.usersmanager.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * This class is used for encryption of a specific String with SH256 algorithm type.
 */
@Service
public class EncodePassword {
  MessageDigest passwordEncoderSHA256;

  @Autowired
  public EncodePassword(MessageDigest passwordEncoderSHA256) {
    this.passwordEncoderSHA256 = passwordEncoderSHA256;
  }

  private static String bytesToHex(byte[] hash) {
    StringBuilder hexString = new StringBuilder(2 * hash.length);
    for (byte h : hash) {
      String hex = Integer.toHexString(0xff & h);
      if (hex.length() == 1) {
        hexString.append('0');
      }
      hexString.append(hex);
    }
    return hexString.toString();
  }

  public String encrypt(String value) {
    passwordEncoderSHA256.update(value.getBytes(StandardCharsets.UTF_8));
    byte[] digest = passwordEncoderSHA256.digest();
    return bytesToHex(digest);
  }
}
