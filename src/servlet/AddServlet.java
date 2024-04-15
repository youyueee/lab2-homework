package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;
import java.util.HashMap;

/**
 * Servlet implementation class AddServlet
 */
public class AddServlet extends HttpServlet {
       
  private static final long serialVersionUID = -5639639848541937749L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
	  JSONObject root = JSON.parseObject(request.getReader().readLine());
	  double a = root.getFloat("a");
	  double b = root.getFloat("b");
	  double res = a + b;
	  
	  Map<String, Double> m = new HashMap<String, Double>();
	  m.put("res", res);
	  
	  response.setContentType("application/json");
	  response.setCharacterEncoding("utf-8");
	  response.getWriter().println(JSONObject.toJSONString(m));
	}

}
