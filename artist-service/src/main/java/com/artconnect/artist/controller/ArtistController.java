package com.artconnect.artist.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.artconnect.artist.entity.Artist;
import com.artconnect.artist.service.ArtistService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/artist")
@RequiredArgsConstructor
public class ArtistController {

    private final ArtistService service;

    @PostMapping
    public Artist create(@RequestBody Artist artist) {
        return service.save(artist);
    }

    @GetMapping
    public List<Artist> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Artist getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}