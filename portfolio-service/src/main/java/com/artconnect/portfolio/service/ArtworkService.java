package com.artconnect.portfolio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.artconnect.portfolio.entity.Artwork;
import com.artconnect.portfolio.repository.ArtworkRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ArtworkService {

    private final ArtworkRepository repo;

    public Artwork save(Artwork artwork){
        return repo.save(artwork);
    }

    public List<Artwork> getAll(){
        return repo.findAll();
    }

    public List<Artwork> getByArtist(Long artistId){
        return repo.findAll()
                   .stream()
                   .filter(a -> a.getArtistId().equals(artistId))
                   .toList();
    }
    
    public Artwork getById(Long id){
        return repo.findById(id).orElse(null);
    }
}
