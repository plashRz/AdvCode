package com.Basics.ScopeTypes;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

public class SessionScope extends HttpServlet {

    AtomicInteger ati = new AtomicInteger(1);

    //Session: series of contiguous actions by a visitor within a given timeframe
    //we need to maintain session ie if the req is sent by same user or diff user
    //Http is stateless... web-container will receive req and process and send response ie conn terminated
    //hence a new conn for next req
    // soo to keep track of req from same user we use session


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter pr = resp.getWriter();
        HttpSession hts = req.getSession();
        resp.setContentType("text/html");


        //set and get attribute for session is server side but cookie is client side
        //Attribute: server side
        //Cookie: client side

        //getAtt returns obj type
        Object objSession = hts.getAttribute("id");

        // then a basic comparison to check if it's the first visit
        if(objSession == null){
            hts.setAttribute("id","been there"); //attribute name, its value
            pr.write("Welcome! seems its the first time you been here.");
        }else{
            //getId gets the current session id or cookieid
            pr.write("Hello "+hts.getId()+" seems you have "+hts.getAttribute("id"));

            //using below code to play with current session
            hts.setAttribute("counter",ati.getAndIncrement());
            pr.write("<br>"+hts.getAttribute("counter"));

            if((int)hts.getAttribute("counter")==5){
                //alternative we can go to browser inspect elements and delete cookies
                //that will also have the same effect as invalidate
                hts.invalidate();//manually invalidating session on second req
                ati.set(1);
            }

        }
        pr.write("<hr>");
        pr.println("<a href=\"Scope.html\">Go Back</a>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
