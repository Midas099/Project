package atl.academy.coursemanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExamResultsSaveDTO {

    private int examid;

    private int studentid;

    private double examresults;
}
