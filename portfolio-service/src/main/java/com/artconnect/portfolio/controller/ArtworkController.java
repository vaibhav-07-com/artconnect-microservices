package com.artconnect.portfolio.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.artconnect.portfolio.entity.Artwork;
import com.artconnect.portfolio.service.ArtworkService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/portfolio")
public class ArtworkController {

    private final ArtworkService service;

    @PostMapping
    public Artwork create(@RequestBody Artwork artwork){
        return service.save(artwork);
    }

    @GetMapping
    public List<Artwork> getAll(){
        return service.getAll();
    }

    @GetMapping("/artist/{artistId}")
    public List<Artwork> byArtist(@PathVariable Long artistId){
        return service.getByArtist(artistId);
    }
}
