package com.Basics.ServletTypes;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class GenServlet extends GenericServlet {

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        PrintWriter pw = servletResponse.getWriter();
        servletResponse.setContentType("text/html");
        pw.println("<body bgcolor=\"grey\"></body>");
        pw.println("<hr><p>Generic SERVLET</p><hr>");
        pw.println("<a href=\"index.html\">go back</a>");
    }
}
