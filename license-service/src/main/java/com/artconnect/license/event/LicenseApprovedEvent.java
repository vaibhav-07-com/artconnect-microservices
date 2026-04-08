package com.artconnect.license.event;

import java.io.Serializable;

import lombok.Data;

@Data
public class LicenseApprovedEvent implements Serializable {

    private Long licenseId;
    private Long artistId;
    private Long artworkId;
    private String buyerEmail;
}