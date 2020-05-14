package ua.helper.service;

import java.util.List;

import ua.helper.domain.LocationDTO;

public interface LocationService {
	
	void saveLocation(LocationDTO dto);
	
	LocationDTO findByid(Long id);
	
	List<LocationDTO> findAllLocations();
	
	void updateLocation(LocationDTO dto);
	
	void delete(Long id);

}
