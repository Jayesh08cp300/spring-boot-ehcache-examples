package com.example;

import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;

@SpringBootApplication
public class ApplicationMain implements CommandLineRunner {

	@Autowired
	private CacheManager cacheManager;

	@Autowired
	private EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(ApplicationMain.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//This will hit the database
		employeeService.getEmployeeById(1L);

		//This will hit the cache - verify the message in console output
		employeeService.getEmployeeById(1L);
	}
}
