package ua.helper.domain;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.helper.entity.EventsEntity;
@Getter
@Setter
@NoArgsConstructor
public class LocationDTO {
	
	private Long id;

	
private String country;
	
	private String city;
	
	private String street;
	
	private int streetCode;
	
	private int zipCode;
	
	

}
