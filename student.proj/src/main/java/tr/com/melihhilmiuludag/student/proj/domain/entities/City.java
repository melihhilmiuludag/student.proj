package tr.com.melihhilmiuludag.student.proj.domain.entities;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author muludag on 2.05.2020
 */
@Data
@Entity
@Table(name = "CITY")
public class City {
	@Id
	@NotNull
	@Column(name = "ID", nullable = false)
	private int id;

	@NotNull
	@NotEmpty
	@Length(min = 1, max = 20)
	@Column(name = "NAME", nullable = false)
	private String name;
}
