package com.zensar.login.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table

public class User implements Serializable {
	@Id
	private long id;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String email;
	private long phone;

}
