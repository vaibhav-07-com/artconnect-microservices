package com.artconnect.license.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.artconnect.license.entity.License;
import com.artconnect.license.enums.LicenseStatus;

public interface LicenseRepository extends JpaRepository<License, Long> {
	
	List<License> findByArtistId(Long artistId);

	List<License> findByStatus(LicenseStatus status);
	
}