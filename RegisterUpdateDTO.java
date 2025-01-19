package atl.academy.coursemanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterUpdateDTO {

    private int loginid;

    private int roleid;

    private String username;

    private String password;
}
