package com.example.web102;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

public class Request_Response_Scope extends HttpServlet {

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

        /*
        Response structure:-
         Status code
            100-199 : informational
            200-299 : Successful
            300-399 : Redirection
            400-499 : Client Errors
            500-599 : Server Errors
         Response Header
            location
            cookies
            refresh
         Response Body
            html+ dynamic content
            text stream
            binary stream
        */


        resp.setIntHeader("Refresh",60); //custom header for refresh
        resp.setLocale(Locale.JAPAN); //loc data
        resp.setStatus(202);//status code

        PrintWriter pw = resp.getWriter();
        resp.setContentType("text/html");
        pw.write("<div name=\"divider\">Calling all functionalities</div>");

        pw.write("<br>Locales:- "+resp.getLocale());
        pw.write("<br>Accept-Charset:- "+resp.getCharacterEncoding());
        pw.write("<br>ContentType:- "+resp.getContentType());
        pw.write("<br>Method Used:- "+req.getMethod());
        pw.write("<br> Date: "+new Date());
        pw.write("<br> Status: "+resp.getStatus());

        pw.write("<br><h3>Headers</h3>");
        Collection<String> hdr = resp.getHeaderNames();
        hdr.forEach(header->{
            pw.write("Header: "+header+" -> "+resp.getHeader(header)+"<br>");
        });

        pw.write("<br><a href=\"cmt\">Content Type/MIME Type Example");

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

        pw.write("<br><h3>Headers</h3>");
        Enumeration<String> head_r = req.getHeaderNames();
        while(head_r.hasMoreElements()){
            String str = head_r.nextElement();
            pw.write("Header: "+str+": "+req.getHeader(str)+"<br>");
        }



        pw.write("<hr>");
        pw.println("<a href=\"Scope.html\">Go Back</a>");


    }
}
