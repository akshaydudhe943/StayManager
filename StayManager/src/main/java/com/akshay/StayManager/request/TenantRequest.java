package com.akshay.StayManager.request;

import lombok.Data;

@Data
public class TenantRequest {

    private String name;
    private String email;
    private String contactDetails;
    private Long roomId;
}
