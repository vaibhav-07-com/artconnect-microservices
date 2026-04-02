package com.artconnect.license.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "artist-service")
public interface ArtistClient {

    @GetMapping("/artist/{id}")
    Object getArtist(@PathVariable Long id);
}