package tr.com.melihhilmiuludag.student.proj.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tr.com.melihhilmiuludag.student.proj.domain.dtos.DistrictDto;
import tr.com.melihhilmiuludag.student.proj.domain.entities.District;
import tr.com.melihhilmiuludag.student.proj.repository.DistrictRepository;
import tr.com.melihhilmiuludag.student.proj.service.IDistrictService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muludag on 3.05.2020
 */
@Slf4j
@Repository
public class DistrictServiceImpl implements IDistrictService {

	final
	DistrictRepository districtRepository;

	@Autowired
	public DistrictServiceImpl(DistrictRepository districtRepository) {
		this.districtRepository = districtRepository;
	}

	public static DistrictDto toDistrictDto(District e) {
		return new DistrictDto(e.getId(), e.getCityId(), e.getName());
	}

	@Override
	public List<DistrictDto> findAllByCityId(int cityId) {
		List<DistrictDto> returnList = new ArrayList<>();
		districtRepository.findAllByCityId(cityId).stream().forEach(district -> returnList.add(toDistrictDto(district)));
		return returnList;
	}

	@Override
	public List<DistrictDto> findAll() {
		List<DistrictDto> returnList = new ArrayList<>();
		districtRepository.findAll().stream().forEach(district -> returnList.add(toDistrictDto(district)));
		return returnList;
	}
}
