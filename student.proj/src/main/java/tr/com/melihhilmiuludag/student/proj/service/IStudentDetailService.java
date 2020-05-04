package tr.com.melihhilmiuludag.student.proj.service;

import tr.com.melihhilmiuludag.student.proj.domain.dtos.StudentDto;

/**
 * @author muludag on 3.05.2020
 */
public interface IStudentDetailService {
	StudentDto save(StudentDto requestDto);
	void deleteByStudentId(String studentId);
}
