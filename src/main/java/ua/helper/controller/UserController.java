package ua.helper.controller;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.helper.domain.UserDTO;
import ua.helper.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {
	@Autowired
	private UserService userService;
	@PostMapping
	public ResponseEntity<Void> save(@RequestBody UserDTO dto){
		userService.save(dto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){
		List<UserDTO> dto = userService.findAllUsers();
		return new ResponseEntity<List<UserDTO>>(dto , HttpStatus.OK);
	}
	@GetMapping("/{userId}")
	public ResponseEntity<UserDTO> findById(@PathVariable("userId") Long id){
		UserDTO dto = userService.findById(id);
		return new ResponseEntity<UserDTO>(dto , HttpStatus.OK);
	}
	@PutMapping("/update/{userId}")
	public ResponseEntity<Void> update(@PathVariable("userId") Long id, @RequestBody UserDTO dto ){
		UserDTO dtoFromDB = userService.findById(id);
		if(dtoFromDB != null) {
			dto.setId(id);
			userService.upate(dto);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<UserDTO> delete(@PathVariable("userId") Long id){
		UserDTO dto = userService.findById(id);
		if(dto != null) {
			userService.delete(id);
			return new ResponseEntity<UserDTO>(dto , HttpStatus.OK);
		}
		return new ResponseEntity<UserDTO>(dto , HttpStatus.NOT_FOUND);
	}

}
