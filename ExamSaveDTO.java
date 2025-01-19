package atl.academy.coursemanagementsystem.dto;

import atl.academy.coursemanagementsystem.entity.Semester;
import atl.academy.coursemanagementsystem.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExamSaveDTO {

    private int studentid;

    private int semesterid;

    private String examdate;
}
