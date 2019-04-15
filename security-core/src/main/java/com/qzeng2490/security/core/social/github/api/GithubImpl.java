/**
 * 
 */
package com.qzeng2490.security.core.social.github.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

/**
 * @author zhailiang
 *
 */
public class GithubImpl extends AbstractOAuth2ApiBinding implements Github {
	
//	private static final String URL_GET_OPENID = "https://graph.qq.com/oauth2.0/me?access_token=%s";
	
	private static final String URL_GET_USERINFO = "https://api.github.com/user";
//	https://api.github.com/user?access_token=
//	private String appId;
	
//	private String openId;
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	public GithubImpl(String accessToken, String appId) {
		super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);

	}
	
	/* (non-Javadoc)
	 * @see com.imooc.security.core.social.qq.api.QQ#getUserInfo()
	 */
	@Override
	public GithubInfo getUserInfo() {

		String result = getRestTemplate().getForObject(URL_GET_USERINFO, String.class);

		System.out.println(result);

		GithubInfo userInfo = null;
		try {
			userInfo = objectMapper.readValue(result, GithubInfo.class);
			return userInfo;
		} catch (Exception e) {
			throw new RuntimeException("获取用户信息失败", e);
		}
	}

}
