package com.akshay.StayManager.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.akshay.StayManager.entity.Tenant;
import com.akshay.StayManager.request.TenantRequest;

public interface TenantRepository extends JpaRepository<Tenant, Long> {
	public Tenant findByEmail(String email);
}