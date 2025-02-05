package com.akshay.StayManager.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akshay.StayManager.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

	List<Payment> findByTenantId(Long tenantId);
	
}