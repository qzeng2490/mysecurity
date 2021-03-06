package com.qzeng2490.security.core.social.weixin.connect;

import com.qzeng2490.security.core.social.qq.api.QQ;
import com.qzeng2490.security.core.social.qq.connet.QQAdapter;
import com.qzeng2490.security.core.social.qq.connet.QQServiceProvider;
import com.qzeng2490.security.core.social.weixin.api.Weixin;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;

/**
 * @Author: Qiang Zeng
 * @Date: Created in 16:04 2019-04-08
 */
public class WeixinOAuth2ConnectionFactory extends OAuth2ConnectionFactory<Weixin> {
  /**
   * 唯一的构造函数，需要
   * Create a {@link OAuth2ConnectionFactory}.
   * @param providerId 服务商id；自定义字符串；也是后面添加social的过滤，过滤器帮我们拦截的url其中的某一段地址
   *                   on} interface.
   */
  public WeixinOAuth2ConnectionFactory(String providerId, String appid, String secret) {
    // 传递进来是因为使用该服务的地方才知道  这些参数是什么
    /**
     * serviceProvider 用于执行授权流和获取本机服务API实例的ServiceProvider模型
     * apiAdapter      适配器，用于将不同服务提供商的个性化用户信息映射到 {@link Connection}
     */
    super(providerId, new WeixinServiceProvider(appid, secret), new WeixinAdapter(appid));
  }
}

