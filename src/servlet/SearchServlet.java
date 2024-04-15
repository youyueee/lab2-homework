package servlet;

import bean.entity.Message;
import bean.transfer.MessageJoinUser;
import com.alibaba.fastjson.JSONObject;
import dao.MessageDao;
import dao.impl.MessageDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.MessageService;
import service.impl.MessageServiceImpl;

import java.io.IOException;
import java.util.List;


public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        // 获取表单提交的数据，封装到 Message 对象中
        String keyword = request.getParameter("keyword");

        // 执行数据库 JDBC 模糊查询
        MessageService ms=new MessageServiceImpl();
        List<MessageJoinUser> messageList = ms.search("%"+keyword+"%");

        // 将查询结果存储到会话中
        request.setAttribute("messageList", messageList);
        System.out.println(messageList.toString());
        // 转发到 search.html 页面
        request.getRequestDispatcher("/search.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
