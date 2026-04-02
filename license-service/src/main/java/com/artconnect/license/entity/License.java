package com.artconnect.license.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class License {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long artworkId;

    private Long artistId;

    private String licenseType; // personal, commercial

    private Double price;

    private String status; // REQUESTED, APPROVED

    private String buyerEmail;
}