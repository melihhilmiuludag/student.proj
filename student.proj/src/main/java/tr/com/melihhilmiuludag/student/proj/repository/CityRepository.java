package tr.com.melihhilmiuludag.student.proj.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.melihhilmiuludag.student.proj.domain.entities.City;

import java.util.List;

/**
 * @author muludag on 2.05.2020
 */
public interface CityRepository extends JpaRepository<City, Integer> {
	@Override
	List<City> findAll(Sort sort);
}
