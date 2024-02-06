package com.springboot.SMTPMail.Service.Impl;

import com.springboot.SMTPMail.Service.MailSender;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

public class MockMailSenderImpl implements MailSender {

    private  static Log log = LogFactory.getLog(MockMailSenderImpl.class);

    @Override
    public void send(String to,String subject, String body){
        log.info("Sending Mock mail to "+to);
        log.info("with subject "+subject);
        log.info("and body "+body);
    }
}
