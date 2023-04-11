package com.Basics.ScopeTypes;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class AppScope extends HttpServlet {

    //ServletContext obj
        //maintain app scope(set get context attributes)
        //get request-dispatcher
        //access web-context initialization in web.xml
        //logging
        //access web-context prop-file
        //access misc. info{ver, session timeout etc.}
    //how to access ServletContext Obj
        //request.getServletContext()
        //initMethod  config.getServletContext()
        //HTTP servlet has overridden getServletContext method hence can call directly if using HTTP servlet


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //or we can use init() and fetch context from there
        //req.getServletContext()
        ServletContext sc = getServletContext();
        PrintWriter pw = resp.getWriter();
        pw.write("<div><h2>Context Param</h2></div>");
        pw.write("<div><h3>"+sc.getInitParameter("DeUser")+"</h3></div>");
        pw.write("<div><h3>"+sc.getInitParameter("DeRights")+"</h3></div>");
        pw.write("<hr>");
        Enumeration<String> eu = sc.getInitParameterNames();
        while (eu.hasMoreElements()){
            String s = eu.nextElement();
            pw.write("<div><h3>"+s+" :- "+sc.getInitParameter(s)+"</h3></div>");

        }
        pw.write("Stars:-"+sc.getInitParameter("Stars"));
        pw.write("<hr>");
        pw.println("<a href=\"Scope.html\">Go Back</a>");



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
