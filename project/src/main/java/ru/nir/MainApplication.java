package ru.nir;

import javax.mail.MessagingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import ru.nir.gmail.EmailSender;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) throws MessagingException {
        SpringApplication.run(MainApplication.class);
        //   System.out.println("Hello");
       // EmailSender emailSender = new EmailSender();
        //emailSender.sendEmailMain("maksim.perch99@gmail.com");
    }
}

