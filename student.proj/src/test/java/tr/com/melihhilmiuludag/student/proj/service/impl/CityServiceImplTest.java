package tr.com.melihhilmiuludag.student.proj.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import tr.com.melihhilmiuludag.student.proj.domain.dtos.CityDto;
import tr.com.melihhilmiuludag.student.proj.domain.entities.City;
import tr.com.melihhilmiuludag.student.proj.repository.CityRepository;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;


/**
 * @author muludag on 3.05.2020
 */
@Slf4j
@RunWith(MockitoJUnitRunner.class)
class CityServiceImplTest {

	static int listSize;
	@Mock
	CityRepository cityRepository;
	@InjectMocks
	CityServiceImpl cityService;

	@BeforeEach
	void setUp() {
		log.debug("test started!");
		MockitoAnnotations.initMocks(this);
		listSize = 10;
	}

	@AfterEach
	void tearDown() {
		log.debug("test ended!");
	}

	@Test
	void toCityDto() {
		City e = entityList().get(0) != null ? entityList().get(0) : new City();
		CityDto cityDto = new CityDto(e.getId(), e.getName());
		Assert.assertEquals(cityDto.getId(), e.getId());
		Assert.assertEquals(cityDto.getName(), e.getName());
	}

	@Test
	void list() {
		when(cityRepository.findAll()).thenReturn(entityList());
		List<CityDto> localList = cityService.list();
		Assert.assertEquals(localList.size(), listSize);
	}

	List<CityDto> dtoList() {
		CityDto cityDto = new CityDto(1, "MockCityName");
		return Collections.nCopies(listSize, cityDto);
	}

	List<City> entityList() {
		City e = new City();
		e.setName("MockCityName");
		e.setId(-1);
		return Collections.nCopies(listSize, e);
	}
}