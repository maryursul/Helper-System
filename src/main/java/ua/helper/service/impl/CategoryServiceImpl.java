package ua.helper.service.impl;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.helper.domain.CategoryDTO;
import ua.helper.entity.CategoryEntity;
import ua.helper.repository.CategoryRepository;
import ua.helper.service.CategoryService;
import ua.helper.utils.ObjectMapperUtils;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ObjectMapperUtils modelMapper;
	@Override
	public void saveCategory(CategoryDTO dto) {
		CategoryEntity entity = modelMapper.map(dto, CategoryEntity.class);
		categoryRepository.save(entity);
		
	}
	@Override
	public List<CategoryDTO> findAllCategories() {
		List<CategoryEntity> entity = categoryRepository.findAll();
		List<CategoryDTO> dto = modelMapper.mapAll(entity, CategoryDTO.class);
		return dto;
	}
	@Override
	public CategoryDTO findByid(Long id) {
		CategoryEntity entity = categoryRepository.findById(id).get();
		return modelMapper.map(entity, CategoryDTO.class);
	}
	@Override
	public void updpateCategory(CategoryDTO dto) {
		categoryRepository.save(modelMapper.map(dto , CategoryEntity.class));
		
	}
	@Override
	public void delete(Long id) {
		categoryRepository.deleteById(id);
		
	}
//	@Override
//	public List<CategoryDTO> findCulture() {
//		List<CategoryEntity> entity = categoryRepository.findCulture();
//		List<CategoryDTO> dto = modelMapper.mapAll(entity, CategoryDTO.class);
//		return dto;
//	}
//	@Override
//	public List<CategoryDTO> findSport() {
//		List<CategoryEntity> entity = categoryRepository.findSport();
//		List<CategoryDTO> dto = modelMapper.mapAll(entity, CategoryDTO.class);
//		return dto;
//	}
//	@Override
//	public List<CategoryDTO> findPolitics() {
//		List<CategoryEntity> entity = categoryRepository.findPolitics();
//		List<CategoryDTO> dto = modelMapper.mapAll(entity, CategoryDTO.class);
//		return dto;
//	}
//	
	
	

}
