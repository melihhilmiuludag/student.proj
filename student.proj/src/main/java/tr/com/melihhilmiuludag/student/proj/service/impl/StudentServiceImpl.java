package tr.com.melihhilmiuludag.student.proj.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tr.com.melihhilmiuludag.student.proj.domain.dtos.StudentDto;
import tr.com.melihhilmiuludag.student.proj.domain.dtos.StudentListDto;
import tr.com.melihhilmiuludag.student.proj.domain.entities.Student;
import tr.com.melihhilmiuludag.student.proj.repository.StudentRepository;
import tr.com.melihhilmiuludag.student.proj.service.IStudentDetailService;
import tr.com.melihhilmiuludag.student.proj.service.IStudentService;

import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.transaction.Transactional;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author muludag on 2.05.2020
 */
@Slf4j
@Repository
public class StudentServiceImpl implements IStudentService {

	@Resource
	final
	StudentRepository studentRepository;
	@Resource
	final
	IStudentDetailService studentDetailService;


	@Autowired
	public StudentServiceImpl(StudentRepository studentRepository, IStudentDetailService studentDetailService) {
		this.studentRepository = studentRepository;
		this.studentDetailService = studentDetailService;
	}

	public static StudentDto toStudentDto(Student entity, StudentDto requestDto) {
		return new StudentDto(entity.getId(), entity.getName(), entity.getSurname(), entity.getMail(), entity.getPhoneNumber(), requestDto.getCity(), requestDto.getDistrict(), requestDto.getDesc());
	}

	public static StudentDto toStudentDto(Student entity, StudentListDto requestDto) {
		return new StudentDto(entity.getId(), entity.getName(), entity.getSurname(), entity.getMail(), entity.getPhoneNumber(), requestDto.getCity(), requestDto.getDistrict(), requestDto.getDesc());
	}

	public static StudentDto toStudentDto(Student entity) {
		return new StudentDto(entity.getId(), entity.getName(), entity.getSurname(), entity.getMail(), entity.getPhoneNumber(), 0, 0, null);
	}


	@Override
	@Transactional
	public StudentDto create(StudentDto studentDto) {
		Student student = new Student();
		student.setName(studentDto.getName());
		student.setMail(studentDto.getMail());
		student.setPhoneNumber(studentDto.getPhoneNumber());
		student.setSurname(studentDto.getSurname());
		studentRepository.save(student);
		return toStudentDto(student, studentDto);
	}

	@Override
	public StudentDto createStudentAndDetail(StudentDto studentDto) {
		return this.studentDetailService.save(this.create(studentDto));
	}

	@Override
	public boolean isMailRegister(String mail) {
		Student isStudent = studentRepository.findByMail(mail);
		return isStudent != null;
	}

	@Override
	public List<StudentDto> list() {
		List<StudentDto> returnList = new ArrayList<>();
		studentRepository.findAll().stream().forEach(student -> returnList.add(toStudentDto(student)));
		returnList.forEach(studentDto -> studentDto.setPhoneNumber(studentDto.getPhoneNumber().replaceAll(".(?=.{4})", "*")));
		return returnList;
	}

	@Override
	public List<StudentListDto> customList() {
		List<StudentListDto> returnList = new ArrayList<>();
		studentRepository.customList().stream().forEach(student -> returnList.add(student));
		returnList.forEach(studentDto -> studentDto.setPhoneNumber(studentDto.getPhoneNumber().replaceAll(".(?=.{4})", "*")));
		return returnList;

	}

	@Override
	@Transactional
	public void delete(String id) {
		Student e = studentRepository.findById(id).orElseThrow(() -> new InvalidParameterException("There is a problem!"));
		if (e == null) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "Student Registered Previously!");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", "Student Registered Previously!"));
			throw new NullPointerException("Object Is Null!");
		}
		studentDetailService.deleteByStudentId(id);
		studentRepository.deleteById(id);
	}

	@Override
	@Transactional()
	public void update(StudentListDto item) {
		Student e = studentRepository.findById(item.getId()).orElseThrow(() -> new InvalidParameterException("There is a problem!"));
		if (e == null) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "Object Is Null");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", "Object Is Null!"));
			throw new NullPointerException("Object Is Null!");
		}		List<Student> control = studentRepository.findAllByMail(item.getMail());
		if (control.size() >= 1 && !control.get(0).getId().equals(item.getId())) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "Student Registered Previously!");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", "Student Registered Previously!"));
			throw new RuntimeException("There is same record.");
		}
		e.setName(item.getName());
		e.setMail(item.getMail());
		if (maskPhoneNumberControl(item.getPhoneNumber(), e)) e.setPhoneNumber(item.getPhoneNumber());
		e.setSurname(item.getSurname());
		studentRepository.save(e);
	}

	boolean maskPhoneNumberControl(String data, Student e) {
		String controlA = new String("");
		String controlB = e.getPhoneNumber().replaceAll(".(?=.{4})", "*");
		String controlC = e.getPhoneNumber();
		if (data != null && !data.isEmpty()) controlA = data.replaceAll(".(?=.{4})", "*");
		if (controlA.equals(controlB)) {
			return false;
		} else if (controlC.equals(data)) {
			return false;
		}
		return true;
	}
}
