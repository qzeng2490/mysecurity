/**
 * 
 */
package com.qzeng2490.web.config;

import com.qzeng2490.web.filter.TimeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhailiang
 *
 */
@EnableWebSecurity
@Configuration
public class WebConfig extends WebSecurityConfigurerAdapter {
	private final String[] patterns = new String[]{
					"/user/*"
	};
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// For example: Use only Http Basic and not form login.
		http.authorizeRequests()
						.requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
						.antMatchers(patterns).permitAll()
						.antMatchers(HttpMethod.POST, "/user/create").permitAll()
						.anyRequest().authenticated()
						.and()
						.httpBasic();
	}

//	@Bean
//	public static BCryptPasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}


	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
}