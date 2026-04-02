package com.artconnect.notification.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notify")
public class NotificationController {

    @PostMapping("/license-request")
    public String licenseRequest(){
    	System.out.println("License request notification sent");
        return "License request notification sent";
    }

    @PostMapping("/license-approved")
    public String licenseApproved(){
    	System.out.println("License approved notification sent");
        return "License approved notification sent";
    }

}