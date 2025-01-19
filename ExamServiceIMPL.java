package atl.academy.coursemanagementsystem.service.IMPL;

import atl.academy.coursemanagementsystem.dto.ExamDTO;
import atl.academy.coursemanagementsystem.dto.ExamSaveDTO;
import atl.academy.coursemanagementsystem.dto.ExamUpdateDTO;
import atl.academy.coursemanagementsystem.entity.Exam;
import atl.academy.coursemanagementsystem.repo.SemesterRepo;
import atl.academy.coursemanagementsystem.repo.ExamRepo;
import atl.academy.coursemanagementsystem.repo.StudentRepo;
import atl.academy.coursemanagementsystem.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExamServiceIMPL implements ExamService {

    @Autowired
    private ExamRepo examRepo;

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private SemesterRepo semesterRepo;

    @Override
    public String addExam(ExamSaveDTO examSaveDTO) {

        Exam exam = new Exam(
                studentRepo.getById(examSaveDTO.getStudentid()),
                semesterRepo.getById(examSaveDTO.getSemesterid()),
                examSaveDTO.getExamdate()

        );
        examRepo.save(exam);
        return exam.getExamdate();
    }

    @Override
    public List<ExamDTO> getAllExams() {

        List<Exam> getExams = examRepo.findAll();
        List<ExamDTO> examDTOList = new ArrayList<>();

        for (Exam exam : getExams)
        {
            ExamDTO examDTO = new ExamDTO(
                    exam.getExamid(),
                    exam.getStudent(),
                    exam.getSemester(),
                    exam.getExamdate()
            );
            examDTOList.add(examDTO);
        }

        return examDTOList;
    }

    @Override
    public String updateExam(ExamUpdateDTO examUpdateDTO) {

        if (examRepo.existsById(examUpdateDTO.getExamid()))
        {
            Exam exam = examRepo.getById(examUpdateDTO.getExamid());
            exam.setStudent(studentRepo.getById(examUpdateDTO.getStudentid()));
            exam.setSemester(semesterRepo.getById(examUpdateDTO.getSemesterid()));
            exam.setExamdate(examUpdateDTO.getExamdate());

            examRepo.save(exam);
            return exam.getExamdate();
        }
        else {
            System.out.println("Exam ID Not Found");
        }

        return null;
    }

    @Override
    public boolean deleteExam(int id) {

        if (examRepo.existsById(id)) {
            examRepo.deleteById(id);
        }
        else {
            System.out.println("Enrollment ID Not Found");
        }

        return false;
    }
}
