package com.artconnect.artist.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.artconnect.artist.entity.Artist;
import com.artconnect.artist.repository.ArtistRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ArtistService {

    private final ArtistRepository repo;

    public Artist save(Artist artist) {
        return repo.save(artist);
    }

    public List<Artist> getAll() {
        return repo.findAll();
    }

    public Artist getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}