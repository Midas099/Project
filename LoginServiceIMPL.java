package atl.academy.coursemanagementsystem.service.IMPL;

import atl.academy.coursemanagementsystem.dto.LoginDTO;
import atl.academy.coursemanagementsystem.entity.Login;
import atl.academy.coursemanagementsystem.repo.LoginRepo;
import atl.academy.coursemanagementsystem.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceIMPL implements LoginService {

    @Autowired
    private LoginRepo loginRepo;
    @Override
    public Boolean getByUsername(LoginDTO loginDTO) {
        Login login = loginRepo.findByUsername(loginDTO.getUsername());
        if (login == null) {
            return false;
        } else {
            return login.getPassword().equals(loginDTO.getPassword());
        }
    }
}
