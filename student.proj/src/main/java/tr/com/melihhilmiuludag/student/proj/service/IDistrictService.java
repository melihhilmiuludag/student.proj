package tr.com.melihhilmiuludag.student.proj.service;

import tr.com.melihhilmiuludag.student.proj.domain.dtos.DistrictDto;

import java.util.List;

/**
 * @author muludag on 3.05.2020
 */
public interface IDistrictService {
	List<DistrictDto> findAllByCityId(int cityId);
	List<DistrictDto> findAll();
}
