package tr.com.melihhilmiuludag.student.proj.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import tr.com.melihhilmiuludag.student.proj.domain.dtos.StudentDto;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @author muludag on 3.05.2020
 */
@Slf4j
@RunWith(MockitoJUnitRunner.class)
class MapUtilTest {
	static int listSize;
	@Mock
	MapUtil mapUtil;

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

//	@Test
//	void sortByKeys() {
//		TreeMap<String, String> localMap = mapUtil.sortByKeys(map());
//	}
//
//	TreeMap<String, String> map() {
//		List<StudentDto> list = Collections.nCopies(listSize, studentListDto());
//		Map<String, String> map = list.stream().collect(Collectors.toMap(StudentDto::getId, StudentDto::getMail));
//		return new TreeMap<>(map);
//	}

	StudentDto studentListDto() {
		StudentDto dto = new StudentDto();
		dto.setDesc("MockDesc");
		dto.setDistrict(-1);
		dto.setCity(-1);
		dto.setId("MockId");
		return dto;
	}
}