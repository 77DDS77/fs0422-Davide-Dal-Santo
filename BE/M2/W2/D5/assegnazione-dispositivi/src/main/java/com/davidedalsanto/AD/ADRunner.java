package com.davidedalsanto.AD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Component;

import com.davidedalsanto.AD.config.ConfigTest;
import com.davidedalsanto.AD.models.Device;
import com.davidedalsanto.AD.models.Role;
import com.davidedalsanto.AD.models.User;
import com.davidedalsanto.AD.services.DeviceService;
import com.davidedalsanto.AD.services.RoleService;
import com.davidedalsanto.AD.services.UserService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ADRunner implements CommandLineRunner {

	@Autowired
	UserService us;

	@Autowired
	DeviceService ds;

	@Autowired
	RoleService rs;

	@Override
	public void run(String... args) throws Exception {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigTest.class);

		// ROLES
		rs.create(ctx.getBean("adminRole", Role.class));
		rs.create(ctx.getBean("userRole", Role.class));

		// USERS
		us.create(ctx.getBean("userAdmin", User.class));
		us.create(ctx.getBean("userUser", User.class));

		// DEVICES
		ds.create(ctx.getBean("tablet", Device.class));
		ds.create(ctx.getBean("smartphone", Device.class));
		ds.create(ctx.getBean("laptop", Device.class));

		((AbstractApplicationContext) ctx).close();
	}

}
