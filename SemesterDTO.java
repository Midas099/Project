package atl.academy.coursemanagementsystem.dto;

import atl.academy.coursemanagementsystem.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SemesterDTO {

    private int semesterid;

    private String semestername;

    private Set<Course> courses;

    private String startdate;

    private String enddate;
}
