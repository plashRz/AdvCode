package com.Basics.ServletTypes;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class handMadeServlet implements Servlet {

    ServletConfig scfg = null;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        scfg = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return scfg;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        PrintWriter pwr = servletResponse.getWriter();
        servletResponse.setContentType("text/html");
        pwr.println("<h1>Time now is:<br>"+new Date()+"</h1>");
        pwr.println("<p>"+getServletConfig().getServletName()+"\n<br>\n"+getServletConfig()+"</p>");
        pwr.println("<a href=\"index.html\">go back</a>");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
