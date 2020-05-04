package tr.com.melihhilmiuludag.student.proj.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tr.com.melihhilmiuludag.student.proj.domain.dtos.CityDto;
import tr.com.melihhilmiuludag.student.proj.domain.entities.City;
import tr.com.melihhilmiuludag.student.proj.repository.CityRepository;
import tr.com.melihhilmiuludag.student.proj.service.ICityService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author muludag on 2.05.2020
 */
@Slf4j
@Repository
public class CityServiceImpl implements ICityService {

	@Resource
	final
	CityRepository cityRepository;

	@Autowired
	public CityServiceImpl(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}

	static CityDto toCityDto(City city) {
		return new CityDto(city.getId(), city.getName());
	}

	@Override
	public List<CityDto> list() {
		List<CityDto> returnList = new ArrayList<>();
		cityRepository.findAll().forEach(city -> returnList.add(toCityDto(city)));
		return returnList;
	}
}
