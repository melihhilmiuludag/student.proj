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
import tr.com.melihhilmiuludag.student.proj.domain.dtos.StudentDto;
import tr.com.melihhilmiuludag.student.proj.domain.entities.StudentDetail;
import tr.com.melihhilmiuludag.student.proj.repository.StudentDetailRepository;

/**
 * @author muludag on 3.05.2020
 */
@Slf4j
@RunWith(MockitoJUnitRunner.class)
class StudentDetailServiceImplTest {
	static int listSize;
	@Mock
	StudentDetailRepository studentDetailRepository;
	@InjectMocks
	StudentDetailServiceImpl studentDetailService;

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
	void save() {
		Mockito.when(studentDetailRepository.save(entity())).thenReturn(entity());
		StudentDto localDto = studentDetailService.save(dto());
		Assert.assertNotNull(localDto);
	}

	StudentDetail entity() {
		StudentDetail e = new StudentDetail();
		e.setDesc("MockDesc");
		e.setStudentId("MockId");
		e.setDistrict(-1);
		e.setCity(-1);
		e.setId("MockId");
		return e;
	}

	StudentDto dto() {
		StudentDto dto = new StudentDto();
		dto.setDesc("MockDesc");
		dto.setName("MockName");
		dto.setSurname("MockName");
		dto.setDistrict(-1);
		dto.setCity(-1);
		dto.setId("MockId");
		return dto;
	}
}