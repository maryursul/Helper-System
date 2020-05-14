package ua.helper.service.impl;

import static ua.helper.constants.ErrorMessages.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListenerMethodProcessor;
import org.springframework.stereotype.Service;

import ua.helper.domain.EventsDTO;
import ua.helper.entity.EventsEntity;
import ua.helper.exceptions.EventNotFoundException;
import ua.helper.exceptions.EventsServiceException;
import ua.helper.repository.CategoryRepository;
import ua.helper.repository.EventsRepository;
import ua.helper.service.EventsService;
import ua.helper.utils.ObjectMapperUtils;
import ua.helper.utils.StringUtils;

@Service
public class EventsServiceImpl implements EventsService {
	@Autowired
	private EventsRepository eventsRepository;
	@Autowired
	private ObjectMapperUtils modelMapper;
	@Autowired
	private StringUtils stringUtils;
	@Override
	public void Save(EventsDTO dto) {
		String eventId = stringUtils.generate();
		if(!eventsRepository.existsByEventId(eventId)) {
		EventsEntity entity = modelMapper.map(dto, EventsEntity.class);
		entity.setEventId(eventId);
		eventsRepository.save(entity);
		}else {
			throw new EventsServiceException(RECORD_ALREDY_EXIST);
		}
	}
	@Override
	public List<EventsDTO> findAllEvents() {
		List<EventsEntity> entity = eventsRepository.findAll();
		List<EventsDTO> dto = modelMapper.mapAll(entity, EventsDTO.class);
		return dto;
	}
	@Override
	public EventsDTO findById(String eventId) {
		EventsEntity entity = eventsRepository.findByEventId(eventId);
		if(entity == null) {
			throw new EventsServiceException(NO_RECORD_FOUND);
		}
		return modelMapper.map(entity, EventsDTO.class);
	}
	@Override
	public void updateEvent(EventsDTO dto) {
		eventsRepository.save(modelMapper.map(dto, EventsEntity.class));
		
	}
	@Override
	public void delete(Long id) {
		eventsRepository.deleteById(id);
		
	}
	
	@Override
	public EventsDTO deleteByEventId(String eventId) {
		EventsEntity entity = eventsRepository.deleteByEventId(eventId);
		if(entity == null) {
			throw new EventsServiceException(NO_RECORD_FOUND);
		}
		return modelMapper.map(entity, EventsDTO.class);
	}
	@Override
	public List<EventsDTO> findAccident() {
		List<EventsEntity> entity = eventsRepository.findAccident();
		List<EventsDTO> dto = modelMapper.mapAll(entity, EventsDTO.class);
		return dto;
	}
	@Override
	public List<EventsDTO> findMurder() {
		List<EventsEntity> entity = eventsRepository.findMurder();
		List<EventsDTO> dto = modelMapper.mapAll(entity, EventsDTO.class);
		return dto;
	}
	@Override
	public List<EventsDTO> findRobbery() {
		List<EventsEntity> entity = eventsRepository.findRobbery();
		List<EventsDTO> dto = modelMapper.mapAll(entity, EventsDTO.class);
		return dto;
	}
	@Override
	public List<EventsDTO> findFires() {
		List<EventsEntity> entity = eventsRepository.findFires();
		List<EventsDTO> dto = modelMapper.mapAll(entity, EventsDTO.class);
		return dto;
	}
	@Override
	public List<EventsDTO> findRape() {
		List<EventsEntity> entity = eventsRepository.findRape();
		List<EventsDTO> dto = modelMapper.mapAll(entity, EventsDTO.class);
		return dto;
	}
	
	
	
	
	

}
