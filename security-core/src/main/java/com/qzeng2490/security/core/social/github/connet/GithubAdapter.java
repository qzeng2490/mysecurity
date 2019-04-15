/**
 * 
 */
package com.qzeng2490.security.core.social.github.connet;

import com.qzeng2490.security.core.social.github.api.Github;
import com.qzeng2490.security.core.social.github.api.GithubInfo;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

/**
 * @author zhailiang
 *
 */
public class GithubAdapter implements ApiAdapter<Github> {

	@Override
	public boolean test(Github api) {
		return true;
	}

	@Override
	public void setConnectionValues(Github api, ConnectionValues values) {
		GithubInfo userInfo = api.getUserInfo();
		
		values.setDisplayName(userInfo.getLogin());
		values.setImageUrl(userInfo.getAvatar_url());
		values.setProfileUrl(null);
		values.setProviderUserId(userInfo.getId());
	}

	@Override
	public UserProfile fetchUserProfile(Github api) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateStatus(Github api, String message) {
		//do noting
	}

}
