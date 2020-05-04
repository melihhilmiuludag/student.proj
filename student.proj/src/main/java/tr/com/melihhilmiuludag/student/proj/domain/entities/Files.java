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
@Table(name = "FILES")
public class Files {

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
	@NotEmpty
	@Length(min = 1, max = 250)
	@Column(name = "CONTENT_PATH", nullable = false)
	private String contentPath;

}
