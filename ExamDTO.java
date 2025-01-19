package atl.academy.coursemanagementsystem.dto;

import atl.academy.coursemanagementsystem.entity.Semester;
import atl.academy.coursemanagementsystem.entity.Student;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExamDTO {

    private int examid;

    private Student student;

    private Semester semester;

    private String examdate;
}
