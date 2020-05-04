package tr.com.melihhilmiuludag.student.proj.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import tr.com.melihhilmiuludag.student.proj.utils.valid.annotations.Email;
import tr.com.melihhilmiuludag.student.proj.utils.valid.annotations.PhoneNumber;

import javax.inject.Named;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author muludag on 2.05.2020
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Named
@Scope("view-screen")
public class StudentDto {
	private String id;
	@NotNull(message = "Name is not null!")
	@NotEmpty(message = "Name is not empty!")
	private String name;
	@NotNull(message = "Surname is not null!")
	@NotEmpty(message = "Surname is not empty!")
	private String surname;
	@Email(message = "server says: must be a valid email")
	private String mail;
	@PhoneNumber(message = "server says: must be a valid phone number")
	private String phoneNumber;
	@NotNull(message = "City is not null!")
	private int city;
	@NotNull(message = "District is not null!")
	private int district;
	@NotNull(message = "Description is not null!")
	@NotEmpty(message = "Description is not empty!")
	private String desc;
}
