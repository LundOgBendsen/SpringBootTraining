package dk.lungogbendsen.springbootex19persistence.education.repository;

import dk.lungogbendsen.springbootex19persistence.education.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
