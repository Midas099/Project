package atl.academy.coursemanagementsystem.dto;

import atl.academy.coursemanagementsystem.entity.Semester;
import atl.academy.coursemanagementsystem.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExamResultsDTO {

    private int examid;

    private int studentid;

    private double examresults;
}
