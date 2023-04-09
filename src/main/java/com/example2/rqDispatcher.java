package com.example2;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class rqDispatcher extends HttpServlet {

    //another servlet will continue this response object.
    //to reach from 1 servlet to another or to/from JSP we need the servlet context

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = req.getServletContext();
        RequestDispatcher rqd = context.getRequestDispatcher("/incl1");
        //both ways work
        //RequestDispatcher rqd1 = req.getRequestDispatcher("incl1");
        PrintWriter pw = resp.getWriter();
        pw.write("<h1>Hello!!!! from RqD</h1>");
        req.setAttribute("something","value is also something");
        HttpSession hts = req.getSession();
        Object objSession = hts.getAttribute("id");

        if(objSession == null){
            //this is an attribute called id not session ID
            System.out.println(hts.getAttribute("id"));
            hts.setAttribute("id","someB****");
            System.out.println(hts.getAttribute("id"));
            rqd.include(req,resp);
        }else {
            hts.invalidate();
            req.setAttribute("something","value is nothing");
            rqd.forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
