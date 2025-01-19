package atl.academy.coursemanagementsystem.controller;

import atl.academy.coursemanagementsystem.dto.StudentDTO;
import atl.academy.coursemanagementsystem.dto.StudentSaveDTO;
import atl.academy.coursemanagementsystem.dto.StudentUpdateDTO;
import atl.academy.coursemanagementsystem.entity.ExamResults;
import atl.academy.coursemanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping(path = "/save")
    public String saveStudent(@RequestBody StudentSaveDTO studentSaveDTO)
    {
         return studentService.addStudent(studentSaveDTO);
    }

    @GetMapping("/getAllStudents")
    public List<StudentDTO> getAllStudents()
    {
        return studentService.getAllStudents();
    }

    @PutMapping (path = "/update")
    public String updateStudent(@RequestBody StudentUpdateDTO studentUpdateDTO)
    {
        return studentService.updateStudent(studentUpdateDTO);
    }

    @DeleteMapping (path = "/delete/{id}")
    public String deleteStudent(@PathVariable(value = "id")int id)
    {
        boolean deleteStudent = studentService.deleteStudent(id);
        return "Deleted.";
    }

    @GetMapping("/getResultById/{studentId}")
    public List<ExamResults> getAllResults(@PathVariable(value = "studentId")int studentId)
    {
        return studentService.getExamsResults(studentId);
    }

    @GetMapping("/getResultById/{studentId}/{examId}")
    public ExamResults getAllResults(@PathVariable(value = "studentId")int studentId,@PathVariable(value = "examId")int examId)
    {
        return studentService.getExamResultById(studentId, examId);
    }
}
