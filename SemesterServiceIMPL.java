package atl.academy.coursemanagementsystem.service.IMPL;

import atl.academy.coursemanagementsystem.dto.SemesterDTO;
import atl.academy.coursemanagementsystem.dto.SemesterSaveDTO;
import atl.academy.coursemanagementsystem.dto.SemesterUpdateDTO;
import atl.academy.coursemanagementsystem.entity.Course;
import atl.academy.coursemanagementsystem.entity.Semester;
import atl.academy.coursemanagementsystem.repo.SemesterRepo;
import atl.academy.coursemanagementsystem.repo.CourseRepo;
import atl.academy.coursemanagementsystem.service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class SemesterServiceIMPL implements SemesterService {

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private SemesterRepo semesterRepo;

    @Override
    public String addSemester(SemesterSaveDTO semesterSaveDTO) {

        Semester semester = new Semester(
                semesterSaveDTO.getSemestername(),
                semesterSaveDTO.getStartdate(),
                semesterSaveDTO.getEnddate()

        );
        semesterRepo.save(semester);
        return semester.getSemestername();
    }

    @Override
    public List<SemesterDTO> getAllSemesters() {

        List<Semester> getSemesters = semesterRepo.findAll();
        List<SemesterDTO> semesterDTOList = new ArrayList<>();

        for (Semester semester : getSemesters)
        {
            SemesterDTO semesterDTO = new SemesterDTO(
                    semester.getSemesterid(),
                    semester.getSemestername(),
                    semester.getCourses(),
                    semester.getStartdate(),
                    semester.getEnddate()
            );
            semesterDTOList.add(semesterDTO);
        }

        return semesterDTOList;
    }

    @Override
    public String updateSemester(SemesterUpdateDTO semesterUpdateDTO) {

        if (semesterRepo.existsById(semesterUpdateDTO.getSemesterid()))
        {
            Semester semester = semesterRepo.getById(semesterUpdateDTO.getSemesterid());
            semester.setSemestername(semesterUpdateDTO.getSemestername());
            Set<Course> courses = null;
            for(int id : semesterUpdateDTO.getCourseIds()){
                Course course = courseRepo.findById(id).orElseThrow();
                courses.add(course);
            }
            semester.setCourses(courses);
            semester.setStartdate(semesterUpdateDTO.getStartdate());

            semesterRepo.save(semester);
            return semester.getSemestername();
        }
        else {
            System.out.println("Semester ID Not Found");
        }

        return null;
    }

    @Override
    public boolean deleteSemester(int id) {

        if (semesterRepo.existsById(id)) {
            semesterRepo.deleteById(id);
        }
        else {
            System.out.println("Semester ID Not Found");
        }

        return false;
    }
}
