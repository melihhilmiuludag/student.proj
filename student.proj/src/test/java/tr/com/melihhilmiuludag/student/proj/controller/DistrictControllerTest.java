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
import tr.com.melihhilmiuludag.student.proj.domain.dtos.DistrictDto;
import tr.com.melihhilmiuludag.student.proj.domain.entities.District;
import tr.com.melihhilmiuludag.student.proj.repository.DistrictRepository;
import tr.com.melihhilmiuludag.student.proj.service.impl.DistrictServiceImpl;

import java.util.Collections;
import java.util.List;

/**
 * @author muludag on 3.05.2020
 */
@Slf4j
@RunWith(MockitoJUnitRunner.class)
class DistrictControllerTest {
	static int listSize;
	@InjectMocks
	DistrictController controller;
	@Mock
	DistrictServiceImpl districtService;
	@Mock
	DistrictRepository districtRepository;


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
		log.info("say hello");
	}

	@Test
	void list() {
		Mockito.when(districtService.findAllByCityId(1)).thenReturn(Collections.nCopies(listSize, districtDto()));
		Mockito.when(districtRepository.findAllByCityId(1)).thenReturn(Collections.nCopies(listSize, entity()));
		List<DistrictDto> localList = controller.list(1);
		Assert.assertEquals(listSize, localList.size());
	}

	District entity() {
		District e = new District();
		e.setName("Mock");
		e.setId(1);
		e.setCityId(1);
		return e;
	}

	DistrictDto districtDto() {
		return new DistrictDto(1, 1, "Mock");
	}
}