package com.qs.insurance.upms.config;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.qs.insurance.system.common.core.constant.CommonConstants;
import com.qs.insurance.system.common.dynamic.gateway.support.DynamicRouteInitEvent;
import com.qs.insurance.system.common.dynamic.gateway.vo.RouteDefinitionVo;
import com.qs.insurance.upms.api.SysRouteConfService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.cloud.gateway.config.GatewayProperties;
import org.springframework.cloud.gateway.config.PropertiesRouteDefinitionLocator;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.scheduling.annotation.Async;

import java.net.URI;

/**
 * Create By WeiBin on 2020/11/1 23:42
 * 动态路由配置
 * @author WB
 */
@Slf4j
@Configuration
@AllArgsConstructor
public class DynamicRouteInitRunner {

    private final RedisTemplate redisTemplate;
    private final SysRouteConfService routeConfService;

    @Async
    @Order
    @EventListener({
            WebServerInitializedEvent.class, DynamicRouteInitEvent.class
    })
    public void initRoute() {
        Boolean result = redisTemplate.delete(CommonConstants.ROUTE_KEY);
        log.info("初始化网关路由 {} ", result);
        routeConfService.routes().forEach(route -> {
            RouteDefinitionVo vo = new RouteDefinitionVo();
            vo.setGatewayPrefix(route.getGatewayPrefix());
            vo.setRouteName(route.getRouteName());
            vo.setId(route.getRouteId());
            vo.setUri(URI.create(route.getUri()));
            vo.setOrder(route.getOrder());

            JSONArray filterObj = JSONUtil.parseArray(route.getFilters());
            vo.setFilters(filterObj.toList(FilterDefinition.class));
            JSONArray predicateObj = JSONUtil.parseArray(route.getPredicates());
            vo.setPredicates(predicateObj.toList(PredicateDefinition.class));

            log.info("加载路由ID：{},{}", route.getRouteId(), vo);
            redisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer<>(RouteDefinitionVo.class));
            redisTemplate.opsForHash().put(CommonConstants.ROUTE_KEY, route.getRouteId(), vo);
        });
        log.debug("初始化网关路由结束 ");
    }

    /**
     * 配置文件设置为空redis 加载的为准
     *
     * @return
     */
    @Bean
    public PropertiesRouteDefinitionLocator propertiesRouteDefinitionLocator() {
        return new PropertiesRouteDefinitionLocator(new GatewayProperties());
    }

}
