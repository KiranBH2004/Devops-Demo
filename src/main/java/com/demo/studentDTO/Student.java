package com.demo.studentDTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;


@Data
public class Student {
	
	private int id;
	private String name;
	private double marks;
	private String mail;                //@JsonProperty("email")
	
	

}
