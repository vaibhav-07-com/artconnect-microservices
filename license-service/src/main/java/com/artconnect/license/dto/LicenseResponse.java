package com.artconnect.license.dto;

import com.artconnect.license.enums.LicenseStatus;

import lombok.Data;

@Data
public class LicenseResponse {

    private Long id;
    private String status;
    private String message;
    private String certificateUrl;
}