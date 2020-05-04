package tr.com.melihhilmiuludag.student.proj.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tr.com.melihhilmiuludag.student.proj.domain.dtos.StudentDto;
import tr.com.melihhilmiuludag.student.proj.domain.entities.StudentDetail;
import tr.com.melihhilmiuludag.student.proj.repository.StudentDetailRepository;
import tr.com.melihhilmiuludag.student.proj.service.IStudentDetailService;

import javax.transaction.Transactional;

/**
 * @author muludag on 3.05.2020
 */
@Repository
@Slf4j
public class StudentDetailServiceImpl implements IStudentDetailService {
	final StudentDetailRepository studentDetailRepository;

	@Autowired
	public StudentDetailServiceImpl(StudentDetailRepository studentDetailRepository) {
		this.studentDetailRepository = studentDetailRepository;
	}

	@Override
	@Transactional
	public StudentDto save(StudentDto requestDto) {
		StudentDetail studentDetail = new StudentDetail();
		studentDetail.setCity(requestDto.getCity());
		studentDetail.setDistrict(requestDto.getDistrict());
		studentDetail.setStudentId(requestDto.getId());
		studentDetail.setDesc(requestDto.getDesc());
		studentDetailRepository.save(studentDetail);
		return requestDto;
	}

	@Override
	public void deleteByStudentId(String studentId) {
		studentDetailRepository.deleteByStudentId(studentId);
	}

}
