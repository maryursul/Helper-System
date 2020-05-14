package ua.helper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListenerMethodProcessor;
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

import ua.helper.domain.EventsDTO;
import ua.helper.entity.EventsEntity;
import ua.helper.service.EventsService;

@RestController
@RequestMapping("/events")
public class EventsController {
	@Autowired
	private EventsService eventsService;
	@PostMapping
	public ResponseEntity<Void> save(@RequestBody EventsDTO dto){
		eventsService.Save(dto);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<List<EventsDTO>> findAll(){
		List<EventsDTO> dto = eventsService.findAllEvents();
		return new ResponseEntity<List<EventsDTO>>(dto , HttpStatus.OK);
	}

	@GetMapping("/{eventId}")
	public ResponseEntity<EventsDTO> findById(@PathVariable("eventId") String eventId){
		EventsDTO dto = eventsService.findById(eventId);
		return new ResponseEntity<EventsDTO>(dto , HttpStatus.OK);	
	}
	@PutMapping("/update/{eventId}")
	public ResponseEntity<Void> update(@PathVariable("eventId") String eventId , @RequestBody EventsDTO dto){
		EventsDTO dtoFromDb = eventsService.findById(eventId);
		if(dtoFromDb != null) {
			dto.setEventId(eventId);
			eventsService.updateEvent(dto);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
//	@DeleteMapping("/delete/{eventId}")
//	public ResponseEntity<EventsDTO> delete(@PathVariable("eventId") Long id){
//		EventsDTO dto= eventsService.findById(id);
//		if(dto != null) {
//			eventsService.delete(id);
//			return new ResponseEntity<EventsDTO>(dto , HttpStatus.OK);
//		}
//		return new ResponseEntity<EventsDTO>(dto , HttpStatus.NOT_FOUND);
//		
//	}
	@DeleteMapping("/deleteBy/{eventId}")
	public ResponseEntity<EventsDTO> deleteBy(@PathVariable("eventId") String eventId){
		EventsDTO dto = eventsService.findById(eventId);
		if(dto == null) {
			eventsService.deleteByEventId(eventId);
			return new ResponseEntity<EventsDTO>(dto , HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<EventsDTO>(dto , HttpStatus.OK);
		
	}
	@GetMapping("/accident")
	public ResponseEntity<List<EventsDTO>> findAccident(){
		List<EventsDTO> dto = eventsService.findAccident();
		
		return new ResponseEntity<List<EventsDTO>>(dto , HttpStatus.OK);
		
	}
	
	@GetMapping("/murder")
	public ResponseEntity<List<EventsDTO>> findMurder(){
		List<EventsDTO> dto = eventsService.findMurder();
		
		return new ResponseEntity<List<EventsDTO>>(dto , HttpStatus.OK);
		
	}
	
	@GetMapping("/robbery")
	public ResponseEntity<List<EventsDTO>> findRobbery(){
		List<EventsDTO> dto = eventsService.findRobbery();
		
		return new ResponseEntity<List<EventsDTO>>(dto , HttpStatus.OK);
		
	}
	
	@GetMapping("/rape")
	public ResponseEntity<List<EventsDTO>> findRape(){
		List<EventsDTO> dto = eventsService.findRape();
		
		return new ResponseEntity<List<EventsDTO>>(dto , HttpStatus.OK);
		
	}
	
	@GetMapping("/fires")
	public ResponseEntity<List<EventsDTO>> findA(){
		List<EventsDTO> dto = eventsService.findFires();
		
		return new ResponseEntity<List<EventsDTO>>(dto , HttpStatus.OK);
		
	}
}
