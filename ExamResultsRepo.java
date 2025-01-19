package atl.academy.coursemanagementsystem.repo;

import atl.academy.coursemanagementsystem.entity.ExamResults;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExamResultsRepo extends JpaRepository<ExamResults, Integer> {
    List<ExamResults> findAllByStudentid(int studentid);

    //where student_id = p_student_id;
    ExamResults findByStudentidAndExamid(int studentId, int examId);

    //where student_id = p_student_id and exam_id = p_exam_id;
}
