package com.qs.insurance.message.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qs.insurance.message.entity.ShortMessageContent;
import com.qs.insurance.message.dao.ShortMessageContentMapper;
import com.qs.insurance.message.service.ShortMessageContentService;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

/**
 * 短信内容模块
 *
 * @author wb
 * @date 2020-12-03 22:14:59
 */
@Service("shortMessageContentService")
@AllArgsConstructor
public class ShortMessageContentServiceImpl extends ServiceImpl<ShortMessageContentMapper, ShortMessageContent> implements ShortMessageContentService {
    private final ShortMessageContentMapper shortMessageContentMapper;
}
