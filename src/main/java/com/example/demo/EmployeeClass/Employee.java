package com.example.demo.EmployeeClass;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	@Id
	@SequenceGenerator(
			name = "employee_sequence",
			sequenceName = "employee_sequence",
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "employee_sequence"
			
			)
	private long id; 
	
	@NotBlank(message = "Name must be passed.")
	@Length(max = 40, min = 1)
	private String name;
	private String email; 
	@PastOrPresent
	private LocalDate startDate;
	@Past
	private LocalDate dob;
}
