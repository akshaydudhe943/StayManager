package com.akshay.StayManager.services.impl;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akshay.StayManager.entity.Room;
import com.akshay.StayManager.entity.Tenant;
import com.akshay.StayManager.repositories.TenantRepository;
import com.akshay.StayManager.request.TenantRequest;
import com.akshay.StayManager.services.RoomService;
import com.akshay.StayManager.services.TenantService;

@Service
public class TenantServiceImpl implements TenantService {

    @Autowired
    private TenantRepository tenantRepository;
    
    @Autowired
    private RoomService roomService;

    @Override
    public Tenant register(TenantRequest req) {
        if (!isValidEmail(req.getEmail())) {
            throw new IllegalArgumentException("Invalid email address");
        }
    	Tenant tenant = new Tenant();
    	Room room = roomService.findById(req.getRoomId());
    	tenant.setContactDetails(req.getContactDetails());
    	tenant.setEmail(req.getEmail());
    	tenant.setName(req.getName());
    	tenant.setRoom(room);
    	
        return tenantRepository.save(tenant);
    }
    
    private static final String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    public static boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        java.util.regex.Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }

    @Override
    public Tenant updateTenant(Long id, TenantRequest tenant) {
        Tenant existingTenant = findById(id);
        Room room = roomService.findById(tenant.getRoomId());
        if (existingTenant != null) {
            existingTenant.setName(tenant.getName());
            existingTenant.setEmail(tenant.getEmail());
            existingTenant.setContactDetails(tenant.getContactDetails());
            
            existingTenant.setRoom(room);
            return tenantRepository.save(existingTenant);
        }
        return null;
    }

    @Override
    public Tenant findById(Long id) {
        return tenantRepository.findById(id).orElse(null);
    }

    @Override
    public List<Tenant> findAll() {
        return tenantRepository.findAll();
    }
}
