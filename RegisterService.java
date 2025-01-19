package atl.academy.coursemanagementsystem.service;

import atl.academy.coursemanagementsystem.dto.RegisterDTO;
import atl.academy.coursemanagementsystem.dto.StudentSaveDTO;

public interface RegisterService {
    public String addUser(RegisterDTO registerDTO);
}
