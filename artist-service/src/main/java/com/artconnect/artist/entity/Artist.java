package com.artconnect.artist.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @Column(length = 1000)
    private String bio;

    private String specialty;
}