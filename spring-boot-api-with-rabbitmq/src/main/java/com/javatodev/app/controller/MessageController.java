package com.javatodev.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.javatodev.app.dto.MessageDto;
import com.javatodev.app.dto.User;
import com.javatodev.app.publisher.RabbitMQJsonProducer;
import com.javatodev.app.publisher.RabbitMQProducer;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class MessageController {

    private final RabbitMQProducer rabbitMQProducer;

    private final RabbitMQJsonProducer rabbitMQJsonProducer;

    /**
     * API for publish message for RabbitMQ queue
     * @param message
     * @return ResponseEntity
     */
    @PostMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestBody MessageDto message){
        rabbitMQProducer.sendMessage(message.getMessage());
        return ResponseEntity.ok("Message sent to RabbitMQ.");
    }

    /**
     * API for publish message for RabbitMQ json queue
     * @param user
     * @return ResponseEntity
     */
    @PostMapping("/json/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user){
        rabbitMQJsonProducer.sendJsonMessage(user);
        return ResponseEntity.ok("Json message sent to RabbitMQ.");
    }
}
