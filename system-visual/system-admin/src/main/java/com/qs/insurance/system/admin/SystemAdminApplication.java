package com.qs.insurance.system.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class SystemAdminApplication {
    public static void main(String[] args) {
//        QsApplication.run(AppConstant.APPLICATION_ADMIN_NAME,SystemAdminApplication.class,args);
        SpringApplication.run(SystemAdminApplication.class,args);
    }
}
