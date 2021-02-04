package com.qs.insurance.upms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qs.insurance.upms.entity.SysLog;
import com.qs.insurance.upms.dao.SysLogMapper;
import com.qs.insurance.upms.service.SysLogService;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

/**
 * 日志表
 *
 * @author wb
 * @date 2020-12-28 14:47:03
 */
@Service("sysLogService")
@AllArgsConstructor
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements SysLogService {
    private final SysLogMapper sysLogMapper;
}
