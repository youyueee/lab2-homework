package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserService;
import service.impl.UserServiceImpl;
import utils.MDGenerator;

/**
 * 
 * 实现用户登录的服务端入口程序。
 * 
 * @author xmwang
 * 
 */
public class LoginServlet extends HttpServlet{
  
  private static final long serialVersionUID = 244021452500444424L;

  private UserService us = new UserServiceImpl();
  
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html"); 
    PrintWriter out = resp.getWriter();
    String name = req.getParameter("name");  
    String password = req.getParameter("password");
    Optional<String> uid = us.validate(name, MDGenerator.md5(password));
    if(uid.isPresent()) {
      req.getSession().setAttribute("name", name);
      req.getSession().setAttribute("uid", uid.get()); // 新增
      resp.addCookie(new Cookie("name", name)); // 前端保存用户名
      resp.sendRedirect("./message.html"); // 前端跳转
    }else {
      out.println("登录失败<hr/>");
      req.getRequestDispatcher("/login.html").include(req, resp);
    }
  }

  public UserService getUs() {
    return us;
  }

  public void setUs(UserService us) {
    this.us = us;
  }
  
}
