package com.example.productor.controller;


import com.example.productor.model.EmailMessage;
import com.example.productor.service.EmailProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emails")
public class EmailController {

    private final EmailProducer emailProducer;

    @Autowired
    public EmailController(EmailProducer emailProducer) {
        this.emailProducer = emailProducer;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(@RequestBody EmailMessage emailMessage) {
        emailProducer.sendEmail(emailMessage);
        return ResponseEntity.ok("Email enviado a la cola.");
    }
}

