package atl.academy.coursemanagementsystem.service;

import atl.academy.coursemanagementsystem.dto.ExamResultsDTO;
import atl.academy.coursemanagementsystem.dto.ExamResultsSaveDTO;
import atl.academy.coursemanagementsystem.dto.ExamResultsUpdateDTO;

import java.util.List;

public interface ExamResultsService {
    String addExamResults(ExamResultsSaveDTO examResultsSaveDTO);

    String updateExamResults(ExamResultsUpdateDTO examResultsUpdateDTO);

    boolean deleteExamResults(int id);
}
