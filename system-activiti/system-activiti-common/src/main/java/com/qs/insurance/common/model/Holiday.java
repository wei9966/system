package com.qs.insurance.common.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Holiday implements Serializable {
    private Integer id;
    private String leavePerson;
    private String deptManager;
    private String personnel;
    private String generalManager;
    private Date startDate;
    private Date endDate;
    private Float totalDay;

}
