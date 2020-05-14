package ua.helper.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ua.helper.config.JWT.JWTTokenProvider;
import ua.helper.domain.UserDTO;
import ua.helper.entity.UserEntity;
import ua.helper.entity.enums.UserRole;
import ua.helper.repository.UserRepository;
import ua.helper.service.UserService;
import ua.helper.utils.ObjectMapperUtils;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ObjectMapperUtils modelMapper;
	@Autowired
	private JWTTokenProvider jwtTokenProvider;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private PasswordEncoder encoder;
	@Override
	public void save(UserDTO dto) {
		UserEntity entity = modelMapper.map(dto, UserEntity.class);
		entity.setRole(UserRole.ROLE_USER);
		entity.setPassword(encoder.encode(dto.getPassword()));
		userRepository.save(entity);
	}
	@Override
	public List<UserDTO> findAllUsers() {
		List<UserEntity> entity = userRepository.findAll();
		List<UserDTO> dto = modelMapper.mapAll(entity, UserDTO.class);
		return dto;
	}
	@Override
	public UserDTO findById(Long id) {
		UserEntity entity = userRepository.findById(id).get();
		return modelMapper.map(entity, UserDTO.class);
	}
	@Override
	public void upate(UserDTO dto) {
		userRepository.save(modelMapper.map(dto, UserEntity.class));
	}
	@Override
	public void delete(Long id) {
		userRepository.deleteById(id);
	}
	@Override
	public UserDTO findByUsername(String username) {
		UserEntity entity = userRepository.findByUsername(username);
		UserDTO dto = modelMapper.map(entity, UserDTO.class);
		return dto;
	}
	@Override
	public String signin(String username, String password) {
		
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username , password));

        return jwtTokenProvider.createToken(username , userRepository.findByUsername(username).getRole());
	}
	
	
	

}
