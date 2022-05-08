package com.zensar.login.service;

import java.util.List;

import com.zensar.login.Dto.LoginDto;

public interface LoginService {
	
	List<LoginDto> getAllUsers(String username,String password);
	LoginDto registerUser( LoginDto user);
	String loginUser( LoginDto user );
	boolean logoutUser( long id1, String username, String password);
	//List<LoginDto> getAllUsers();

}