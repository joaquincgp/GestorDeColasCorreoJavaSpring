package com.example.consumidor.service;

import com.example.consumidor.config.RabbitConfig;
import com.example.consumidor.model.EmailMessage;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailConsumer {

    @Autowired
    private JavaMailSender mailSender;

    @RabbitListener(queues = RabbitConfig.QUEUE_NAME)
    public void receiveEmail(EmailMessage emailMessage) {
        try {
            sendEmail(emailMessage);
        } catch (MessagingException e) {
            // Manejar la excepción adecuadamente (por ejemplo, registrar el error)
            System.err.println("Error al enviar el correo: " + e.getMessage());
        }
    }

    public void sendEmail(EmailMessage emailMessage) throws MessagingException {
        if (emailMessage.getTo() == null || emailMessage.getTo().isEmpty()) {
            throw new IllegalArgumentException("El campo 'to' no puede estar vacío.");
        }
        if (emailMessage.getSubject() == null) {
            emailMessage.setSubject("");
        }
        if (emailMessage.getMessage() == null) {
            emailMessage.setMessage("");
        }

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        helper.setFrom("jchacongp3@gmail.com"); // Debe coincidir con spring.mail.username
        helper.setTo(emailMessage.getTo());
        helper.setSubject(emailMessage.getSubject());
        helper.setText(emailMessage.getMessage(), false); // 'false' indica texto plano

        mailSender.send(mimeMessage);

        System.out.println("Email enviado exitosamente a: " + emailMessage.getTo());
    }
}
