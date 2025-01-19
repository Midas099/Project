package atl.academy.coursemanagementsystem.controller;

import atl.academy.coursemanagementsystem.dto.*;
import atl.academy.coursemanagementsystem.service.ExamResultsService;
import atl.academy.coursemanagementsystem.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/examResults")
public class ExamResultsController {

    @Autowired
    private ExamResultsService examResultsService;

    @PostMapping(path = "/save")
    public String saveExamResults(@RequestBody ExamResultsSaveDTO examResultsSaveDTO)
    {
        return examResultsService.addExamResults(examResultsSaveDTO);
    }

    @PutMapping (path = "/update")
    public String updateExamResults(@RequestBody ExamResultsUpdateDTO examResultsUpdateDTO)
    {
        return examResultsService.updateExamResults(examResultsUpdateDTO);
    }

    @DeleteMapping (path = "/delete/{id}")
    public String deleteExamResults(@PathVariable(value = "id")int id)
    {
        boolean deleteExamResults = examResultsService.deleteExamResults(id);
        return "Deleted.";
    }
}
