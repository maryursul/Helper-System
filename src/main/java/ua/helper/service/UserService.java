package ua.helper.service;

import java.util.List;

import ua.helper.domain.UserDTO;

public interface UserService {
	
	void save(UserDTO dto);
	
	List<UserDTO> findAllUsers();
	
	UserDTO findById(Long id);
	
	void upate(UserDTO dto);
	
	void delete(Long id);
	
	UserDTO findByUsername(String username);
	
	 String signin(String username, String password);

}
