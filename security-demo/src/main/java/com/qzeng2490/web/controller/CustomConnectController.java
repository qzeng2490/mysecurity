package com.qzeng2490.web.controller;

import com.qzeng2490.security.core.social.ImoocConnectView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;

/**
 * @Author: Qiang Zeng
 * @Date: Created in 15:55 2019-04-15
 */
@Controller
public class CustomConnectController extends ConnectController {

  @Autowired
  public CustomConnectController(
          ConnectionFactoryLocator connectionFactoryLocator,
          ConnectionRepository connectionRepository) {
    super(connectionFactoryLocator, connectionRepository);
  }


  protected String connectView(String providerId) {
    return "connect/Connect";
  }


  protected String connectedView(String providerId) {
    return "connect/Connected";
  }
}