/**
 * 
 */
package com.qzeng2490.security.core.properties;

/**
 * @author zhailiang
 *
 */
public class DefaultSocialProperties {

	private String appId;
	private String appSecret;

	public DefaultSocialProperties() {}

	public String getAppId() {
		return this.appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppSecret() {
		return this.appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

}
