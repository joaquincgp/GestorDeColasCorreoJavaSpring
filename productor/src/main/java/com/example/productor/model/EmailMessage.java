package com.example.productor.model;


import java.io.Serializable;

public class EmailMessage implements Serializable {
    private static final long serialVersionUID = 1L; // Puedes generar un UID único

    private String id;
    private String to;
    private String subject;
    private String message;

    // Constructores (no son necesarios pero por convencion los incluimos)
    public EmailMessage() {}

    public EmailMessage(String id, String to, String subject, String message) {
        this.id = id;
        this.to = to;
        this.subject = subject;
        this.message = message;
    }

    // Getters y Setters (no son necesarios pero por convencion los incluimos)


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
