package com.springsecurity.springsecurityexample.controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "consumer")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Consumer {
	
    public Consumer(String string, String string2, String string3) {
		// TODO Auto-generated constructor stub
    	this.username=string2;
    	this.password=string3;
    	this.role=string3;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="user_name")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="role")
    private String role;

    // Default constructor and other methods

    // Getters and setters

   
}

