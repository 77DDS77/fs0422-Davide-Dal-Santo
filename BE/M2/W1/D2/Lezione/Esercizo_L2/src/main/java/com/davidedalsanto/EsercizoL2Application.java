package com.davidedalsanto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.davidedalsanto.classes.JavaStudent;
import com.davidedalsanto.classes.ReactStudent;
import com.davidedalsanto.config.Config_;

@SpringBootApplication
public class EsercizoL2Application {

	public static void main(String[] args) {
		SpringApplication.run(EsercizoL2Application.class, args);
		
		ApplicationContext ac = new AnnotationConfigApplicationContext(Config_.class);
		
		JavaStudent js1 =  ac.getBean("getJavaStudent", JavaStudent.class);
		js1.hello();
		System.out.println(js1.getTopics());
		
		ReactStudent rs1 = ac.getBean("getReactStudent", ReactStudent.class);
		rs1.hello();
		
		((AnnotationConfigApplicationContext)ac).close();
				
	}
	
	

}
