package com.qs.insurance.upms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qs.insurance.upms.entity.SysDict;
import com.qs.insurance.upms.dao.SysDictMapper;
import com.qs.insurance.upms.service.SysDictService;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

/**
 * 数据字典
 *
 * @author wb
 * @date 2020-12-28 10:58:10
 */
@Service("sysDictService")
@AllArgsConstructor
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper, SysDict> implements SysDictService {
    private final SysDictMapper sysDictMapper;
}
