package com.qs.insurance.upms.api;

import cn.hutool.json.JSONArray;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qs.insurance.upms.entity.SysRouteConf;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Create By WeiBin on 2020/11/7 19:37
 */
public interface SysRouteConfService extends IService<SysRouteConf> {
    /**
     * 获取全部路由
     *
     * @return
     */
    List<SysRouteConf> routes();

    /**
     * 更新路由信息
     *
     * @param routes 路由信息
     * @return
     */
    Mono<Void> updateRoutes(JSONArray routes);
}
