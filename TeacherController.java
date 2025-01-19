package atl.academy.coursemanagementsystem.controller;

import atl.academy.coursemanagementsystem.dto.*;
import atl.academy.coursemanagementsystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping(path = "/save")
    public String saveTeacher(@RequestBody TeacherSaveDTO teacherSaveDTO)
    {
        return teacherService.addTeacher(teacherSaveDTO);
    }

    @GetMapping("/getAllTeachers")
    public List<TeacherDTO> getAllTeachers()
    {
        return teacherService.getAllTeachers();
    }

    @PutMapping (path = "/update")
    public String updateTeacher(@RequestBody TeacherUpdateDTO teacherUpdateDTO)
    {
        return teacherService.updateTeacher(teacherUpdateDTO);
    }

    @DeleteMapping (path = "/delete/{id}")
    public String deleteTeacher(@PathVariable(value = "id")int id)
    {
        boolean deleteTeacher = teacherService.deleteTeacher(id);
        return "Deleted.";
    }
}
