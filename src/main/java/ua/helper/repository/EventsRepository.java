package ua.helper.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ua.helper.entity.EventsEntity;
@Repository
public interface EventsRepository extends JpaRepository<EventsEntity, Long> {
	
	EventsEntity deleteByEventId(String eventId);
	
	EventsEntity findByEventId(String eventId);
	
	boolean existsByEventId(String eventId);
	
	@Query("Select e from EventsEntity e where e.action.id = 1")
	List<EventsEntity> findAccident();

	@Query("Select e from EventsEntity e where e.action.id = 2")
	List<EventsEntity> findMurder();
	
	@Query("Select e from EventsEntity e where e.action.id = 3")
	List<EventsEntity> findRobbery();
	
	@Query("Select e from EventsEntity e where e.action.id = 4")
	List<EventsEntity> findFires();
	
	@Query("Select e from EventsEntity e where e.action.id = 5")
	List<EventsEntity> findRape();
	
}
