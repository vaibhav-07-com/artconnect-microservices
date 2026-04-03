package com.artconnect.license.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "portfolio-service")
public interface PortfolioClient {

    @GetMapping("/portfolio/{id}")
    Object getArtwork(@PathVariable Long id);
}