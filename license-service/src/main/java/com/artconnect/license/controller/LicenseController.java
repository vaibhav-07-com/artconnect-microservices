package com.artconnect.license.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.artconnect.license.dto.LicenseResponse;
import com.artconnect.license.entity.License;
import com.artconnect.license.enums.LicenseStatus;
import com.artconnect.license.service.LicenseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/license")
@RequiredArgsConstructor
public class LicenseController {

    private final LicenseService service;

    @PostMapping("/request")
    public LicenseResponse request(@RequestBody License license){
        return service.request(license);
    }

    @PutMapping("/approve/{id}")
    public LicenseResponse approve(@PathVariable Long id){
        return service.approve(id);
    }

    @GetMapping
    public List<License> getAll(){
        return service.getAll();
    }
    
    @GetMapping("/artist/{artistId}")
    public List<License> byArtist(@PathVariable Long artistId){
        return service.byArtist(artistId);
    }
    
    @GetMapping("/status/{status}")
    public List<License> byStatus(@PathVariable LicenseStatus status){
        return service.byStatus(status);
    }
    
    @GetMapping("/pdf/{id}")
    public ResponseEntity<byte[]> download(@PathVariable Long id){

        byte[] pdf = service.generatePdf(id);

        return ResponseEntity.ok()
                .header("Content-Disposition",
                        "attachment; filename=license.pdf")
                .body(pdf);
    }
    
}