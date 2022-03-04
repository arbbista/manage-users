/*
 * Copyright (C) 2022. Smart Bits GmbH. All rights reserved.
 * Created by Arbër Pllana on 04/03/2022.
 */

package com.ucx.usersmanager.manageusers.rabbitmqmessaging;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {
  private final String FIND_USER_BY_USERNAME_QUEUE = "user.request.by.first.name";

  @RabbitListener(queues = {FIND_USER_BY_USERNAME_QUEUE})
  public void listenQueues(String message) {
    System.out.println("Received Message From RabbitMQ: " + message);
  }

  @Bean
  public Queue myQueue() {
    return new Queue(FIND_USER_BY_USERNAME_QUEUE);
  }
}
