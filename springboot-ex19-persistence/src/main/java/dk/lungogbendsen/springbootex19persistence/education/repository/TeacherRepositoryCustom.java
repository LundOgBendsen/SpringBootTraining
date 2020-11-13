package dk.lungogbendsen.springbootex19persistence.education.repository;

import dk.lungogbendsen.springbootex19persistence.education.model.Student;

import java.util.List;

public interface TeacherRepositoryCustom {
    List<Student> getStudents(String teacherName);
}
