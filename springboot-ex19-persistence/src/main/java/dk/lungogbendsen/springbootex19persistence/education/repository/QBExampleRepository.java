package dk.lungogbendsen.springbootex19persistence.education.repository;

import dk.lungogbendsen.springbootex19persistence.education.model.QBExample;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QBExampleRepository extends JpaRepository<QBExample, Long> {
}
