package ua.helper.service.impl;

import java.util.List;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.helper.domain.ActionDTO;
import ua.helper.entity.ActionEntity;
import ua.helper.repository.ActionRepository;
import ua.helper.service.ActionService;
import ua.helper.utils.ObjectMapperUtils;
@Service
public class ActionServiceImpl implements ActionService{
	
	@Autowired
	private ActionRepository actionRepository;
	@Autowired
	private ObjectMapperUtils modelMapper;

	@Override
	public void saveAction(ActionDTO dto) {
		ActionEntity entity = modelMapper.map(dto, ActionEntity.class);
		actionRepository.save(entity);
	}

	@Override
	public List<ActionDTO> findAllActions() {
		List<ActionEntity> entity = actionRepository.findAll();
		List<ActionDTO> dto = modelMapper.mapAll(entity, ActionDTO.class);
		return dto;
	}

	@Override
	public ActionDTO findById(Long id) {
		ActionEntity entity = actionRepository.findById(id).get();
		return modelMapper.map(entity, ActionDTO.class);
	}

	@Override
	public void updateAction(ActionDTO dto) {
		actionRepository.save(modelMapper.map(dto, ActionEntity.class));
		
	}

	@Override
	public void deleteAction(Long id) {
		actionRepository.deleteById(id);
		
	}
	
	

}
