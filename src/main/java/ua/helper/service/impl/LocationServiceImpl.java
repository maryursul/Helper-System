package ua.helper.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.helper.domain.LocationDTO;
import ua.helper.entity.LocationEntity;
import ua.helper.repository.LocationRepository;
import ua.helper.service.LocationService;
import ua.helper.utils.ObjectMapperUtils;

@Service
public class LocationServiceImpl implements LocationService {
	
	@Autowired
	private LocationRepository locationRepository;
	@Autowired
	private ObjectMapperUtils modelMapper;
	@Override
	public void saveLocation(LocationDTO dto) {
		LocationEntity entity = modelMapper.map(dto , LocationEntity.class);
		locationRepository.save(entity);
	}
	@Override
	public LocationDTO findByid(Long id) {
		LocationEntity entity = locationRepository.findById(id).get();
		return modelMapper.map(entity , LocationDTO.class);
	}
	@Override
	public List<LocationDTO> findAllLocations() {
		List<LocationEntity> entity = locationRepository.findAll();
		List<LocationDTO> dto = modelMapper.mapAll(entity, LocationDTO.class);
		return dto;
	}
	@Override
	public void updateLocation(LocationDTO dto) {
		locationRepository.save(modelMapper.map(dto, LocationEntity.class));
		
	}
	@Override
	public void delete(Long id) {
	locationRepository.deleteById(id);
		
	}
	
	

}
