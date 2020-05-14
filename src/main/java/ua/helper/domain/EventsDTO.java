package ua.helper.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.helper.entity.ActionEntity;
import ua.helper.entity.LocationEntity;
import ua.helper.entity.UserEntity;

@Getter
@Setter
@NoArgsConstructor

public class EventsDTO {
	private Long id;
	
	private String eventId;
	
	private String eventName;

	private String eventDescription;
	
	private Date date;
	
	private LocationDTO location;
	

	private ActionDTO action;

	
	private UserDTO user;

}
