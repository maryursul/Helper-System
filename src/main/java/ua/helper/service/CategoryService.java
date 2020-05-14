package ua.helper.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import ua.helper.domain.CategoryDTO;
import ua.helper.entity.CategoryEntity;

public interface CategoryService {
	
	void saveCategory(CategoryDTO dto);
	
	List<CategoryDTO> findAllCategories();
	
	CategoryDTO findByid(Long id);
	
	void updpateCategory(CategoryDTO dto);
	
	void delete (Long id);
	



}
