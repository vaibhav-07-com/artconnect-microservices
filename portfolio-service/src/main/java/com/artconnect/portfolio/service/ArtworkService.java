package com.artconnect.portfolio.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.artconnect.portfolio.dto.ArtworkResponse;
import com.artconnect.portfolio.entity.Artwork;
import com.artconnect.portfolio.repository.ArtworkRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ArtworkService {

    private final ArtworkRepository repo;

    // 🔁 ENTITY → DTO MAPPER
    private ArtworkResponse toDto(Artwork art) {
        if (art == null) return null;

        ArtworkResponse dto = new ArtworkResponse();
        dto.setId(art.getId());
        dto.setTitle(art.getTitle());
        dto.setDescription(art.getDescription());
        dto.setTags(art.getTags());
        dto.setCollection(art.getCollection());
        dto.setImageUrl(art.getImageUrl());

        return dto;
    }

    // ✅ SAVE ENTITY
    public ArtworkResponse save(Artwork artwork){
        Artwork saved = repo.save(artwork);
        return toDto(saved);
    }

    // ✅ GET ALL
    public List<ArtworkResponse> getAll(){
        return repo.findAll()
                   .stream()
                   .map(this::toDto)
                   .toList();
    }

    // ✅ GET BY ARTIST (optimized)
    public List<ArtworkResponse> getByArtist(Long artistId){
        return repo.findByArtistId(artistId)
                   .stream()
                   .map(this::toDto)
                   .toList();
    }

    // ✅ GET BY ID
    public ArtworkResponse getById(Long id){
        return repo.findById(id)
                   .map(this::toDto)
                   .orElseThrow(() -> new RuntimeException("Artwork not found with id: " + id));
    }

    // ✅ GET BY COLLECTION
    public List<ArtworkResponse> byCollection(String collection){
        return repo.findByCollection(collection)
                   .stream()
                   .map(this::toDto)
                   .toList();
    }

    // ✅ SAVE WITH FILE UPLOAD
    public ArtworkResponse save(String title, String description, Long artistId,
                                String tags, String collection,
                                MultipartFile file){

        String uploadDir = System.getProperty("user.dir") + "/uploads/";
        File dir = new File(uploadDir);

        if (!dir.exists()) {
            dir.mkdirs();
        }

        // ✅ Prevent file overwrite
        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();

        try {
            file.transferTo(new File(uploadDir + fileName));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("File upload failed");
        }

        Artwork art = new Artwork();
        art.setTitle(title);
        art.setArtistId(artistId);
        art.setTags(tags);
        art.setCollection(collection);
        art.setImageUrl(fileName);
        art.setDescription(description);

        Artwork saved = repo.save(art);
        return toDto(saved);
    }
}