package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MessageService;
import service.impl.MessageServiceImpl;

import java.io.IOException;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

import bean.transfer.MessageJoinUser;
/**
 * 
 * 实现获取留言列表的服务端入口程序。
 * 
 * @author xmwang
 * 
 */
public class GetMessagesServlet extends HttpServlet {
    private static final long serialVersionUID = 1818420990535117329L;
    private MessageService ms = new MessageServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        List<MessageJoinUser> list = ms.getMessages(100, 1);
        response.getWriter().println(JSONObject.toJSONString(list));
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}