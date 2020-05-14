package ua.helper.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "category")
public class CategoryEntity extends BaseEntity {
	
	private String name;
	
//	@OneToMany(mappedBy = "category")
//	private List<NewsEntity> news;

}
