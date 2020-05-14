package ua.helper.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.helper.entity.enums.UserRole;
@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {
	
	private String firstName;
	
	private String lastName;
	
	private String username;
	
	private String password;
	
	private Date dayOfBirth;
	
	@OneToMany(mappedBy = "user")
	private List<EventsEntity> events;
	
	@OneToMany(mappedBy = "user")
	private List<NewsEntity> news;
	 @Enumerated(EnumType.STRING)
	  private UserRole role;
	
	

}
