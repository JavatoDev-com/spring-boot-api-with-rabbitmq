package com.javatodev.app.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RabbitMQConsumer {

    /**
     * Consume message from RabbitMQ queue
     * @param message
     */
    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void consume(String message){
        log.info(String.format("Received message -> %s", message));
    }
}
