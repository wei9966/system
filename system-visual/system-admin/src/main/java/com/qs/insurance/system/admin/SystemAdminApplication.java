package com.qs.insurance.system.admin;

import com.qs.insurance.system.common.nacos.QsApplication;
import com.qs.insurance.system.common.nacos.constant.AppConstant;
import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.cloud.client.SpringCloudApplication;

@SpringCloudApplication
@EnableAdminServer
public class SystemAdminApplication {
    public static void main(String[] args) {
        QsApplication.run(AppConstant.APPLICATION_ADMIN_NAME,SystemAdminApplication.class,args);
    }
}
