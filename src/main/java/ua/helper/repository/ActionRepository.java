package ua.helper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ua.helper.entity.ActionEntity;
@Repository
public interface ActionRepository extends JpaRepository<ActionEntity, Long> {
	

	
}