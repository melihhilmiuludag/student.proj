package tr.com.melihhilmiuludag.student.proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.melihhilmiuludag.student.proj.domain.entities.Files;

/**
 * @author muludag on 2.05.2020
 */
public interface FilesRepository extends JpaRepository<Files, String> {
}
