 package ua.helper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.helper.entity.UserEntity;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
	UserEntity findByUsername(String username);

}
