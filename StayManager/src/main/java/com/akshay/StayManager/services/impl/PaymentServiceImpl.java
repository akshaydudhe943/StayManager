package com.akshay.StayManager.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akshay.StayManager.entity.Payment;
import com.akshay.StayManager.repositories.PaymentRepository;
import com.akshay.StayManager.services.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment recordPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment findById(Long id) {
        return paymentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    @Override
    public List<Payment> findByTenantId(Long tenantId) {
        return paymentRepository.findByTenantId(tenantId);
    }
}
