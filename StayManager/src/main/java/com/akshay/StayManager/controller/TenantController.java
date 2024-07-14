package com.akshay.StayManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akshay.StayManager.entity.Tenant;
import com.akshay.StayManager.request.TenantRequest;
import com.akshay.StayManager.services.TenantService;

@RestController
@RequestMapping("/api/tenants")
public class TenantController {

    @Autowired
    private TenantService tenantService;

    @PostMapping("/register")
    public Tenant register(@RequestBody TenantRequest tenant) {
        return tenantService.register(tenant);
    }

    @PutMapping("/{id}")
    public Tenant updateTenant(@PathVariable Long id, @RequestBody TenantRequest tenant) {
        return tenantService.updateTenant(id, tenant);
    }

    @GetMapping("/{id}")
    public Tenant getTenant(@PathVariable Long id) {
        return tenantService.findById(id);
    }

    @GetMapping
    public List<Tenant> getAllTenants() {
        return tenantService.findAll();
    }
}
