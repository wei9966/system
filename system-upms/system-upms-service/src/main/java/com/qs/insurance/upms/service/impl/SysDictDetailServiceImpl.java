package com.qs.insurance.upms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qs.insurance.upms.entity.SysDictDetail;
import com.qs.insurance.upms.dao.SysDictDetailMapper;
import com.qs.insurance.upms.service.SysDictDetailService;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

/**
 * 数据字典详情
 *
 * @author wb
 * @date 2020-12-28 11:03:20
 */
@Service("sysDictDetailService")
@AllArgsConstructor
public class SysDictDetailServiceImpl extends ServiceImpl<SysDictDetailMapper, SysDictDetail> implements SysDictDetailService {
    private final SysDictDetailMapper sysDictDetailMapper;
}
