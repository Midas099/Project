package atl.academy.coursemanagementsystem.repo;

import atl.academy.coursemanagementsystem.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepo extends JpaRepository<Teacher, Integer> {
}
