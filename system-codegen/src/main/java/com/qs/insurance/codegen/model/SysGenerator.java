package com.qs.insurance.codegen.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SysGenerator {
 private String tableCatalog;
 private String tableSchema;
 private String tableName;
 private String tableType;
 private String engine;
 private String version;
 private String rowFormat;
 private Integer tableRows;
 private Integer avgRowLength;
 private Integer dataLength;
 private Integer maxDataLength;
 private Integer indexLength;
 private Integer dataFree;
 private String autoIncrement;
 private LocalDateTime createTime;
 private LocalDateTime updateTime;
 private LocalDateTime checkTime;
 private String tableCollation;
 private String checksum;
 private String createOptions;
 private String tableComment;
}
