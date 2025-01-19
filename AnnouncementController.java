package atl.academy.coursemanagementsystem.controller;

import atl.academy.coursemanagementsystem.dto.AnnouncementSendDto;
import atl.academy.coursemanagementsystem.dto.CourseDTO;
import atl.academy.coursemanagementsystem.dto.CourseSaveDTO;
import atl.academy.coursemanagementsystem.dto.CourseUpdateDTO;
import atl.academy.coursemanagementsystem.service.AnnouncementService;
import atl.academy.coursemanagementsystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/announce")
public class AnnouncementController {

    @Autowired
    private AnnouncementService announcementService;

    @PostMapping(path = "/send")
    public String sendMail(@RequestBody AnnouncementSendDto announcementSendDto)
    {
        return announcementService.sendMail(announcementSendDto);
    }


}
