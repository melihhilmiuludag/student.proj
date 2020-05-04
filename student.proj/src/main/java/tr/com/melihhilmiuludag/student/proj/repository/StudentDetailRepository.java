package tr.com.melihhilmiuludag.student.proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.melihhilmiuludag.student.proj.domain.entities.StudentDetail;

/**
 * @author muludag on 2.05.2020
 */
public interface StudentDetailRepository extends JpaRepository<StudentDetail, String> {
	void deleteByStudentId(String studentId);
}
