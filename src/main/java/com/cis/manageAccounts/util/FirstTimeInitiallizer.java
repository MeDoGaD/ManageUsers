package com.cis.manageAccounts.util;

import com.cis.manageAccounts.security.Admin;
import com.cis.manageAccounts.security.AdminService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class FirstTimeInitiallizer implements CommandLineRunner {

    private final Log logger= LogFactory.getLog(FirstTimeInitiallizer.class);
    @Autowired
    private AdminService adminService;

    @Override
    public void run(String... args) throws Exception {
        if(adminService.findAll().isEmpty())
        {
            logger.info("No Admins found >> Create admins pls");
            Admin admin=new Admin("Mohamed","medo","medo123");
            adminService.saveAdmin(admin);
        }
    }
}
