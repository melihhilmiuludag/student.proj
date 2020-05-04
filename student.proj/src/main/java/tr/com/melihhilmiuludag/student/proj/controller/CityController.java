package tr.com.melihhilmiuludag.student.proj.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import tr.com.melihhilmiuludag.student.proj.domain.dtos.CityDto;
import tr.com.melihhilmiuludag.student.proj.service.ICityService;
import tr.com.melihhilmiuludag.student.proj.utils.MapUtil;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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
@ManagedBean(name = "cityController")
@Component
public class CityController {
	final ICityService cityService;
	public Map<String, String> citiesMap;

	@Autowired
	public CityController(ICityService cityService) {
		this.cityService = cityService;
	}

	@PostConstruct
	public void init() {
		log.info("init runned cityController");
		this.citiesMap = new HashMap<>();
	}

	public List<CityDto> getCities() {
		return cityService.list();
	}

	public Map<String, String> getCitiesMap() {
		Map<String, String> map = cityService.list().stream()
				.collect(Collectors.toMap(cityDto -> String.valueOf(cityDto.getId()), CityDto::getName));
//		return MapUtil.sortByKeys(map);
		return MapUtil.sortByValue(map);
	}
}
