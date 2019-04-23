package com.qzeng2490.security.app.social;

import com.qzeng2490.security.app.authentication.ImoocAuthenticationSuccessHandler;
import com.qzeng2490.security.core.social.support.SocialAuthenticationFilterPostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.stereotype.Component;

/**
 * @Author: Qiang Zeng
 * @Date: Created in 00:08 2019-04-24
 */
@Component
public class AppSocialAuthenticationFilterPostProcessor implements SocialAuthenticationFilterPostProcessor {

  @Autowired
  ImoocAuthenticationSuccessHandler imoocAuthenticationSuccessHandler;

  @Override
  public void process(SocialAuthenticationFilter socialAuthenticationFilter) {
    socialAuthenticationFilter.setAuthenticationSuccessHandler(imoocAuthenticationSuccessHandler);
  }
}
