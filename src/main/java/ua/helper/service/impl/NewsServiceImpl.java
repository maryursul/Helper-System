package ua.helper.service.impl;

import static ua.helper.constants.ErrorMessages.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.helper.domain.NewsDTO;
import ua.helper.entity.NewsEntity;
import ua.helper.exceptions.NewsServiceException;
import ua.helper.repository.NewsRepository;
import ua.helper.service.NewsService;
import ua.helper.utils.ObjectMapperUtils;
import ua.helper.utils.StringUtils;

@Service
public class NewsServiceImpl implements NewsService {
	@Autowired
	private NewsRepository newsRepository;
	@Autowired
	private ObjectMapperUtils modelMapper;
	@Autowired
	private StringUtils stringUtils;
	
	@Override
	public void save(NewsDTO dto) {
		String newsId = stringUtils.generate();
		if(!newsRepository.existsByNewsId(newsId)) {
		NewsEntity entity = modelMapper.map(dto, NewsEntity.class);
		entity.setNewsId(newsId);
		System.out.println(dto.getCategory().getId());
		newsRepository.save(entity);
		} else {
			throw new NewsServiceException(RECORD_ALREDY_EXIST);
		}	
	}
	
	@Override
	public List<NewsDTO> findAllNews() {
		List<NewsEntity> entity = newsRepository.findAll();
		List<NewsDTO> dto = modelMapper.mapAll(entity, NewsDTO.class);
		return dto;
	}
	@Override
	public NewsDTO findByid(Long id) {
		NewsEntity entity = newsRepository.findById(id).get();
		return modelMapper.map(entity, NewsDTO.class);
	}
	@Override
	public void update(NewsDTO dto) {
		newsRepository.save(modelMapper.map(dto, NewsEntity.class));
		
	}
	@Override
	public void delete(Long id) {
		newsRepository.deleteById(id);
		
	}

	@Override
	public List<NewsDTO> findSport() {
		List<NewsEntity> entity = newsRepository.findSport();
		List<NewsDTO> dto = modelMapper.mapAll(entity, NewsDTO.class);
		return dto;
	}

	@Override
	public List<NewsDTO> findCulture() {
		List<NewsEntity> entity = newsRepository.findCulture();
		List<NewsDTO> dto = modelMapper.mapAll(entity, NewsDTO.class);
		return dto;
	}

	@Override
	public List<NewsDTO> findPolitics() {
		List<NewsEntity> entity = newsRepository.findPolitics();
		List<NewsDTO> dto = modelMapper.mapAll(entity, NewsDTO.class);
		return dto;
	}
	
	
	
	
	
	

}
