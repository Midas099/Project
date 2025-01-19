package atl.academy.coursemanagementsystem.repo;

import atl.academy.coursemanagementsystem.entity.Semester;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemesterRepo extends JpaRepository<Semester, Integer> {
}
