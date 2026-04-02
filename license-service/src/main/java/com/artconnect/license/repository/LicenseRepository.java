package com.artconnect.license.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.artconnect.license.entity.License;

public interface LicenseRepository extends JpaRepository<License, Long> {
}