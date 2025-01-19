package atl.academy.coursemanagementsystem.service.IMPL;

import atl.academy.coursemanagementsystem.dto.RegisterDTO;
import atl.academy.coursemanagementsystem.dto.StudentSaveDTO;
import atl.academy.coursemanagementsystem.entity.Login;
import atl.academy.coursemanagementsystem.entity.Student;
import atl.academy.coursemanagementsystem.repo.LoginRepo;
import atl.academy.coursemanagementsystem.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceIMPL implements RegisterService {

    @Autowired
    private LoginRepo loginRepo;

    @Override
    public String addUser(RegisterDTO registerDTO) {

        Login user = new Login(
                registerDTO.getRoleid(),
                registerDTO.getUsername(),
                registerDTO.getPassword()

        );

        boolean isUserExists = loginRepo.existsByUsername(registerDTO.getUsername());
        if (!isUserExists) {
            if (registerDTO.getPassword().length() >= 8) {
                loginRepo.save(user);
            } else {
                return "Password must contain at least 8 characters.";
            }
        } else {
            return "User already exists.";
        }

        return "User registered.";
    }
}
