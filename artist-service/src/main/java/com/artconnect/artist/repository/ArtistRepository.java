package com.artconnect.artist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.artconnect.artist.entity.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Long> {

}