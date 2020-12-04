package com.qs.insurance.message.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qs.insurance.message.dao.ShortMessageLoginRecordMapper;
import com.qs.insurance.message.entity.ShortMessageLoginRecord;
import com.qs.insurance.message.service.ShortMessageLoginRecordService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 短信登录记录
 *
 * @author wb
 * @date 2020-12-03 20:04:18
 */
@Service("shortMessageLoginRecordService")
@AllArgsConstructor
public class ShortMessageLoginRecordServiceImpl extends ServiceImpl<ShortMessageLoginRecordMapper, ShortMessageLoginRecord> implements ShortMessageLoginRecordService {
    private final ShortMessageLoginRecordMapper shortMessageLoginRecordMapper;
}
