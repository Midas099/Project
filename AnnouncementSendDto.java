package atl.academy.coursemanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnnouncementSendDto {

    private String receiver;
    private String subject;
    private String text;
}
