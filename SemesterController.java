package atl.academy.coursemanagementsystem.controller;

import atl.academy.coursemanagementsystem.dto.*;
import atl.academy.coursemanagementsystem.service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/semester")
public class SemesterController {

    @Autowired
    private SemesterService semesterService;

    @PostMapping(path = "/save")
    public String saveSemester(@RequestBody SemesterSaveDTO semesterSaveDTO)
    {
        return semesterService.addSemester(semesterSaveDTO);
    }

    @GetMapping("/getAllSemesters")
    public List<SemesterDTO> getAllSemesters()
    {
        return semesterService.getAllSemesters();
    }

    @PutMapping (path = "/update")
    public String updateSemester(@RequestBody SemesterUpdateDTO semesterUpdateDTO)
    {
        return semesterService.updateSemester(semesterUpdateDTO);
    }

    @DeleteMapping (path = "/delete/{id}")
    public String deleteSemester(@PathVariable(value = "id")int id)
    {
        boolean deleteSemester = semesterService.deleteSemester(id);
        return "Deleted.";
    }
}
