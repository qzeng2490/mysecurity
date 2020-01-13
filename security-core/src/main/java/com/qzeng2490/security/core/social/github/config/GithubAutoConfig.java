/**
 * 
 */
package com.qzeng2490.security.core.social.github.config;


import com.qzeng2490.security.core.properties.GithubProperties;
import com.qzeng2490.security.core.properties.SecurityProperties;
import com.qzeng2490.security.core.social.view.ImoocConnectView;
import com.qzeng2490.security.core.social.github.connet.GithubOAuth2ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.security.AuthenticationNameUserIdSource;
import org.springframework.web.servlet.View;

/**
 * @author zhailiang
 *
 */
@Configuration
@ConditionalOnProperty(prefix = "imooc.security.social.github", name = "app-id")
public class GithubAutoConfig extends SocialConfigurerAdapter {

	@Autowired
	private SecurityProperties securityProperties;

	@Override
	public void addConnectionFactories(ConnectionFactoryConfigurer configurer,
																		 Environment environment) {
		configurer.addConnectionFactory(createConnectionFactory());
	}

	@Override
	public UserIdSource getUserIdSource() {
		return new AuthenticationNameUserIdSource();
	}

	public ConnectionFactory<?> createConnectionFactory() {
		GithubProperties git = securityProperties.getSocial().getGithub();
		return new GithubOAuth2ConnectionFactory(git.getProviderId(), git.getAppId(), git.getAppSecret());
	}

	// 后补：做到处理注册逻辑的时候发现的一个bug：登录完成后，数据库没有数据，但是再次登录却不用注册了
	// 就怀疑是否是在内存中存储了。结果果然发现这里父类的内存ConnectionRepository覆盖了SocialConfig中配置的jdbcConnectionRepository
	// 这里需要返回null，否则会返回内存的 ConnectionRepository


	@Override
	public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
		return null;
	}

	@Bean({"connect/Connect", "connect/Connected"})
	@ConditionalOnMissingBean(name = "githubConnectedView")
	public View githubConnectedView() {
		View res = new ImoocConnectView();
		return res;
	}

}
