package com.springboot.SMTPMail.Bean;

import com.springboot.SMTPMail.Service.Impl.StmpMailSenderImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DemoBean {
    private static Log log  = LogFactory.getLog(DemoBean.class);
    public DemoBean(){
        log.info("Demo bean created");
    }
}
