package ua.helper.service;

import java.util.List;

import ua.helper.domain.ActionDTO;
import ua.helper.entity.ActionEntity;

public interface ActionService {
	
	void saveAction(ActionDTO dto);
	
	List<ActionDTO> findAllActions ();
	
	ActionDTO findById(Long id);
	
	void updateAction(ActionDTO dto);
	
	void deleteAction(Long id);

}
