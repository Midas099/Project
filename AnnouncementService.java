package atl.academy.coursemanagementsystem.service;

import atl.academy.coursemanagementsystem.dto.AnnouncementSendDto;

public interface AnnouncementService {

     String sendMail(AnnouncementSendDto announcementSendDto);
}
