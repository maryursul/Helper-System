package ua.helper.domain;

import java.sql.Date;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.helper.entity.BaseEntity;
import ua.helper.entity.EventsEntity;
import ua.helper.entity.UserEntity;
import ua.helper.entity.enums.UserRole;

@Getter
@Setter
@NoArgsConstructor

public class UserDTO {
	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private String username;
	
	private String password;
	
	private Date dayOfBirth;
	
	private List<EventsEntity> events;
	
	private UserEntity user;
	
	private UserRole role;
	
	
}
