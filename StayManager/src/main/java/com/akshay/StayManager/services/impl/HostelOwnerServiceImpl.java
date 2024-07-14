package com.akshay.StayManager.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.akshay.StayManager.entity.HostelOwner;
import com.akshay.StayManager.repositories.HostelOwnerRepository;
import com.akshay.StayManager.services.HostelOwnerService;

@Service
public class HostelOwnerServiceImpl implements HostelOwnerService {

    @Autowired
    private HostelOwnerRepository hostelOwnerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public HostelOwner register(HostelOwner hostelOwner) {
        hostelOwner.setPassword(passwordEncoder.encode(hostelOwner.getPassword()));
        return hostelOwnerRepository.save(hostelOwner);
    }

    @Override
    public HostelOwner login(String email, String password) {
        HostelOwner owner = hostelOwnerRepository.findByEmail(email);
        if (owner != null && passwordEncoder.matches(password, owner.getPassword())) {
            return owner;
        }
        return null;
    }

    @Override
    public HostelOwner findById(Long id) {
        return hostelOwnerRepository.findById(id).orElse(null);
    }

    @Override
    public HostelOwner updateProfile(Long id, HostelOwner hostelOwner) {
        HostelOwner existingOwner = findById(id);
        if (existingOwner != null) {
            existingOwner.setName(hostelOwner.getName());
            existingOwner.setMobile(hostelOwner.getMobile());
            return hostelOwnerRepository.save(existingOwner);
        }
        return null;
    }
    
    
    
    
}