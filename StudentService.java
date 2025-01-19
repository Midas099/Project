package atl.academy.coursemanagementsystem.service;

import atl.academy.coursemanagementsystem.dto.StudentDTO;
import atl.academy.coursemanagementsystem.dto.StudentSaveDTO;
import atl.academy.coursemanagementsystem.dto.StudentUpdateDTO;
import atl.academy.coursemanagementsystem.entity.ExamResults;

import java.util.List;

public interface StudentService {
    String addStudent(StudentSaveDTO studentSaveDTO);

    List<StudentDTO> getAllStudents();

    String updateStudent(StudentUpdateDTO studentUpdateDTO);

    boolean deleteStudent(int id);

    List<ExamResults> getExamsResults(int studentId);
    ExamResults getExamResultById(int studentId, int examId);
}
