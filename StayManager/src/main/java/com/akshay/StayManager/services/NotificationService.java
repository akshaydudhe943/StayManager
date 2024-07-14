package com.akshay.StayManager.services;

public interface NotificationService {
    void sendPaymentReminder(Long tenantId);
    void sendAnnouncement(String message);
}