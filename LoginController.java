package atl.academy.coursemanagementsystem.controller;

import atl.academy.coursemanagementsystem.dto.LoginDTO;
import atl.academy.coursemanagementsystem.dto.RegisterDTO;
import atl.academy.coursemanagementsystem.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping(path = "/getByUsername")
    public Boolean getByUsername(@RequestBody LoginDTO loginDTO)
    {
        return loginService.getByUsername(loginDTO);
    }


}
