package com.artconnect.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.artconnect.portfolio.entity.Artwork;

public interface ArtworkRepository extends JpaRepository<Artwork, Long> {
}
