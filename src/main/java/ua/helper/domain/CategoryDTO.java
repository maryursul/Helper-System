package ua.helper.domain;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.helper.entity.NewsEntity;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDTO {
	private Long id;
	
	private String name;
	
//	private List<NewsEntity> news;
	
}
