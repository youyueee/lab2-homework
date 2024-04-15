package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MessageService;
import service.impl.MessageServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.UUID;

import java.sql.Timestamp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import bean.entity.Message;
/**
 * 
 * 实现留言发布的服务端入口程序。
 * 
 * @author xmwang
 * 
 */
public class PostMessageServlet extends HttpServlet {
       
  private static final long serialVersionUID = -81038999295282605L;

  private MessageService ms = new MessageServiceImpl();
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    BufferedReader br = request.getReader();
    JSONObject root = JSON.parseObject(br.readLine());
    JSONObject respJSON = new JSONObject();
    String uid = (String) request.getSession().getAttribute("uid");
    if(uid != null) { // 当前会话中用户是否登录
      String msgid = UUID.randomUUID().toString();
      String content = root.getString("content");
      Timestamp time = new Timestamp(System.currentTimeMillis());
      respJSON.put("posted", ms.post(new Message(msgid, uid, content, time)));
    }
    response.setContentType("application/json");
    response.setCharacterEncoding("utf-8");
    response.getWriter().println(respJSON.toJSONString());
  }

}
