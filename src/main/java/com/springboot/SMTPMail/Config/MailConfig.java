package com.springboot.SMTPMail.Config;

import com.springboot.SMTPMail.Bean.DemoBean;
import com.springboot.SMTPMail.Service.Impl.MockMailSenderImpl;
import com.springboot.SMTPMail.Service.Impl.StmpMailSenderImpl;
import com.springboot.SMTPMail.Service.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Configuration
public class MailConfig {

//    @Bean
//    public DemoBean demoBean() {
//        return new DemoBean();
//    }

    @Bean
    //@Profile("dev")
    @ConditionalOnProperty(name = "spring.mail.host",havingValue = "foo", matchIfMissing = true)
    public MailSender mockMailSender(){
        return new MockMailSenderImpl();
    }

    @Bean
    //@Profile("!dev")
    @ConditionalOnProperty("spring.mail.host")
    public  MailSender smtpMailSender(JavaMailSender javaMailSender){
       // demoBean();
        return new StmpMailSenderImpl(javaMailSender);
    }
}
