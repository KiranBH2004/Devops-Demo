package com.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class StudentEntity {
	
	@Id
	@GeneratedValue
	private int id;
	@Column(name="S_Name")
	@NotBlank(message="Name Cannot be Empty")
	private String name;
	private double marks;
	@NotBlank(message="Email Cannot be Empty")
	@Email(message="Please Enter a valid Email")
	private String mail;
	
	
	// @Size(min=3 , max=30 , message="should be with in 3 to 30 characters")
	// private String name;
	
	// @Min(value=18 , message = "Age must be at least 18")
	// @Max(value=60 ,  message = "Age cannot be greater than 60")
	// @Positive     -> only numbers greater than > 0
	// @PositiveOrZero  -> only numbers greater than equals to >= 0
	// private int age;
	
	// private long phone;
	//@Pattern(regexp="//d{10}" , message="Phone number must contain exactly 10 digits")
	// ->  /d : only numbers from 0-9 and {10} : exactly 10 elements
	
	// @Negative(message = "Temperature must be negative")
	// @NegativeOrZero
	// private int temperature;
	
	// @NotNull
	// @NotEmpty
	
	// @Past
	// @PastOrPresent
	
	// @FutureOrPresent
	// @Future
	
	//Nested Validition Object within Object Valiadition
	
	/* public class Student {

	    @NotBlank
	    private String name;

	    @Valid                  Here spring seas @valid and says oh i need to validate the inner object also.
	    private Address address;

	}
	public class Address {

	    @NotBlank
	    private String city;

	    @NotBlank
	    private String state;

	}     */
	

}
