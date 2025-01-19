package atl.academy.coursemanagementsystem.controller;

import atl.academy.coursemanagementsystem.dto.RegisterDTO;
import atl.academy.coursemanagementsystem.service.LoginService;
import atl.academy.coursemanagementsystem.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/register")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping(path = "/save")
    public String saveUser(@RequestBody RegisterDTO registerDTO)
    {
        return registerService.addUser(registerDTO);
    }
}
