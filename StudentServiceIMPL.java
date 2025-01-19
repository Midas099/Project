package atl.academy.coursemanagementsystem.service.IMPL;

import atl.academy.coursemanagementsystem.dto.StudentDTO;
import atl.academy.coursemanagementsystem.dto.StudentSaveDTO;
import atl.academy.coursemanagementsystem.dto.StudentUpdateDTO;
import atl.academy.coursemanagementsystem.entity.ExamResults;
import atl.academy.coursemanagementsystem.entity.Student;
import atl.academy.coursemanagementsystem.repo.ExamRepo;
import atl.academy.coursemanagementsystem.repo.ExamResultsRepo;
import atl.academy.coursemanagementsystem.repo.StudentRepo;
import atl.academy.coursemanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceIMPL implements StudentService {


    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private ExamRepo examRepo;

    @Autowired
    private ExamResultsRepo examResultsRepo;

    @Override
    public String addStudent(StudentSaveDTO studentSaveDTO) {

        Student student = new Student(
                studentSaveDTO.getStudentname(),
                studentSaveDTO.getAddress(),
                studentSaveDTO.getPhone()

        );

        studentRepo.save(student);

        return student.getStudentname();
    }

    @Override
    public List<StudentDTO> getAllStudents() {

        List<Student> getStudents = studentRepo.findAll();
        List<StudentDTO> studentDTOList = new ArrayList<>();

        for (Student student:getStudents)
        {
            StudentDTO studentDTO = new StudentDTO(
                    student.getStudentid(),
                    student.getStudentname(),
                    student.getAddress(),
                    student.getPhone()
            );
            studentDTOList.add(studentDTO);
        }

        return studentDTOList;
    }

    @Override
    public String updateStudent(StudentUpdateDTO studentUpdateDTO) {

        if (studentRepo.existsById(studentUpdateDTO.getStudentid()))
        {
            Student student = studentRepo.getById(studentUpdateDTO.getStudentid());
            student.setStudentname(studentUpdateDTO.getStudentname());
            student.setAddress(studentUpdateDTO.getAddress());
            student.setPhone(studentUpdateDTO.getPhone());
            studentRepo.save(student);
            return student.getStudentname();
        }
        else {
            System.out.println("Student ID Not Found");
        }

        return null;
    }

    @Override
    public boolean deleteStudent(int id) {

        if (studentRepo.existsById(id)) {
            studentRepo.deleteById(id);
        }
        else {
            System.out.println("Student ID Not Found");
        }

        return false;
    }

    @Override
    public List<ExamResults> getExamsResults(int studentId) {
        return examResultsRepo.findAllByStudentid(studentId);
    }

    @Override
    public ExamResults getExamResultById(int studentId, int examId) {
        return examResultsRepo.findByStudentidAndExamid(studentId, examId);
    }
}
