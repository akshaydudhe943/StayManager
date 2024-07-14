package com.akshay.StayManager.services;

import java.util.List;

import com.akshay.StayManager.entity.Payment;

public interface PaymentService {
    Payment recordPayment(Payment payment);
    Payment findById(Long id);
    List<Payment> findAll();
    List<Payment> findByTenantId(Long tenantId);
}