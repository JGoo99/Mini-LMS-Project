package com.zerobase.fastlms.util;

import javax.servlet.http.HttpServletRequest;

// TODO
public class RequestUtils {

  public static String getUserAgent(HttpServletRequest request) {
    return request.getHeader("User-Agent");
  }

  public static String getClientIp(HttpServletRequest request) {
    String ip = request.getHeader("X-Forwarded-For");

    if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
      ip = request.getHeader("Proxy-Client-IP");
    }

    if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
      ip = request.getHeader("WL-Proxy-Client-IP");
    }

    if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
      ip = request.getHeader("HTTP_CLIENT_IP");
    }

    if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
      ip = request.getHeader("HTTP_X_FORWARDED_FOR");
    }

    if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
      ip = request.getRemoteAddr();
    }

    return ip;
  }
}
