/**
 * 
 */
package com.qzeng2490.web.config;

import com.google.common.base.Predicates;
import com.qzeng2490.security.MyUserDetailsService;
import com.qzeng2490.web.filter.TimeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhailiang
 *
 */
//@EnableWebSecurity
@Configuration
public class WebConfig implements WebMvcConfigurer {
	private final String[] patterns = new String[]{
					"/user/*"
	};

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.paths(Predicates.not(PathSelectors.regex("/error.*")))
				.build();
	}

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		// For example: Use only Http Basic and not form login.
//		http.authorizeRequests()
//						.requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
//						.antMatchers(patterns).permitAll()
//						.antMatchers(HttpMethod.POST, "/user/create").permitAll()
//						.anyRequest().authenticated()
//						.and()
//						.httpBasic();
//	}

//	@Bean
//	public static BCryptPasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// forward requests to /admin and /user to their index.html
//		registry.addViewController("/admin").setViewName(
//						"forward:/admin/index.html");
//		registry.addViewController("/user").setViewName(
//						"forward:/user/index.html");

		registry.addViewController("/").setViewName("forward:/index.html");
	}

//	@Bean
//	public static NoOpPasswordEncoder passwordEncoder() {
//		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
//	}
}