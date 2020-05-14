package ua.helper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.devtools.restart.RestartScope;
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

import ua.helper.domain.ActionDTO;
import ua.helper.service.ActionService;

@RestController
@RequestMapping("/actions")
public class ActionController {
	
	@Autowired
	private ActionService actionService;
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody ActionDTO dto){
		actionService.saveAction(dto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
		
	}
	@GetMapping
	public ResponseEntity<List<ActionDTO>> getAll(){
		List<ActionDTO> dto = actionService.findAllActions();
		return new ResponseEntity<List<ActionDTO>>(dto , HttpStatus.OK);
		
	}
	@GetMapping("/{actionId}")
	public ResponseEntity<ActionDTO> findById(@PathVariable("actionId") Long id){
		ActionDTO dto = actionService.findById(id);
		return new ResponseEntity<ActionDTO>(dto , HttpStatus.OK);
	}
	@PutMapping("/update/{actionId}")
	public ResponseEntity<Void> update(@PathVariable("actionId") Long id, @RequestBody ActionDTO dto){
		ActionDTO dtoFromDB = actionService.findById(id);
		if(dtoFromDB != null) {
			dto.setId(id);
			actionService.updateAction(dto);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	@DeleteMapping("/delete/{actionId}")
	public ResponseEntity<ActionDTO> delete(@PathVariable("actionId") Long id){
		ActionDTO dto = actionService.findById(id);
		if(dto != null) {
			actionService.deleteAction(id);
			return new ResponseEntity<ActionDTO>(dto , HttpStatus.OK);
		}
		return new ResponseEntity<ActionDTO>(dto , HttpStatus.NOT_FOUND);
	}

}
