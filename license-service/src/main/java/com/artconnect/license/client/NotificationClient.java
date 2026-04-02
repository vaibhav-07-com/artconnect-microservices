package com.artconnect.license.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "notification-service")
public interface NotificationClient {

    @PostMapping("/notify/license-request")
    String sendRequestNotification();

    @PostMapping("/notify/license-approved")
    String sendApprovedNotification();
}