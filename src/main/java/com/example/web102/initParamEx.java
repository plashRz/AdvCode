package com.example.web102;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class initParamEx extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        resp.setContentType("text/html");
        pw.println("<h3>The Feed for "+getInitParameter("Org-Name")+" is:-</h3><hr>");
        pw.println("<h4>"+req.getParameter("area")+"</h4><hr>");
        pw.println("<a href=\"index.html\">Return to Home</a>");


    }
}
