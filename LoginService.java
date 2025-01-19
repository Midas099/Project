package atl.academy.coursemanagementsystem.service;

import atl.academy.coursemanagementsystem.dto.LoginDTO;

public interface LoginService {
    Boolean getByUsername(LoginDTO loginDTO);
}
