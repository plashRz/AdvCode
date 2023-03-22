package com.example.web101;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;

public class ServHttp extends HttpServlet {

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        PrintWriter pw = servletResponse.getWriter();
        servletResponse.setContentType("text/html");
        pw.println("<body bgcolor=\"green\"></body>");
        pw.println("<hr><p>HTTP SERVLET</p><hr>");
        pw.println("<a href=\"index.html\">go back</a>");
    }
}
