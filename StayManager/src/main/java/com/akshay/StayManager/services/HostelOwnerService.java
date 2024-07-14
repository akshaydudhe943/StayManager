package com.akshay.StayManager.services;

import com.akshay.StayManager.entity.HostelOwner;

public interface HostelOwnerService {
    HostelOwner register(HostelOwner hostelOwner);
    HostelOwner login(String email, String password);
    HostelOwner findById(Long id);
    HostelOwner updateProfile(Long id, HostelOwner hostelOwner);
}