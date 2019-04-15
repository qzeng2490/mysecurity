/**
 * 
 */
package com.qzeng2490.security.core.properties;

/**
 * @author zhailiang
 *
 */
public class QQProperties extends DefaultSocialProperties {
	
	private String providerId = "qq";

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}
	
}
// https://open.weixin.qq.com/connect/qrconnect?
// client_id=wxdc1f984cb377e6b4&response_type=code&
// redirect_uri=http%3A%2F%2Fwww.pingzhi365.com%2FqqLogin%2Fweixin&
// state=2ee1c1fc-3c07-4847-8a5c-0b513e0ccd77&
// appid=wxdc1f984cb377e6b4&
// scope=snsapi_login

//https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxdc1f984cb377e6b4&redirect_uri=http%3A%2F%2Fwww.pingzhi365.com%2FqqLogin%2Fweixin&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect


//https://open.weixin.qq.com/connect/qrconnect?appid=wxbdc5610cc59c1631&redirect_uri=https%3A%2F%2Fpassport.yhd.com%2Fwechat%2Fcallback.do&response_type=code&scope=snsapi_login&state=3d6be0a4035d839573b04816624a415e#wechat_redirect

//https://open.weixin.qq.com/connect/qrconnect?appid=wxdc1f984cb377e6b4&redirect_uri=http%3A%2F%2Fwww.pingzhi365.com%2FqqLogin%2Fweixin&response_type=code&scope=snsapi_base&state=3d6be0a4035d839573b04816624a415e#wechat_redirect



