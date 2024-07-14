package com.akshay.StayManager.services;

import java.util.List;

import com.akshay.StayManager.entity.Tenant;
import com.akshay.StayManager.request.TenantRequest;

public interface TenantService {
	Tenant register(TenantRequest tenant);
	Tenant updateTenant(Long id, TenantRequest tenant);
	Tenant findById(Long id);
    List<Tenant> findAll();
}