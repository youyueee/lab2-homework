package servlet;

import bean.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserService;
import service.impl.UserServiceImpl;
import utils.MDGenerator;

import java.io.IOException;

/**
 * 
 * 实现用户注册的服务端入口程序。
 * 
 * @author xmwang
 * 
 */
public class RegisterServlet extends HttpServlet {

  private static final long serialVersionUID = -1485882677997956764L;
  private UserService us = new UserServiceImpl();

  @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    response.setCharacterEncoding("utf-8");
    
    // 基于POST参数创建用户对象
    String name = request.getParameter("name");
    String password = request.getParameter("password");
    String email = request.getParameter("email");
    String uid = name.charAt(0) + String.valueOf(System.currentTimeMillis());
    User u= new User(uid, name, MDGenerator.md5(password), email);

    // 注册，并根据注册结果进行响应
    if(us.register(u).isPresent()) {
      response.sendRedirect("./login.html");
    }else {
      response.getWriter().println("注册失败<hr />");
      request.getRequestDispatcher("/register.html").include(request, response);
    }
	}

  public UserService getUs() {
    return us;
  }

  public void setUs(UserService us) {
    this.us = us;
  }

}
