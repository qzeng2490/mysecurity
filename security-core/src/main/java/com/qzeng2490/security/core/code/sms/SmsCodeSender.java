/**
 * 
 */
package com.qzeng2490.security.core.code.sms;

/**
 * @author zhailiang
 *
 */
public interface SmsCodeSender {
	
	void send(String mobile, String code);

}
