package atl.academy.coursemanagementsystem.repo;

import atl.academy.coursemanagementsystem.entity.Course;
import atl.academy.coursemanagementsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course, Integer> {
}
