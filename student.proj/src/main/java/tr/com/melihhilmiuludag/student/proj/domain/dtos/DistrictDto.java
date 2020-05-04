package tr.com.melihhilmiuludag.student.proj.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author muludag on 3.05.2020
 */
@Data
@AllArgsConstructor
public class DistrictDto {
	private int id;
	private int cityId;
	private String name;
}
