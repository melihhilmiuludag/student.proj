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
import tr.com.melihhilmiuludag.student.proj.domain.dtos.StudentDto;
import tr.com.melihhilmiuludag.student.proj.domain.dtos.StudentListDto;
import tr.com.melihhilmiuludag.student.proj.domain.entities.Student;
import tr.com.melihhilmiuludag.student.proj.domain.entities.StudentDetail;
import tr.com.melihhilmiuludag.student.proj.repository.StudentRepository;
import tr.com.melihhilmiuludag.student.proj.service.IStudentService;

import java.util.Collections;
import java.util.List;

/**
 * @author muludag on 3.05.2020
 */
@Slf4j
@RunWith(MockitoJUnitRunner.class)
class StudentControllerTest {
	static int listSize;
	@InjectMocks
	StudentController studentController;
	@Mock
	IStudentService studentService;
	@Mock
	StudentRepository studentRepository;
	@Mock
	DistrictController districtController;
	StudentDto mappingDto;

	@BeforeEach
	void setUp() {
		log.debug("test started!");
		MockitoAnnotations.initMocks(this);
		listSize = 10;
		this.mappingDto = studentDto();
	}

	@AfterEach
	void tearDown() {
		log.debug("test ended!");
	}

	@Test
	void init() {
		log.info("say hello bro'");
	}

	@Test
	void getMappingDto() {
		Assert.assertNotNull(this.mappingDto);
	}

	@Test
	void create() {
//		Mockito.when(studentService.createStudentAndDetail(Mockito.any())).thenReturn(studentDto());
//		Mockito.doCallRealMethod().when(studentService.isMailRegister(Mockito.any()));
//		studentController.create();
//		Mockito.verify(studentService, Mockito.times(1)).create(studentDto());
	}


	@Test
	void getStudentInfoMap() {
	}

	StudentDto studentDto() {
		StudentDto dto = new StudentDto();
		dto.setSurname("MockName");
		dto.setName("MockName");
		dto.setPhoneNumber("MockNum");
		dto.setCity(-1);
		dto.setDesc("MockDesc");
		dto.setDistrict(-1);
		dto.setId("MockId");
		dto.setMail("MockMail");
		return dto;
	}

	Student entity() {
		Student e = new Student();
		e.setSurname("MockName");
		e.setName("MockName");
		e.setPhoneNumber("MockNum");
		e.setId("MockId");
		e.setMail("MockMail");
		return e;
	}

	StudentDetail studentDetailEntity() {
		StudentDetail e = new StudentDetail();
		e.setDesc("MockDesc");
		e.setStudentId("MockId");
		e.setDistrict(-1);
		e.setCity(-1);
		e.setId("MockId");
		return e;
	}

	StudentListDto studentListDto() {
		StudentListDto dto = new StudentListDto();
		dto.setDesc("MockDesc");
		dto.setDistrict(-1);
		dto.setCity(-1);
		dto.setId("MockId");
		return dto;
	}


	List<StudentDto> studentDtoList() {
		return Collections.nCopies(listSize, studentDto());
	}

	List<StudentListDto> studentListDtoList() {
		return Collections.nCopies(listSize, studentListDto());
	}

	List<Student> entityList() {
		return Collections.nCopies(listSize, entity());
	}
}