package atl.academy.coursemanagementsystem.controller;

import atl.academy.coursemanagementsystem.dto.*;
import atl.academy.coursemanagementsystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping(path = "/save")
    public String saveCourse(@RequestBody CourseSaveDTO courseSaveDTO)
    {
        return courseService.addCourse(courseSaveDTO);
    }

    @GetMapping("/getAllCourses")
    public List<CourseDTO> getAllCourses()
    {
        return courseService.getAllCourses();
    }

    @PutMapping (path = "/update")
    public String updateCourse(@RequestBody CourseUpdateDTO courseUpdateDTO)
    {
        return courseService.updateCourse(courseUpdateDTO);
    }

    @DeleteMapping (path = "/delete/{id}")
    public String deleteCourse(@PathVariable(value = "id")int id)
    {
        boolean deleteCourse = courseService.deleteCourse(id);
        return "Deleted.";
    }
}
