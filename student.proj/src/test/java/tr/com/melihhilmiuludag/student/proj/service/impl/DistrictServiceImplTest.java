package tr.com.melihhilmiuludag.student.proj.service.impl;

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
import tr.com.melihhilmiuludag.student.proj.domain.dtos.DistrictDto;
import tr.com.melihhilmiuludag.student.proj.domain.entities.District;
import tr.com.melihhilmiuludag.student.proj.repository.DistrictRepository;

import java.util.Collections;
import java.util.List;

/**
 * @author muludag on 3.05.2020
 */
@Slf4j
@RunWith(MockitoJUnitRunner.class)
class DistrictServiceImplTest {

	static int listSize;
	@Mock
	DistrictRepository districtRepository;
	@InjectMocks
	DistrictServiceImpl districtService;

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
	void toDistrictDto() {
		District e = entityList().get(0) != null ? entityList().get(0) : new District();
		DistrictDto districtDto = new DistrictDto(e.getId(), e.getCityId(), e.getName());
		Assert.assertNotNull(districtDto);
		Assert.assertSame(e.getName(), districtDto.getName());
	}

	@Test
	void findAllByCityId() {
		Mockito.when(districtRepository.findAllByCityId(-1)).thenReturn(entityList());
		List<DistrictDto> localList = districtService.findAllByCityId(-1);
		Assert.assertEquals(localList.size(), listSize);
	}

	@Test
	void findAll() {
		Mockito.when(districtRepository.findAll()).thenReturn(entityList());
		List<DistrictDto> localList = districtService.findAll();
		Assert.assertEquals(localList.size(), listSize);
	}

	List<District> entityList() {
		District e = new District();
		e.setCityId(-1);
		e.setId(-1);
		e.setName("MockDistrictName");
		return Collections.nCopies(listSize, e);
	}
}