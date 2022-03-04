/*
 * Copyright (C) 2022. Smart Bits GmbH. All rights reserved.
 * Created by Arbër Pllana on 04/03/2022.
 */

package com.ucx.usersmanager.manageusers.rabbitmqmessaging;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Service
public class RabbitMQSender {
  private final String FIND_USER_BY_USERNAME_QUEUE = "user.request.by.first.name";
  @Value("${spring.rabbitmq.host}")
  private String rabbitMqServerAddress;

  public void sender(String message) {
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost(rabbitMqServerAddress);

    try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
      channel.queueDeclare(FIND_USER_BY_USERNAME_QUEUE, true, false, false, null);
      channel.basicPublish("", FIND_USER_BY_USERNAME_QUEUE, null, message.getBytes());
    } catch (IOException | TimeoutException e) {
      e.printStackTrace();
    }
  }
}
