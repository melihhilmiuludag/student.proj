package tr.com.melihhilmiuludag.student.proj.domain.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author muludag on 2.05.2020
 */
@Data
@Entity
@Table(name = "STUDENT")
public class Student {

	@Id
	@NotNull
	@NotEmpty
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Length(min = 36, max = 36)
	@Column(name = "ID", nullable = false)
	private String id;

	@NotNull
	@NotEmpty
	@Length(min = 1, max = 50)
	@Column(name = "NAME", nullable = false)
	private String name;

	@NotNull
	@NotEmpty
	@Length(min = 1, max = 50)
	@Column(name = "SURNAME", nullable = false)
	private String surname;

	@NotNull
	@NotEmpty
	@Length(min = 1, max = 50)
	@Column(name = "MAIL", nullable = false)
	private String mail;

	@NotNull
	@NotEmpty
	@Length(min = 1, max = 13)
	@Column(name = "PHONE_NUMBER", nullable = false)
	private String phoneNumber;

}
