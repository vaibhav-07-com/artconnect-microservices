package com.artconnect.portfolio.dto;

import lombok.Data;

@Data
public class ArtworkResponse {

    private Long id;
    private String title;
    private String tags;
    private String collection;
    private String imageUrl;
    private String description;
    
    
}
