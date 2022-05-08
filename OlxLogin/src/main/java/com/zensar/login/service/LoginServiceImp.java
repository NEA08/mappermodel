package com.zensar.login.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.login.Dto.LoginDto;
import com.zensar.login.entity.User;
import com.zensar.login.repository.LoginRepository;

@Service
public class LoginServiceImp implements LoginService{
	
	@Autowired(required=false)
	//without required false in autowired annotation its not recognizing repository check before changing back 
	private LoginRepository loginRepository;
	private ModelMapper modelMapper;
	static  List<LoginDto> users=new ArrayList<LoginDto>();
	static {
		users.add(new LoginDto(1L, "Anand", "Kulkarni", "anand", "anand123", "anand@gmail.com", 12345));
	}
	
	@Override
	public LoginDto registerUser(LoginDto user) {
		User newUser=modelMapper.map(user, User.class);
		User save=loginRepository.save(newUser);
		return modelMapper.map(save, LoginDto.class);
		
	}

	@Override
	public List<LoginDto> getAllUsers(String username,String password) {
		List<User> content=loginRepository.findAll();
		List<LoginDto> userLoginDtos=new ArrayList<LoginDto>();
		for(User login:content) {
			LoginDto dto=modelMapper.map(login, LoginDto.class);
			userLoginDtos.add(dto);
		}
		return userLoginDtos;
	}
	/*@Override
	public List<LoginDto> getAllUsers(String username, String password) {
		if(username.equals("anand")&&password.equals("anand123")) {
		return users;
		}
		return null;
	}
	
	@Override
	public LoginDto registerUser(LoginDto user) {
		users.add(user);
		return user;
	}
*/
	@Override
	public String loginUser(LoginDto user) {
		return user.getUserName()+"\n"+user.getPassword();
	}

	@Override
	public boolean logoutUser(long id1, String username, String password) {
		if(username.equals("anand")&&password.equals("anand123")) {
			for(LoginDto user:users) {
				if(user.getId()==id1) {
					users.remove(user);
					return true;
				}
			}
	}
		return false;
	}
	
	
		/*private LoginDto mapToEntity(LoginDto loginDto) {
		LoginDto newStock= new LoginDto();
		newStock.setFirstName(loginDto.getFirstName());
		newStock.setLastName(loginDto.getLastName());
		newStock.setUserName(loginDto.getUserName());
		return newStock;
		}
		private LoginDto mapToResponse(LoginDto userResponse) {
		LoginDto newUser= new LoginDto();
		newUser.setFirstName(userResponse.getFirstName());
		newUser.setLastName(userResponse.getLastName());
		newUser.setUserName(userResponse.getUserName());
		return newUser;
		}
		
		private LoginDto mapToDto(LoginDto user) {
			LoginDto userResponse=new LoginDto();
		userResponse.setId(user.getId());
		userResponse.setPhone(user.getPhone());
		userResponse.setUserName(user.getUserName());
		userResponse.setPassword(user.getPassword());
		return userResponse;
		}*/

}
