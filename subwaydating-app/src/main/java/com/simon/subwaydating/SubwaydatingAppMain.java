package com.simon.subwaydating;

import com.simon.subwaydating.controller.UserController;
import com.simon.subwaydating.engine.util.ApplicationContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan("com.simon.subwaydating.engine")
@ComponentScan(basePackageClasses = UserController.class)
//@EnableScheduling
//@EnableTransactionManagement
//@EnableAutoConfiguration
//@ComponentScan("com.creditease.vehicle.loan")
//@ServletComponentScan
public class SubwaydatingAppMain {

	public static void main(String[] args) {
		SpringApplication.run(SubwaydatingAppMain.class, args);
	}

	/**
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(SubwaydatingAppMain.class, args);
		ApplicationContextUtil.setApplicationContext(applicationContext);
	}*/
}
