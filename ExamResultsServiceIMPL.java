package atl.academy.coursemanagementsystem.service.IMPL;

import atl.academy.coursemanagementsystem.dto.ExamResultsDTO;
import atl.academy.coursemanagementsystem.dto.ExamResultsSaveDTO;
import atl.academy.coursemanagementsystem.dto.ExamResultsUpdateDTO;
import atl.academy.coursemanagementsystem.dto.StudentDTO;
import atl.academy.coursemanagementsystem.entity.ExamResults;
import atl.academy.coursemanagementsystem.entity.Student;
import atl.academy.coursemanagementsystem.repo.ExamResultsRepo;
import atl.academy.coursemanagementsystem.repo.StudentRepo;
import atl.academy.coursemanagementsystem.service.ExamResultsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExamResultsServiceIMPL implements ExamResultsService {

    @Autowired
    private ExamResultsRepo examResultsRepo;
    @Override
    public String addExamResults(ExamResultsSaveDTO examResultsSaveDTO) {

        ExamResults examResults = new ExamResults(
                examResultsSaveDTO.getExamid(),
                examResultsSaveDTO.getStudentid(),
                examResultsSaveDTO.getExamresults()

        );

        examResultsRepo.save(examResults);

        return examResults.toString();
    }

    @Override
    public String updateExamResults(ExamResultsUpdateDTO examResultsUpdateDTO) {

        if (examResultsRepo.existsById(examResultsUpdateDTO.getExamid()))
        {
            ExamResults examResults = examResultsRepo.getById(examResultsUpdateDTO.getExamid());
            examResults.setStudentid(examResultsUpdateDTO.getStudentid());
            examResults.setExamresults(examResultsUpdateDTO.getExamresults());
            examResultsRepo.save(examResults);
            return examResults.toString();
        }
        else {
            System.out.println("Exam ID Not Found");
        }

        return null;
    }

    @Override
    public boolean deleteExamResults(int id) {

        if (examResultsRepo.existsById(id)) {
            examResultsRepo.deleteById(id);
        }
        else {
            System.out.println("Exam ID Not Found");
        }

        return false;
    }
}
