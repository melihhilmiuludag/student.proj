package tr.com.melihhilmiuludag.student.proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tr.com.melihhilmiuludag.student.proj.domain.dtos.StudentListDto;
import tr.com.melihhilmiuludag.student.proj.domain.entities.Student;

import java.util.List;

/**
 * @author muludag on 2.05.2020
 */
public interface StudentRepository extends JpaRepository<Student, String> {
	Student findByMail(String mail);

	List<Student> findAllByMail(String mail);

	@Query("Select new tr.com.melihhilmiuludag.student.proj.domain.dtos.StudentListDto(s.id,s.name,s.surname,s.mail,s.phoneNumber,c.name,sd.city,sd.district,d.name,sd.desc)" +
			" from Student s," +
			" StudentDetail sd," +
			" City c," +
			" District d" +
			" where " +
			" s.id = sd.studentId " +
			" and sd.city = c.id" +
			" and sd.district = d.id" +
			" and d.cityId = c.id" +
			" ")
	List<StudentListDto> customList();
}
