package com.qzeng2490.web.controller;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.TreeSet;

/**
 * @Author: Qiang Zeng
 * @Date: Created in 11:24 2019-04-11
 */
@Controller
@RequestMapping("/weixin")
public class WeChatController {
  private static final Logger LOG = LoggerFactory.getLogger(WeChatController.class);

  @RequestMapping(value = "/verify", method = RequestMethod.GET)
  public void index(HttpServletRequest request, HttpServletResponse response) {
    LOG.info("微信接入服务器");
    String signature = request.getParameter("signature");
    String timestamp = request.getParameter("timestamp");
    String nonce = request.getParameter("nonce");
    String token = "weixin";
    String echostr = request.getParameter("echostr");
    if (verifyInfo(signature, timestamp, nonce, token)) {
      LOG.info("echostr为:{}", echostr);
      if (echostr != null) {
        try {
          response.getWriter().write(echostr);
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    } else {
      LOG.info("signature为:{}", signature);
      LOG.info("timestamp为:{}", timestamp);
      LOG.info("nonce为:{}", nonce);
      LOG.info("token为:{}", token);
    }
  }

  public Boolean verifyInfo(String signature, String timestamp, String nonce,
                            String token) {
    TreeSet<String> set = new TreeSet<String>();
    set.add(token);
    set.add(timestamp);
    set.add(nonce);
    StringBuilder sBuilder = new StringBuilder();
    for (String item : set) {
      sBuilder.append(item);
    }
    String sign = DigestUtils.sha1Hex(sBuilder.toString());
    return signature.equalsIgnoreCase(sign);
  }

}
