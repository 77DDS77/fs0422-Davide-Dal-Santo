package com.davidedalsanto.AD.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.davidedalsanto.AD.exceptions.DeviceNotFoundException;
import com.davidedalsanto.AD.exceptions.UpdateException;
import com.davidedalsanto.AD.models.Device;
import com.davidedalsanto.AD.services.DeviceService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/devices")
@Slf4j
public class DeviceController {

	@Autowired
	DeviceService ds;
	
	//----------------------GET-------------------
	
	@GetMapping("")//get All
	public ResponseEntity<Iterable<Device>> searchAllDevices(){
		return new ResponseEntity<>(ds.searchAllDevices(), HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")//find By ID
	public ResponseEntity<Device> findById(@PathVariable Long id) {
		try {
			return new ResponseEntity<>( ds.findById(id), HttpStatus.OK);
		} catch (DeviceNotFoundException e) {
			log.error(e.getMessage());
			return new ResponseEntity<>( null, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/pageable")//pageable
	public ResponseEntity<Page<Device>> findAll(Pageable p) {
		Page<Device> findAll = ds.searchAllDevicesPageable(p);

		if (findAll.hasContent()) {
			return new ResponseEntity<>(findAll, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	//----------------------POST-------------------
	
	@PostMapping("")
	public ResponseEntity<Device> create(@RequestBody Device device) {
		try {
			return new ResponseEntity<>(ds.create(device), HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	//----------------------PUT-------------------
	
	@PutMapping("")
	public ResponseEntity<Device> update(long id, Device device) {

		try {
			return new ResponseEntity<>(ds.update(id, device), HttpStatus.OK);
		} catch (UpdateException e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	//----------------------DELETE-------------------
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		try {
			ds.delete(id);
			return new ResponseEntity<>(null, HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

}
