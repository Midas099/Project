package atl.academy.coursemanagementsystem.service.IMPL;

import atl.academy.coursemanagementsystem.dto.AnnouncementSendDto;
import atl.academy.coursemanagementsystem.entity.Exam;
import atl.academy.coursemanagementsystem.repo.ExamRepo;
import atl.academy.coursemanagementsystem.service.AnnouncementService;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class AnnouncementServiceIMPL implements AnnouncementService {

    @Autowired
    private ExamRepo examRepo;

    @Override
    public String sendMail(AnnouncementSendDto announcementSendDto) {
        String to = announcementSendDto.getReceiver();

        String from = "dadasheff004@gmail.com";

        String host = "smtp.gmail.com";

        Properties properties = System.getProperties();

        properties.setProperty("mail.smtp.host", host);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");

        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, "mmao aaeu juun wkpb");
            }
        };

        Session session = Session.getInstance(properties, auth);



        try {
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            message.setSubject(announcementSendDto.getSubject());

            message.setText(announcementSendDto.getText());

            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return "Sent message successfully...";
    }

    @Scheduled(cron = "0 47 10 * * ?")
    public void sendDailyMail() {
        String to = "ulvi.2003@gmail.com";

        String from = "dadasheff004@gmail.com";

        String host = "smtp.gmail.com";

        Properties properties = System.getProperties();

        properties.setProperty("mail.smtp.host", host);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");

        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, "mmao aaeu juun wkpb");
            }
        };

        Session session = Session.getInstance(properties, auth);

        List<Exam> exams = examRepo.findAll();
        Date smallestDate = null;

        for (Exam exam : exams) {
            List<Date> dates = new ArrayList<>();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date date = formatter.parse(exam.getExamdate());
                dates.add(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
             smallestDate = Collections.min(dates);
        }

        try {
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            message.setSubject("next exam");

            message.setText("next exam date is: " + smallestDate);

            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }    }
}
