package ua.helper.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor


public class ActionDTO {
	
	private Long id;
	
	private String actionName;
	
	private String actionDescription;


}
