package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/**
 * 
 * 实现用户退出的服务端入口程序。
 * 
 * @author xmwang
 * 
 */
public class LogoutServlet extends HttpServlet{

  private static final long serialVersionUID = 244021452500444424L;

  
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html");
    resp.setCharacterEncoding("utf-8");
    
    resp.addCookie(new Cookie("name", "")); // 删除用户端存储的信息
    req.getSession().invalidate();

    resp.sendRedirect("./message.html");
  }

}
