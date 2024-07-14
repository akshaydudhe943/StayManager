package com.akshay.StayManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akshay.StayManager.entity.HostelOwner;
import com.akshay.StayManager.services.HostelOwnerService;

@RestController
@RequestMapping("/api/hostelowners")
public class HostelOwnerController {

    @Autowired
    private HostelOwnerService hostelOwnerService;

    @GetMapping("/{id}")
    public HostelOwner getProfile(@PathVariable Long id) {
        return hostelOwnerService.findById(id);
    }

    @PutMapping("/{id}")
    public HostelOwner updateProfile(@PathVariable Long id, @RequestBody HostelOwner hostelOwner) {
        return hostelOwnerService.updateProfile(id, hostelOwner);
    }
}

