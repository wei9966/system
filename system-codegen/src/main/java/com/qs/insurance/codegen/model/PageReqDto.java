package com.qs.insurance.codegen.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageReqDto {
    private Integer pageNo;
    private Integer pageSize;
    private String tableName;
    private String schema;
}
