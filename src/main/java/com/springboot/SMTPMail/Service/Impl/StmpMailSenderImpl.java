package com.springboot.SMTPMail.Service.Impl;

import com.springboot.SMTPMail.Service.MailSender;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class StmpMailSenderImpl implements MailSender {

    private  static Log log = LogFactory.getLog(StmpMailSenderImpl.class);

    private JavaMailSender javaMailSender;

    public  StmpMailSenderImpl(JavaMailSender javaMailSender){
        this.javaMailSender=javaMailSender;
    }

    @Override
    public void send(String to,String subject, String body) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper;

        helper = new MimeMessageHelper(message, true);//true indicates multipart message

        helper.setSubject(subject);
        helper.setTo(to);
        helper.setText(body,true);//true indicates html continue using helper for more fuctionalities like adding attachments, etc.

        javaMailSender.send(message);
    }
}
