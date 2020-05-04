package tr.com.melihhilmiuludag.student.proj.service;

import tr.com.melihhilmiuludag.student.proj.domain.dtos.CityDto;

import java.util.List;

/**
 * @author muludag on 2.05.2020
 */
public interface ICityService {
	List<CityDto> list();
}
