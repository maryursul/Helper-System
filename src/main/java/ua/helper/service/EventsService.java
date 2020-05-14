package ua.helper.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import ua.helper.domain.EventsDTO;
import ua.helper.entity.EventsEntity;

public interface EventsService {
	
	void Save(EventsDTO dto);
	
	List<EventsDTO> findAllEvents ();
	
	EventsDTO findById(String eventId);
	
	void updateEvent(EventsDTO dto);
	
	void delete(Long id);
	
	EventsDTO deleteByEventId(String eventId);
	
	
	List<EventsDTO> findAccident();

	List<EventsDTO> findMurder();
	
	List<EventsDTO> findRobbery();
	
	List<EventsDTO> findFires();
	
	List<EventsDTO> findRape();

}
