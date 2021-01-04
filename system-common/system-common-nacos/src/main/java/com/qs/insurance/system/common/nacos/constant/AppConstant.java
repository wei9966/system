/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE 3.0;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.gnu.org/licenses/lgpl.html
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qs.insurance.system.common.nacos.constant;

/**
 * 系统常量
 *
 * @author Chill
 */
public interface AppConstant {

	/**
	 * 应用版本
	 */
	String APPLICATION_VERSION = "0.0.1";

	/**
	 * 基础包
	 */
	String BASE_PACKAGES = "org.springblade";

	/**
	 * 应用名前缀
	 */
	String APPLICATION_NAME_PREFIX = "system-";
	/**
	 * 网关模块名称
	 */
	String APPLICATION_GATEWAY_NAME = APPLICATION_NAME_PREFIX + "gateway";
	/**
	 *保险模块
	 */
	String APPLICATION_INSURANCE_NAME = APPLICATION_NAME_PREFIX + "insurance-server";

	/**
	 *UPMS用户模块
	 */
	String APPLICATION_UPMS_NAME = APPLICATION_NAME_PREFIX + "upms-server";
	/**
	 * 代码生成器模块
	 */
	String APPLICATION_CODEGEN_NAME = APPLICATION_NAME_PREFIX + "codegen";
	/**
	 * 聚码短信模块
	 */
	String APPLICATION_SHORT_MESSAGE_NAME = APPLICATION_NAME_PREFIX + "short-message-server";
	/**
	 * 工作流模块
	 */
	String APPLICATION_ACTIVITI_NAME = APPLICATION_NAME_PREFIX + "activiti-server";
	/**
	 * admin管理模块
	 */
	String APPLICATION_ADMIN_NAME = APPLICATION_NAME_PREFIX + "admin";
	/**
	 * 开发环境
	 */
	String DEV_CODE = "dev";
	/**
	 * 生产环境
	 */
	String PROD_CODE = "prod";
	/**
	 * 测试环境
	 */
	String TEST_CODE = "test";

	/**
	 * 代码部署于 linux 上，工作默认为 mac 和 Windows
	 */
	String OS_NAME_LINUX = "LINUX";

}
