package ua.helper.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "news")
public class NewsEntity extends BaseEntity {
	
	@Column(nullable = false , unique = true)
	private String newsId;
	
	private String newsName ;
	
	private String description;
	
	private Date date;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private CategoryEntity category;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;

}
