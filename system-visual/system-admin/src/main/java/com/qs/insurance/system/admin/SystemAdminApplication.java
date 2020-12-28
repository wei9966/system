package com.qs.insurance.system.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

@SpringCloudApplication
@EnableAdminServer
public class SystemAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(SystemAdminApplication.class,args);
    }
}
