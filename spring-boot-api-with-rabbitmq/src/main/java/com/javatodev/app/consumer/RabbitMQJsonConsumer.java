package com.javatodev.app.consumer;

import com.javatodev.app.dto.User;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RabbitMQJsonConsumer {

    /**
     * Consume message from RabbitMQ json queue
     *
     * @param user
     */
    @RabbitListener(queues = {"${rabbitmq.queue.json.name}"})
    public void consumeJsonMessage(User user) {
        log.info(String.format("Received json message -> %s", user.toString()));
    }
}
