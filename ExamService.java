package atl.academy.coursemanagementsystem.service;

import atl.academy.coursemanagementsystem.dto.ExamDTO;
import atl.academy.coursemanagementsystem.dto.ExamSaveDTO;
import atl.academy.coursemanagementsystem.dto.ExamUpdateDTO;

import java.util.List;

public interface ExamService {
    String addExam(ExamSaveDTO examSaveDTO);

    List<ExamDTO> getAllExams();

    String updateExam(ExamUpdateDTO examUpdateDTO);

    boolean deleteExam(int id);
}
