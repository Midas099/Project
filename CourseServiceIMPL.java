package atl.academy.coursemanagementsystem.service.IMPL;

import atl.academy.coursemanagementsystem.dto.CourseDTO;
import atl.academy.coursemanagementsystem.dto.CourseSaveDTO;
import atl.academy.coursemanagementsystem.dto.CourseUpdateDTO;
import atl.academy.coursemanagementsystem.entity.Course;
import atl.academy.coursemanagementsystem.repo.CourseRepo;
import atl.academy.coursemanagementsystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceIMPL implements CourseService {

    @Autowired
    private CourseRepo courseRepo;

    @Override
    public String addCourse(CourseSaveDTO courseSaveDTO) {

        Course course = new Course(
                courseSaveDTO.getCoursename(),
                courseSaveDTO.getSyllabus()

        );
        courseRepo.save(course);
        return course.getCoursename();
    };

    @Override
    public List<CourseDTO> getAllCourses() {

        List<Course> getCourses = courseRepo.findAll();
        List<CourseDTO> courseDTOList = new ArrayList<>();

        for (Course course:getCourses)
        {
            CourseDTO courseDTO = new CourseDTO(
                    course.getCourseid(),
                    course.getCoursename(),
                    course.getSyllabus()
            );
            courseDTOList.add(courseDTO);
        }

        return courseDTOList;
    }

    @Override
    public String updateCourse(CourseUpdateDTO courseUpdateDTO) {

        if (courseRepo.existsById(courseUpdateDTO.getCourseid()))
        {
            Course course = courseRepo.getById(courseUpdateDTO.getCourseid());
            course.setCoursename(courseUpdateDTO.getCoursename());
            course.setSyllabus(courseUpdateDTO.getSyllabus());
            courseRepo.save(course);
            return course.getCoursename();
        }
        else {
            System.out.println("Course ID Not Found");
        }

        return null;
    }

    @Override
    public boolean deleteCourse(int id) {

        if (courseRepo.existsById(id)) {
            courseRepo.deleteById(id);
        }
        else {
            System.out.println("Course ID Not Found");
        }

        return false;
    }
}
