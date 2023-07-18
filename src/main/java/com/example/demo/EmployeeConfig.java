//package com.example.demo;
//
//import java.time.LocalDate;
//import java.util.List;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.example.demo.EmployeeClass.*;
//
//@Configuration
//public class EmployeeConfig {
//	
//	@Bean
//	CommandLineRunner commandLineRunner(EmployeeRepo employeeRepo) {
//		return args -> {
//			Employee sep = new Employee(
//					"Sepehr Rajabian",
//					"sepehr_rajabian@manulife.com", 
//					LocalDate.of(2023, 5, 8),
//					LocalDate.of(2004, 2, 26)
//			);
//			Employee john = new Employee(
//					"John Doe",
//					"john_doe@manulife.com",
//					LocalDate.of(2023, 5, 8),
//					LocalDate.of(2002, 1, 2)
//			);
//			employeeRepo.saveAll(List.of(sep,john));
//		};
//	}
//}
