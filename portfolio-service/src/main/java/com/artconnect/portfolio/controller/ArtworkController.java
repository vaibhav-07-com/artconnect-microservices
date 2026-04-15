package com.artconnect.portfolio.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.artconnect.portfolio.dto.ArtworkResponse;
import com.artconnect.portfolio.entity.Artwork;
import com.artconnect.portfolio.service.ArtworkService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/portfolio")
public class ArtworkController {

    private final ArtworkService service;

//    @PostMapping
//    public Artwork create(@RequestBody Artwork artwork){
//        return service.save(artwork);
//    }

    @GetMapping
    public List<ArtworkResponse> getAll(){
        return service.getAll();
    }

    @GetMapping("/artist/{artistId}")
    public List<ArtworkResponse> byArtist(@PathVariable Long artistId){
        return service.getByArtist(artistId);
    }
    
    @GetMapping("/{id}")
    public ArtworkResponse getById(@PathVariable Long id){
        return service.getById(id);
    }
    
    @GetMapping("/collection/{name}")
    public List<ArtworkResponse> byCollection(@PathVariable String name){
        return service.byCollection(name);
    }
    
    @PostMapping
    public ArtworkResponse save(
            @RequestParam String title,
            @RequestParam String description,
            @RequestParam Long artistId,
            @RequestParam String tags,
            @RequestParam String collection,
            @RequestParam MultipartFile file
    ){
        return service.save(title, description, artistId, tags, collection, file);
    }
}
