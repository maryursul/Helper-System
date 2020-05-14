package ua.helper.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.helper.entity.CategoryEntity;
import ua.helper.entity.NewsEntity;

@Getter
@Setter
@NoArgsConstructor

public class NewsDTO {
	@JsonIgnore
	private Long id;
	
	private String newsId;
	
	private String newsName ;
	
	private String description;
	
	private Date date;
	
	private CategoryDTO category;
	



}
