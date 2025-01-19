package atl.academy.coursemanagementsystem.service;

import atl.academy.coursemanagementsystem.dto.CourseDTO;
import atl.academy.coursemanagementsystem.dto.CourseSaveDTO;
import atl.academy.coursemanagementsystem.dto.CourseUpdateDTO;

import java.util.List;

public interface CourseService {
    String addCourse(CourseSaveDTO courseSaveDTO);

    List<CourseDTO> getAllCourses();

    String updateCourse(CourseUpdateDTO courseUpdateDTO);

    boolean deleteCourse(int id);
}
