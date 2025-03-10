package com.gaurav.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="employee")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int eid;
	@Max(value=18,message="age should be greater than 18")
	private int age;
	@Pattern(regexp = "[a-z]{1,20}",message="name should be between 1 and 20")
	private String name;
	@Pattern(regexp = "[a-z]{3,20}",message="location should be between 1 and 20")
	private String location;
}
