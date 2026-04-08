package com.artconnect.notification.mail;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.artconnect.license.event.LicenseApprovedEvent;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final JavaMailSender mailSender;

    public void sendLicenseApprovedEmail(LicenseApprovedEvent event){

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(event.getBuyerEmail());
        message.setSubject("License Approved");
        message.setText(
                "Your license is approved.\n" +
                "License ID: " + event.getLicenseId()
        );

        mailSender.send(message);

        System.out.println("REAL EMAIL SENT");
    }
}
