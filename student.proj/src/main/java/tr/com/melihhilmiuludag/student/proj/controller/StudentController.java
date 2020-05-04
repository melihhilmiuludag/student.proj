package tr.com.melihhilmiuludag.student.proj.controller;

import lombok.extern.slf4j.Slf4j;
import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import tr.com.melihhilmiuludag.student.proj.domain.dtos.DistrictDto;
import tr.com.melihhilmiuludag.student.proj.domain.dtos.StudentDto;
import tr.com.melihhilmiuludag.student.proj.domain.dtos.StudentListDto;
import tr.com.melihhilmiuludag.student.proj.service.IStudentService;
import tr.com.melihhilmiuludag.student.proj.view.MessagesView;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author muludag on 2.05.2020
 */
@Slf4j
@SessionScoped
@Scope("view-screen")
@ManagedBean(name = "studentController")
@Component
public class StudentController implements Serializable {
	private static final long serialVersionUID = 82730276448430283L;
	final IStudentService studentService;
	final DistrictController districtController;
	public StudentDto mappingDto;
	public Map<String, String> districtMap;
	public Map<String, String> studentInfoMap;
	List<StudentListDto> list;

	@Autowired
	public StudentController(IStudentService studentService, DistrictController districtController) {
		this.studentService = studentService;
		this.districtController = districtController;
	}

	@PostConstruct
	public void init() {
		log.info("init runned StudentController ");
		this.mappingDto = new StudentDto();
		this.districtMap = new HashMap<>();
		this.studentInfoMap = new HashMap<>();
		this.list = studentService.customList();
	}

	public StudentDto getMappingDto() {
		return this.mappingDto;
	}

	public void create() {

		if (studentService.isMailRegister(this.mappingDto.getMail())) MessagesView.saveNotMessage();
		else {
			studentService.createStudentAndDetail(this.getMappingDto());
			MessagesView.saveMessage();
			log.debug("created student.");
		}
	}

	public void onCityChange() {
		if (mappingDto.getCity() != 0)
			this.districtMap = districtController.list(mappingDto.getCity()).stream()
					.collect(Collectors.toMap(district -> String.valueOf(district.getId()), DistrictDto::getName));
		else
			this.districtMap = new HashMap<String, String>();
	}

	public void delete(StudentListDto dto) {
		studentService.delete(dto.getId());
		MessagesView.deleteMessage();
		this.list = studentService.customList();
		this.getList();
	}

	public void onRowEdit(RowEditEvent event) {
		StudentListDto studentListDtoItem = (StudentListDto) event.getObject();
		studentService.update(studentListDtoItem);
		MessagesView.updateMessage();
		this.list = studentService.customList();
		this.getList();
	}

	public Map<String, String> getDistrictMap() {
		return this.districtMap;
	}

	public List<StudentListDto> getList() {
		return this.list;
	}

	public Map<String, String> getStudentInfoMap() {
		return this.studentInfoMap = studentService.list().stream()
				.collect(Collectors.toMap(StudentDto::getId, StudentDto::getMail));
	}

}

