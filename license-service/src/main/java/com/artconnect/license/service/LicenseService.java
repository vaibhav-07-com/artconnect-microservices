package com.artconnect.license.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.artconnect.license.client.ArtistClient;
import com.artconnect.license.client.NotificationClient;
import com.artconnect.license.client.PortfolioClient;
import com.artconnect.license.dto.LicenseResponse;
import com.artconnect.license.entity.License;
import com.artconnect.license.enums.LicenseStatus;
import com.artconnect.license.repository.LicenseRepository;
import com.artconnect.license.exception.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LicenseService {

    private final LicenseRepository repo;
    private final ArtistClient artistClient;
    private final PortfolioClient portfolioClient;
    private final NotificationClient notificationClient;
    
    public LicenseResponse request(License license){

        Object artist = artistClient.getArtist(license.getArtistId());

        if(artist == null){
            throw new ResourceNotFoundException("Artist not found");
        }

        Object artwork = portfolioClient.getArtwork(license.getArtworkId());

        if(artwork == null){
            throw new ResourceNotFoundException("Artwork not found");
        }

        license.setStatus(LicenseStatus.REQUESTED);

        License saved = repo.save(license);

        notificationClient.sendRequestNotification();

        LicenseResponse response = new LicenseResponse();
        response.setId(saved.getId());
        response.setStatus(saved.getStatus().name());
        response.setMessage("License request created");

        return response;
    }

    public LicenseResponse approve(Long id){

        License license = repo.findById(id)
                .orElseThrow(() -> 
                    new ResourceNotFoundException("License not found"));

        license.setStatus(LicenseStatus.APPROVED);

        License saved = repo.save(license);

        notificationClient.sendApprovedNotification();

        LicenseResponse response = new LicenseResponse();
        response.setId(saved.getId());
        response.setStatus(saved.getStatus().name());
        response.setMessage("License approved successfully");

        return response;
    }
    
    public List<License> getAll(){
        return repo.findAll();
    }

    public List<License> byArtist(Long artistId){
        return repo.findByArtistId(artistId);
    }

    public List<License> byStatus(LicenseStatus status){
        return repo.findByStatus(status);
    }
}