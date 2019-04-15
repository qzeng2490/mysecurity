/**
 * 
 */
package com.qzeng2490.security.core.properties;

/**
 * @author zhailiang
 *
 */
public class GithubProperties extends DefaultSocialProperties {
	
	private String providerId = "github";

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}
	
}
