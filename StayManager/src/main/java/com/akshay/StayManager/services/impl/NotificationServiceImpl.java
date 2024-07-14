package com.akshay.StayManager.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.akshay.StayManager.entity.Tenant;
import com.akshay.StayManager.services.NotificationService;
import com.akshay.StayManager.services.TenantService;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private JavaMailSender javaMailSender;
    
    @Autowired
    private TenantService tenantService;

    @Override
    public void sendPaymentReminder(Long tenantId) {
        // Fetch tenant details and send email reminder
        Tenant tenant = tenantService.findById(tenantId);
        if (tenant != null) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(tenant.getEmail());
            message.setSubject("Payment Reminder");
            message.setText("Dear " + tenant.getName() + ",\n\nThis is a reminder to make your payment for the hostel.");
            javaMailSender.send(message);
        } else {
            // Handle the case where the tenant is not found
            System.out.println("Tenant with ID " + tenantId + " not found.");
        }
    }

    @Override
    public void sendAnnouncement(String messageContent) {
        // Fetch all tenants and send email announcement
        List<Tenant> tenants = tenantService.findAll();
        for (Tenant tenant : tenants) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(tenant.getEmail());
            message.setSubject("Announcement");
            message.setText(messageContent);
            javaMailSender.send(message);
        }
    }
}
