package com.qs.insurance.upms.controller.web;


import cn.hutool.json.JSONArray;
import com.qs.insurance.system.common.core.utils.R;
import com.qs.insurance.upms.service.SysRouteConfService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


/**
 *
 * @Date  2020/5/6 2:58 下午
 * @Description :路由配置表
 *
 */
@RestController
@RequestMapping("/sys/routeconf")
@AllArgsConstructor
@Slf4j
@Api(value = "路由配置表 controller", tags = "动态路由管理")
public class SysRouteConfController {

    private SysRouteConfService sysRouteConfService;


    /**
     * 获取当前定义的路由信息
     *
     * @return
     */
    @GetMapping
    public R listRoutes() {
        return new R<>(sysRouteConfService.list());
    }

    /**
     * 修改路由
     *
     * @param routes 路由定义
     * @return
     */
    @PutMapping
    public R updateRoutes(@RequestBody JSONArray routes) {
        return new R<>(sysRouteConfService.updateRoutes(routes));
    }

}

