package com.akshay.StayManager.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.akshay.StayManager.entity.HostelOwner;
import com.akshay.StayManager.repositories.HostelOwnerRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private HostelOwnerRepository hostelOwnerRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        HostelOwner hostelOwner = hostelOwnerRepository.findByEmail(email);
        if (hostelOwner == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
        return new org.springframework.security.core.userdetails.User(hostelOwner.getEmail(), hostelOwner.getPassword(), new ArrayList<>());
    }
}
