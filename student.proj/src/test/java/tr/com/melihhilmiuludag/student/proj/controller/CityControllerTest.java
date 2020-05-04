package tr.com.melihhilmiuludag.student.proj.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import tr.com.melihhilmiuludag.student.proj.domain.dtos.CityDto;
import tr.com.melihhilmiuludag.student.proj.domain.entities.City;
import tr.com.melihhilmiuludag.student.proj.repository.CityRepository;
import tr.com.melihhilmiuludag.student.proj.service.impl.CityServiceImpl;
import tr.com.melihhilmiuludag.student.proj.utils.MapUtil;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @author muludag on 3.05.2020
 */
@Slf4j
@RunWith(MockitoJUnitRunner.class)
class CityControllerTest {
	static int listSize;
	@InjectMocks
	CityController cityController;
	@Mock
	CityServiceImpl cityService;
	@Mock
	CityRepository cityRepository;

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
	void init() {
	}

	@Test
	void getCities() {
		Mockito.when(cityService.list()).thenReturn(Collections.nCopies(listSize, dto()));
		Mockito.when(cityRepository.findAll()).thenReturn(Collections.nCopies(listSize, e()));
		List<CityDto> localList = cityController.getCities();
		Assert.assertEquals(listSize, localList.size());
	}

	CityDto dto() {
		return new CityDto(1, "Mock");
	}

	City e() {
		City e = new City();
		e.setId(1);
		e.setName("Mock");
		return e;
	}

	@Test
	void getCitiesMap() {
		Mockito.when(cityService.list()).thenReturn(Collections.nCopies(1, dto()));
		Mockito.when(cityRepository.findAll()).thenReturn(Collections.nCopies(1, e()));
		List<CityDto> localList = cityController.getCities();
		Map<String, String> map = localList.stream()
				.collect(Collectors.toMap(cityDto -> String.valueOf(cityDto.getId()), CityDto::getName));
		TreeMap<String, String> thereMap = MapUtil.sortByKeys(map);
		Assert.assertNotEquals(thereMap.size(), listSize);
	}
}