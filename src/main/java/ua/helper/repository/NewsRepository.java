package ua.helper.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ua.helper.entity.NewsEntity;

@Repository
public interface NewsRepository extends JpaRepository<NewsEntity, Long>{
	
	boolean existsByNewsId(String newsId);
	
	@Query("Select ne from NewsEntity ne where ne.category.name = 'Sport'")
	List<NewsEntity> findSport();
	
	@Query("Select ne from NewsEntity ne where ne.category.name = 'Culture'")
	List<NewsEntity> findCulture();
	
	@Query("Select ne from NewsEntity ne where ne.category.name = 'Politics'")
	List<NewsEntity> findPolitics();

}
