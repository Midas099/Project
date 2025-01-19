package atl.academy.coursemanagementsystem.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/v1/copyrights")
public class CopyrightsController {

    @GetMapping("/getCopyrights")
    public String getCopyrights() {
        return "Developed by Riad Dadashov";
    }
}
