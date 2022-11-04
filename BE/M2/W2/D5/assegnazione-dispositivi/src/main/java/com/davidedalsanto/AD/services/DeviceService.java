package com.davidedalsanto.AD.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.davidedalsanto.AD.exceptions.DeviceNotFoundException;
import com.davidedalsanto.AD.exceptions.UpdateException;
import com.davidedalsanto.AD.exceptions.UserNotFoundException;
import com.davidedalsanto.AD.models.Device;
import com.davidedalsanto.AD.models.DeviceStatus;
import com.davidedalsanto.AD.models.User;
import com.davidedalsanto.AD.repos.DeviceRepo;

@Service
public class DeviceService {

	@Autowired
	private DeviceRepo dr;
	
	@Autowired
	private UserService us;
	
	public Iterable<Device> searchAllDevices() {
		return dr.findAll();
	}
	
	public Page<Device> searchAllDevicesPageable(Pageable p) {
		return dr.findAll(p);
	}

	public Device create(Device device) {
		return dr.save(device);
	}

	public Device findById(long id) throws DeviceNotFoundException {
		Device found = dr.findById(id).get();
		if(found != null) {
			return found;
		}else {
			throw new DeviceNotFoundException();
		}
	}

	public Device update(Long id, Device device) throws UpdateException {
		Optional<Device> devOpt = dr.findById(id);

		if (devOpt.isPresent()) {
			Device dev = devOpt.get();
			dev.setStatus(device.getStatus());
			dev.setUser(device.getUser());
			dr.save(dev);
			return dev;
		} else {
			throw new UpdateException();
		}

	}
	
	public void delete(long id) {
		dr.deleteById(id);
	}
	
	public User assignDevicetoUser(long userId, long deviceId) throws DeviceNotFoundException, UserNotFoundException {
		User userFound = us.findById(userId);
		
		if(userFound != null) {
			Device devFound = findById(deviceId);
			if(devFound != null) {
				devFound.setStatus(DeviceStatus.ASSIGNED);
				List<Device> userDevices = userFound.getDevices();
				userDevices.add(devFound);
				userFound.setDevices(userDevices);
				create(devFound);//save
				us.create(userFound);//save
				System.out.println("***************************************");
				System.out.println(userDevices);
				System.out.println("***************************************");
				return userFound;
			}else {
				throw new DeviceNotFoundException();
			}
		}else {
			throw new UserNotFoundException(); 
		}
	}
	
	
}
