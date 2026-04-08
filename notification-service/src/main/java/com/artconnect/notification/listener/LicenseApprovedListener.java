package com.artconnect.notification.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.artconnect.license.event.LicenseApprovedEvent;
import com.artconnect.notification.mail.NotificationService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class LicenseApprovedListener {
	
	private final NotificationService notificationService;

	@RabbitListener(queues = "license.approved")
	public void listen(LicenseApprovedEvent event) {
	    System.out.println("Received: " + event);

	    notificationService.sendLicenseApprovedEmail(event);
	}
}