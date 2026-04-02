package com.artconnect.license.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.artconnect.license.client.ArtistClient;
import com.artconnect.license.client.NotificationClient;
import com.artconnect.license.entity.License;
import com.artconnect.license.repository.LicenseRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LicenseService {

    private final LicenseRepository repo;
    private final ArtistClient artistClient;
    private final NotificationClient notificationClient;

    public License request(License license){

        artistClient.getArtist(license.getArtistId());

        license.setStatus("REQUESTED");

        notificationClient.sendRequestNotification();

        return repo.save(license);
    }

    public License approve(Long id){

        License l = repo.findById(id).get();

        l.setStatus("APPROVED");

        notificationClient.sendApprovedNotification();

        return repo.save(l);
    }
    
    public List<License> getAll(){
        return repo.findAll();
    }
}