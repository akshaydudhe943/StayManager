package com.akshay.StayManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akshay.StayManager.services.NotificationService;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/payment-reminder/{tenantId}")
    public void sendPaymentReminder(@PathVariable Long tenantId) {
        notificationService.sendPaymentReminder(tenantId);
    }

    @PostMapping("/announcement")
    public void sendAnnouncement(@RequestBody String message) {
        notificationService.sendAnnouncement(message);
    }
}
