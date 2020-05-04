package tr.com.melihhilmiuludag.student.proj.service;

import tr.com.melihhilmiuludag.student.proj.domain.dtos.StudentDto;
import tr.com.melihhilmiuludag.student.proj.domain.dtos.StudentListDto;

import java.util.List;

/**
 * @author muludag on 2.05.2020
 */
public interface IStudentService {
	StudentDto create(StudentDto studentDto);
	StudentDto createStudentAndDetail(StudentDto studentDto);
	boolean isMailRegister(String mail);
	List<StudentDto> list();
	List<StudentListDto> customList();
	void delete(String id);
	void update(StudentListDto item);
}
