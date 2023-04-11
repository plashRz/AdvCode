package com.Basics.ServletTypes;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServHttp extends HttpServlet {

//    @Override
//    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
//        PrintWriter pw = servletResponse.getWriter();
//        servletResponse.setContentType("text/html");
//        pw.println("<body bgcolor=\"green\"></body>");
//        pw.println("<hr><p>HTTP SERVLET</p><hr>");
//        pw.println("<a href=\"index.html\">go back</a>");
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        resp.setContentType("text/html");
        pw.println("<body bgcolor=\"green\"></body>");
        pw.println("<hr><p>Http Servlet - GET Request </p><hr>");
        pw.println("<a href=\"index.html\">go back</a>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        resp.setContentType("text/html");
        pw.println("<body bgcolor=\"teal\"></body>");
        pw.println("<hr><p>Http Servlet - Post Request </p><hr>");
        pw.println("<a href=\"index.html\">go back</a>");
    }
}
