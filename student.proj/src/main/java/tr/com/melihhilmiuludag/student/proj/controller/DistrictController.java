package tr.com.melihhilmiuludag.student.proj.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import tr.com.melihhilmiuludag.student.proj.domain.dtos.DistrictDto;
import tr.com.melihhilmiuludag.student.proj.service.IDistrictService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author muludag on 3.05.2020
 */
@Slf4j
@SessionScoped
@Scope("view-screen")
@ManagedBean(name = "districtController")
@Component
public class DistrictController {

	public Map<String, String> districtMap;
	final IDistrictService service;

	@Autowired
	public DistrictController(IDistrictService service) {
		this.service = service;
	}

	@PostConstruct
	public void init() {
		log.info("init runned districtController");
		this.districtMap = new HashMap<>();
	}
	public List<DistrictDto> list(int cityId){
		return service.findAllByCityId(cityId);
	}

}
