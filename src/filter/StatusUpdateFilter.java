package filter;

import jakarta.servlet.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class StatusUpdateFilter implements Filter{
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        resp.setContentType("text/html");
        String name = (String) req.getSession().getAttribute("name");
        if(name != null) {
            resp.addCookie(new Cookie("name", name)); // 登录用户
        }else {
            resp.addCookie(new Cookie("name", "")); // 游客
        }
        chain.doFilter(request, response);
    }
}