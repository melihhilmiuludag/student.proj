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
@Table(name = "STUDENT_DETAIL")
public class StudentDetail {

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
	@Length(min = 36, max = 36)
	@Column(name = "STUDENT_ID", nullable = false)
	private String studentId;

	@NotNull
	@Column(name = "CITY", nullable = false)
	private int city;

	@NotNull
	@Column(name = "DISTRICT", nullable = false)
	private int district;

	@Length(min = 1, max = 500)
	@Column(name = "DESC", nullable = false)
	private String desc;

}
