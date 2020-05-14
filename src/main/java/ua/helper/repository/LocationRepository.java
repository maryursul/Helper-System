package ua.helper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.helper.entity.LocationEntity;
@Repository
public interface LocationRepository extends JpaRepository<LocationEntity, Long> {

}
