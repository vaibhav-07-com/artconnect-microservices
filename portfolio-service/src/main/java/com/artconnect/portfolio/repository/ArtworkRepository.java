package com.artconnect.portfolio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.artconnect.portfolio.entity.Artwork;

public interface ArtworkRepository extends JpaRepository<Artwork, Long> {
	List<Artwork> findByCollection(String collection);
	List<Artwork> findByArtistId(Long artistId);
}
