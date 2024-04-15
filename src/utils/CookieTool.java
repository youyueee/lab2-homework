package utils;

import jakarta.servlet.http.Cookie;
/**
 * 
 * 面向Cookie处理的工具类。
 * 
 * @author xmwang
 * 
 */
public class CookieTool {
  public static String getValueByName(String name, Cookie[] cookies) {
    String value = "";
    for(Cookie c : cookies) {
      if(c.getName().equals(name)) {
        value = c.getValue();
      }
    }
    return value;
  }
}
