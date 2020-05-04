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
import tr.com.melihhilmiuludag.student.proj.domain.dtos.StudentListDto;
import tr.com.melihhilmiuludag.student.proj.domain.entities.Student;
import tr.com.melihhilmiuludag.student.proj.domain.entities.StudentDetail;
import tr.com.melihhilmiuludag.student.proj.repository.StudentDetailRepository;
import tr.com.melihhilmiuludag.student.proj.repository.StudentRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author muludag on 3.05.2020
 */
@Slf4j
@RunWith(MockitoJUnitRunner.class)
class StudentServiceImplTest {
	static int listSize;
	@Mock
	StudentRepository studentRepository;
	@Mock
	StudentDetailRepository studentDetailRepository;

	@InjectMocks
	StudentServiceImpl studentService;

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
	void create() {
		Mockito.when(studentRepository.save(entity())).thenReturn(entity());
		StudentDto localDto = studentService.create(studentDto());
		Assert.assertNotNull(localDto);
	}

	@Test
	void createStudentAndDetail() {
		Mockito.when(studentRepository.save(entity())).thenReturn(entity());
		Mockito.when(studentDetailRepository.save(studentDetailEntity())).thenReturn(studentDetailEntity());
		StudentDto studentDtoLocal = studentService.create(studentDto());
		StudentDetail studentDetailLocal = studentDetailRepository.save(studentDetailEntity());
		Assert.assertNotNull(studentDtoLocal);
		Assert.assertNotNull(studentDetailLocal);
	}

	@Test
	void isMailRegister() {
		Mockito.when(studentRepository.findByMail(entity().getMail())).thenReturn(entity());
		boolean localData = studentService.isMailRegister(entity().getMail());
		Assert.assertNotNull(localData);
	}

	@Test
	void list() {
		Mockito.when(studentRepository.findAll()).thenReturn(entityList());
		List<StudentDto> localList = studentService.list();
		Assert.assertEquals(listSize, localList.size());
	}


	@Test
	void delete() {
//		Mockito.doNothing().when(studentRepository).deleteById("1");
//		Mockito.when(studentRepository.findById("1")).thenReturn(Optional.of(entity()));
//		studentService.delete("1");
//		Mockito.verify(studentRepository, Mockito.times(1)).deleteById("1");
	}

	@Test
	void update() {
		Mockito.when(studentRepository.findById(entity().getId())).thenReturn(Optional.of(entity()));
		Mockito.when(studentRepository.save(entity())).thenReturn(entity());
		Mockito.when(studentRepository.findAllByMail(entity().getMail())).thenReturn(entityList());
		studentService.maskPhoneNumberControl("**55", entity());
		studentService.update(studentListDto());
//		Mockito.verify(studentRepository, Mockito.times(1)).save(entity());
//		Mockito.verify(studentRepository, Mockito.times(1)).findById(entity().getId());
	}

	@Test
	void maskPhoneNumberControl() {
		boolean whatIsData = studentService.maskPhoneNumberControl("**55", entity());
		Assert.assertTrue(whatIsData);
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