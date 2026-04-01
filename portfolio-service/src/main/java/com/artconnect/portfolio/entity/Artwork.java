package com.artconnect.portfolio.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Artwork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String imageUrl;

    private String tags;

    private Long artistId;
}