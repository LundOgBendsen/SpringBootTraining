package dk.lungogbendsen.springbootex19persistence.education.repository;

import dk.lungogbendsen.springbootex19persistence.education.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long>, TeacherRepositoryCustom {
}
