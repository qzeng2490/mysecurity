/**
 * 
 */
package com.qzeng2490.security.core.social.github.connet;

import com.qzeng2490.security.core.social.github.api.Github;
import com.qzeng2490.security.core.social.github.api.GithubImpl;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;

/**
 * @author zhailiang
 *
 */
public class GithubServiceProvider extends AbstractOAuth2ServiceProvider<Github> {

	private String appId;
	
	private static final String URL_AUTHORIZE = "https://github.com/login/oauth/authorize";
	
	private static final String URL_ACCESS_TOKEN = "https://github.com/login/oauth/access_token";
	
	public GithubServiceProvider(String appId, String appSecret) {
		super(new GithubOAuth2Template(appId, appSecret, URL_AUTHORIZE, URL_ACCESS_TOKEN));
		this.appId = appId;
	}
	
	@Override
	public Github getApi(String accessToken) {
		return new GithubImpl(accessToken, appId);
	}

}
