package atl.academy.coursemanagementsystem.controller;

import atl.academy.coursemanagementsystem.dto.*;
import atl.academy.coursemanagementsystem.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/exam")
public class ExamController {

    @Autowired
    private ExamService examService;

    @PostMapping(path = "/save")
    public String saveExam(@RequestBody ExamSaveDTO examSaveDTO)
    {
        return examService.addExam(examSaveDTO);
    }

    @GetMapping("/getAllExams")
    public List<ExamDTO> getAllExams()
    {
        return examService.getAllExams();
    }

    @PutMapping (path = "/update")
    public String updateExam(@RequestBody ExamUpdateDTO examUpdateDTO)
    {
        return examService.updateExam(examUpdateDTO);
    }

    @DeleteMapping (path = "/delete/{id}")
    public String deleteExam(@PathVariable(value = "id")int id)
    {
        boolean deleteExam = examService.deleteExam(id);
        return "Deleted.";
    }
}
