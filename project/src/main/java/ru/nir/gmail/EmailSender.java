package ru.nir.gmail;

import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.atmosphere.config.service.Get;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;


import javax.swing.*;

@Service
public class EmailSender {

    @Getter
    private final String forEmail = "hrhappiness123@gmail.com";//почта, с которой идет рассылка

    private Integer intCode = 0;

    public Integer getIntCode() {
        return intCode;
    }

    public void setIntCode(Integer intCode) {
        this.intCode = intCode;
    }

    //Готовый, основной метод.
    //Метод, рассылающий на почту(почта отправителя указана автоматически)
    public void sendEmailMain(String email/*,String subject, String message*/) throws MessagingException {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.starttls.enable", "true");
        String myAccountEmail = "hrhappiness123@gmail.com";
        String password = "usudlwgugknqgocy";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });
        Message message = prepareMessage(session, myAccountEmail, email);
        Transport.send(message);
    }


    private Message prepareMessage(Session session, String myAccountEmail, String email) {

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setSubject("My NIR application!");
            generationCodes();
            message.setText("Your access code  \n"+getIntCode());
            return message;
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void generationCodes(){
        Random random = new Random();
        setIntCode(random.nextInt());
    }

}