package com.akshay.StayManager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akshay.StayManager.entity.HostelOwner;

public interface HostelOwnerRepository extends JpaRepository<HostelOwner, Long> {
    HostelOwner findByEmail(String email);
}
