# GestorDeColasCorreoJavaSpring
Servicio desarrollado con Spring Boot que se encarga de procesar mensajes de correo electrónico. Su principal función es escuchar una cola específica en RabbitMQ, recibir mensajes que contienen los detalles necesarios para enviar un correo electrónico, y luego utilizar el servicio SMTP de Gmail para enviarlos a sus destinatarios.
