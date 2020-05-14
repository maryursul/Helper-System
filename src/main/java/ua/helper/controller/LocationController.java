package ua.helper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import ua.helper.domain.LocationDTO;
import ua.helper.service.LocationService;

@RestController
@RequestMapping("location")
public class LocationController {
	@Autowired
	private LocationService locationService;
	@PostMapping
	public ResponseEntity<Void> save(@RequestBody LocationDTO dto){
		locationService.saveLocation(dto);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<List<LocationDTO>> findAll(){
		List<LocationDTO> dto = locationService.findAllLocations();
		return new ResponseEntity<List<LocationDTO>>(dto, HttpStatus.OK);	
	}
	@GetMapping("/{locationId}")
	public ResponseEntity<LocationDTO> findById(@PathVariable("locatioId") Long id){
		LocationDTO dto = locationService.findByid(id);
		return new ResponseEntity<LocationDTO>(dto, HttpStatus.OK);
		
	}
	@PutMapping("/update/{locationid}")
	public ResponseEntity<Void> update(@PathVariable("locationId") Long id, @RequestBody LocationDTO dto){
		LocationDTO dtoFromDB = locationService.findByid(id);
		if(dtoFromDB != null) {
			dto.setId(id);
			locationService.updateLocation(dto);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	@DeleteMapping("/delete/{locationId}")
	public ResponseEntity<LocationDTO> delete(@PathVariable("locationId") Long  id){
		LocationDTO dto = locationService.findByid(id);
		if(dto != null) {
			locationService.delete(id);
			return new ResponseEntity<LocationDTO>(dto, HttpStatus.OK);
		}
		return new ResponseEntity<LocationDTO>(dto , HttpStatus.NOT_FOUND);
	}
}
