package com.example2;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Redirector extends HttpServlet {

    // how browser does it:-
    /*
    * res.setStatus(res.SC_MOVED_PERMANENTLY);
    * res.setHeader("Location","http://...")
    *
    * How we do it in java
    * public void sendRedirect(String url)
    *  this is broken down to those 2 statement above on browser as it only understands those.
    *
    * */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("<br>HELLO 123!<br>");
        resp.sendRedirect("index.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
