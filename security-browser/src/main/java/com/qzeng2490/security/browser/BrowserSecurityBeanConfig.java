/**
 * 
 */
package com.qzeng2490.security.browser;

import com.qzeng2490.security.browser.logout.ImoocLogoutSuccessHandler;
import com.qzeng2490.security.browser.session.ImoocExpiredSessionStrategy;
import com.qzeng2490.security.browser.session.ImoocInvalidSessionStrategy;
import com.qzeng2490.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

/**
 * @author zhailiang
 *
 */
@Configuration
public class BrowserSecurityBeanConfig {

	@Autowired
	private SecurityProperties securityProperties;

	/**
	 * session失效时的处理策略配置
	 * @return
	 */
	@Bean
	@ConditionalOnMissingBean(InvalidSessionStrategy.class)
	public InvalidSessionStrategy invalidSessionStrategy(){
		return new ImoocInvalidSessionStrategy(securityProperties);
	}

	/**
	 * 并发登录导致前一个session失效时的处理策略配置
	 * @return
	 */
	@Bean
	@ConditionalOnMissingBean(SessionInformationExpiredStrategy.class)
	public SessionInformationExpiredStrategy sessionInformationExpiredStrategy(){
		return new ImoocExpiredSessionStrategy(securityProperties);
	}

	/**
	 * 退出时的处理策略配置
	 *
	 * @return
	 */
	@Bean
	@ConditionalOnMissingBean(LogoutSuccessHandler.class)
	public LogoutSuccessHandler logoutSuccessHandler(){
		return new ImoocLogoutSuccessHandler(securityProperties.getBrowser().getSignOutUrl());
	}

}
