package ua.helper.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import ua.helper.domain.CategoryDTO;
import ua.helper.domain.NewsDTO;
import ua.helper.entity.NewsEntity;

public interface NewsService {
	
	void save(NewsDTO dto);
	
	List<NewsDTO> findAllNews();
	
	NewsDTO findByid(Long id);
	
	void update(NewsDTO dto);
	
	void delete(Long id);
	
	List<NewsDTO> findSport();
	
	List<NewsDTO> findCulture();
	
	List<NewsDTO> findPolitics();

}
