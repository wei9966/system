/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qs.insurance.system.common.core.impl;

import com.qs.insurance.system.common.nacos.service.LauncherService;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.Properties;

/**
 * 启动参数拓展
 *
 * @author smallchil
 */
public class LauncherServiceImpl implements LauncherService {

	@Override
	public void launcher(SpringApplicationBuilder builder, String appName, String profile) {
		Properties props = System.getProperties();
		props.setProperty("spring.cloud.nacos.discovery.server-addr", "192.168.56.10:8848");
		props.setProperty("spring.cloud.nacos.config.server-addr", "192.168.56.10:8848");
		props.setProperty("spring.cloud.nacos.config.namespace", "78493cf7-8186-4d81-8df4-8b3daa613e56");
		props.setProperty("spring.cloud.nacos.discovery.namespace", "78493cf7-8186-4d81-8df4-8b3daa613e56");
		//暴露端口 方便监控
		props.setProperty("management.endpoints.web.exposure.include", "*");
		props.setProperty("management.endpoint.health.show-details", "ALWAYS");
		//设置日志
		props.setProperty("management.endpoint.logfile.external-file:", "D:/admin/"+appName+".log");
		//设置nacos分组
		props.setProperty("spring.cloud.nacos.discovery.group", "SYSTEM_DEV");
		props.setProperty("spring.cloud.nacos.config.group", "SYSTEM_DEV");
		props.setProperty("rocketmq.name-server", "192.168.56.10:9876");
		props.setProperty("rocketmq.producer.group", "test-group");
		//es
		props.setProperty("spring.data.elasticsearch.cluster-name", "elasticsearch");
		props.setProperty("spring.data.elasticsearch.cluster-nodes", "192.168.56.10:9300");
	}
}
