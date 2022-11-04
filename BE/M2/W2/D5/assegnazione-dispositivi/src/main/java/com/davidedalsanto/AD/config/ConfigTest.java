package com.davidedalsanto.AD.config;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.davidedalsanto.AD.models.Device;
import com.davidedalsanto.AD.models.DeviceStatus;
import com.davidedalsanto.AD.models.Laptop;
import com.davidedalsanto.AD.models.Role;
import com.davidedalsanto.AD.models.RoleType;
import com.davidedalsanto.AD.models.Smartphone;
import com.davidedalsanto.AD.models.Tablet;
import com.davidedalsanto.AD.models.User;

@Configuration
public class ConfigTest {

	
	//----------ROLES---------------
	
	@Bean(name = "adminRole")
	public Role newAdminRole() {
		return Role.builder()
				.roleType(RoleType.ROLE_ADMIN)
				.build();
	}
	
	@Bean(name = "userRole")
	public Role newUserRole() {
		return Role.builder()
				.roleType(RoleType.ROLE_USER)
				.build();
	}
	
	//----------USERS---------------
	
	@Bean(name = "userAdmin")
	public User newUser_Admin() {
		
		Set<Role> roles = new HashSet<>();
		roles.add(newAdminRole());
//		List<Device> devices = new ArrayList<>();
//		devices.add(newLaptop());
		
		return User.builder()
				.username("DDS")
				.name("Davide")
				.lastname("Dal Santo")
				.email("dds@dd.com")
				.password("1234")
				.roles(roles)
//				.devices(devices)
				.build();
	}
	
	@Bean(name = "userUser")
	public User newUser_User() {
		Set<Role> roles = new HashSet<>();
		roles.add(newUserRole());
//		List<Device> devices = new ArrayList<>();
//		devices.add(newTablet());
//		devices.add(newSmartphone());		
		
		return User.builder()
				.username("Kyzerein")
				.name("Carisio")
				.lastname("Di Giampietro")
				.email("cari@dd.com")
				.password("1234")
				.roles(roles)
//				.devices(devices)
				.build();
	}
	
	//----------DEVICES---------------
	
	@Bean(name = "tablet")
	@Scope("prototype")
	public Tablet newTablet() {
		new Tablet();
		return Tablet.builder()
				.name("Ipad")
				.status(DeviceStatus.ASSIGNED)
				.user(newUser_Admin())
				.build();
	}
	
	@Bean(name = "smartphone")
	@Scope("prototype")
	public Smartphone newSmartphone() {
		new Smartphone();
		return Smartphone.builder()
				.name("Iphone")
				.status(DeviceStatus.ASSIGNED)
				.user(newUser_Admin())
				.build();
	}
	
	@Bean(name = "laptop")
	@Scope("prototype")
	public Laptop newLaptop() {
		new Laptop();
		return Laptop.builder()
				.name("MacBook")
				.status(DeviceStatus.ASSIGNED)
				.user(newUser_User())
				.build();
	}
}
























