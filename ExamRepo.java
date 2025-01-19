package atl.academy.coursemanagementsystem.repo;

import atl.academy.coursemanagementsystem.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepo extends JpaRepository<Exam, Integer> {
}
