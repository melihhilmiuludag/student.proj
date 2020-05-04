package tr.com.melihhilmiuludag.student.proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.melihhilmiuludag.student.proj.domain.entities.District;

import java.util.List;

/**
 * @author muludag on 3.05.2020
 */
public interface DistrictRepository extends JpaRepository<District, Integer> {
	List<District> findAllByCityId(int cityId);
}
