package ginp14.project3.service;

import javax.mail.MessagingException;

public interface EmailService {
    void sendEmail(String email, String subject) throws MessagingException;
}
