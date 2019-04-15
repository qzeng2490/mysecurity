package com.qzeng2490.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.stereotype.Controller;

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
}