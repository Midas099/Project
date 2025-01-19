package atl.academy.coursemanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SemesterSaveDTO {

    private String semestername;

    private int courseid;

    private String startdate;

    private String enddate;
}
