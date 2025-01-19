package atl.academy.coursemanagementsystem.dto;

import atl.academy.coursemanagementsystem.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SemesterUpdateDTO {

    private int semesterid;

    private String semestername;

    private List<Integer> courseIds;

    private String startdate;

    private String enddate;
}
