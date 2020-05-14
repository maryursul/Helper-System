package ua.helper.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "events")
public class EventsEntity extends BaseEntity {
	@Column(nullable = false, unique = true)
	private String eventId;
	
	@Column(nullable = false , name = "event_name")
	private String eventName;
	
	@Column(name = "event_description")
	private String eventDescription;
	
	private Date date;
	
	@ManyToOne
	@JoinColumn(name = "location_id")
	private LocationEntity location;
	
	@ManyToOne
	@JoinColumn(name = "action_id")
	private ActionEntity action;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;
	


}
