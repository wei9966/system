package com.qs.insurance.system.common.core.constant;

/**
 * @author jhy
 * @date 2020/4/28
 * 服务名称
 */
public interface ServiceNameConstants {
    /**
     * 认证中心
     */
    String IH_SERVICE = "system-auth";
    /**
     * UMPS模块
     */
    String MANAGE_UPMS_SERVICE = "system-upms-biz";
    /**
     * 第三方公共
     */
    String IH_THIRDPARTY_SERVICE = "ih-thirdparty-biz";

    /**
     * patient-consult-biz模块
     */
    String PATIENT_CONSULT_SERVICE = "patient-consult-biz";
    /**
     * doctor-outpatients-biz模块
     */
    String DOCTOR_OUTPATIENTS_SERVICE = "doctor-outpatients-biz";

    /**
     * 分布式事务协调服务
     */
    String TX_MANAGER = "mqmc-tx-manager";

    /**
     * mqmc-catalog-biz模块
     */
    String IH_CATALOG_SERVICE = "system-catalog-biz";

}
