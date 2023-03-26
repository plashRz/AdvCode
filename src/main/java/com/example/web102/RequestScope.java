package com.example.web102;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class RequestScope extends HttpServlet {

    //request scope ends when req is responded to
    //info that ServReq contains
        /*
        client parameters
        Object-value Attributes(Req scope)
        Locales
        Content-length
        Cookies
        Accept-Charset
        */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter pw = resp.getWriter();
        resp.setContentType("text/html");
        //resp.setAttribute("anything","some random attribute");

        pw.write("<div name=\"divider\">Calling all functionalities</div>");

        //pw.write("<br>Client Parameters:- "+resp.getParameter("rq"));
        //pw.write("<br>Attribute:- "+resp.getAttribute("anything"));
        //locale is req lang or browser lang... our response is acc to that
        pw.write("<br>Locales:- "+resp.getLocale());
        //pw.write("<br>Cookies:- "+resp.getCookies()[0]);
        //pw.write("<br>Content-Length:- "+resp.getContentLength());
        pw.write("<br>Accept-Charset:- "+resp.getCharacterEncoding());
        pw.write("<br>ContentType:- "+resp.getContentType());
//        pw.write("<br>ServerName:- "+resp.getServerName());
//        pw.write("<br>ReqUrl:- "+resp.getRequestURL());
//        pw.write("<br>ReqUri:- "+resp.getRequestURI());
//        pw.write("<br>LocalPort:- "+resp.getLocalPort());
        pw.write("<br>Method Used:- "+req.getMethod());


        pw.write("<hr>");
        pw.println("<a href=\"Scope.html\">Go Back</a>");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter pw = resp.getWriter();
        resp.setContentType("text/html");
        req.setAttribute("anything","some random attribute");

        pw.write("<div name=\"divider\">Calling all functionalities</div>");

        pw.write("<br>Client Parameters:- "+req.getParameter("rq"));
        pw.write("<br>Attribute:- "+req.getAttribute("anything"));
        //locale is req lang or browser lang... our response is acc to that
        pw.write("<br>Locales:- "+req.getLocale());
        pw.write("<br>Cookies:- "+req.getCookies()[0]);
        pw.write("<br>Content-Length:- "+req.getContentLength());
        pw.write("<br>Accept-Charset:- "+req.getCharacterEncoding());
        pw.write("<br>ContentType:- "+req.getContentType());
        pw.write("<br>ServerName:- "+req.getServerName());
        pw.write("<br>ReqUrl:- "+req.getRequestURL());
        pw.write("<br>ReqUri:- "+req.getRequestURI());
        pw.write("<br>LocalPort:- "+req.getLocalPort());
        pw.write("<br>Method Used:- "+req.getMethod());


        pw.write("<hr>");
        pw.println("<a href=\"Scope.html\">Go Back</a>");
    }
}
