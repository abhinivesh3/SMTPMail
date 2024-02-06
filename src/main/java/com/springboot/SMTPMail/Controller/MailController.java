package com.springboot.SMTPMail.Controller;

import com.springboot.SMTPMail.Service.MailSender;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

    //@Autowired
    private MailSender mailSender;

    public  MailController(MailSender smtp){
        this.mailSender=smtp;
    }
    @RequestMapping("/mail")
    public String mail() throws MessagingException {
        mailSender.send("abhinivesh3820021@gmail.com","A test mail","Body of the test mail");
        return "Mail sent";
    }
}
