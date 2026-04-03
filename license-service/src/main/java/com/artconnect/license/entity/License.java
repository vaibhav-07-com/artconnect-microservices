package com.artconnect.license.entity;

import jakarta.persistence.*;
import lombok.Data;
import com.artconnect.license.enums.LicenseType;
import com.artconnect.license.enums.LicenseStatus;

@Entity
@Data
public class License {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long artworkId;

    private Long artistId;

    @Enumerated(EnumType.STRING)
    private LicenseType licenseType;

    @Enumerated(EnumType.STRING)
    private LicenseStatus status;

    private Double price;

    private String buyerEmail;
}