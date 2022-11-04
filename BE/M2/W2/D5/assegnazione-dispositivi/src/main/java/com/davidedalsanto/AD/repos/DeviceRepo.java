package com.davidedalsanto.AD.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.davidedalsanto.AD.models.Device;

@Repository
public interface DeviceRepo extends JpaRepository<Device, Long>{

	
}
