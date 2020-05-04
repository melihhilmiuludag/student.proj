package tr.com.melihhilmiuludag.student.proj.domain.dtos;

import lombok.*;

/**
 * @author muludag on 2.05.2020
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentListDto {
	private String id;
	private String name;
	private String surname;
	private String mail;
	private String phoneNumber;
	private String cityDesc;
	private int city;
	private int district;
	private String districtDesc;
	private String desc;
}
