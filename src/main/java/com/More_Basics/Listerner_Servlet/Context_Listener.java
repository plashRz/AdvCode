package com.More_Basics.Listerner_Servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

import java.util.Enumeration;
import java.util.concurrent.atomic.AtomicInteger;

public class Context_Listener implements ServletContextListener {

    /*
    * listener listen to events and trigger functionality
    * types:-
    * 1. ServletContext
    *   a) startup/shutdown
    *   b) attribute changes
    * 2. Request
    *   a) creation
    *   b) attribute changes
    * 3. HttpSession
    *   a) creation and invalidation
    *   b) changes in attribute
    *   c) session migration {from 1 jvm to another}
    *   d) session obj bound/unbound {add or remove from session scope}
    * */

    /*
    * Interfaces
    * CONTEXT
    * - ServletContextListener
    *   contextInitialized/Destroyed(ServletContextEvent)
    * - ServletContextAttributeListener
    *   attributeAdded/Removed/Replaced(ServletContextAttributeEvent)
    *
    * REQUEST
    * - ServletRequestListener
    *   requestCreated/Destroyed(ServletRequestEvent)
    * - ServletRequestAttributeListener
    *   attributeAdded/Removed/Replaced(ServletRequestAttributeEvent)
    *
    * HTTPSESSION
    * - HttpSessionListener
    *   requestCreated/Destroyed(HttpSessionEvent)
    * - HttpSessionAttributeListener
    *   attributeAdded/Removed/Replaced(HttpSessionAttributeEvent)
    * - HttpSessionActivationListener
    *   sessionWillPassivate(HttpSessionEvent)
    *   sessionDidActivate(HttpSessionEvent)
    * - HttpSessionBindingListener
    *   valueBound/Unbound(HttpSessionBindingEvent)
    * */

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        System.out.println("App is Started");
        ServletContext sc = sce.getServletContext();
        AtomicInteger atm = new AtomicInteger(5);
        sc.setAttribute("Stars",atm);
        sc.setAttribute("Domain", "EveryWhere");
        sc.setInitParameter("Stars",atm.toString());

        String str = sc.getInitParameter("Domain");

        if(str!=null){
            System.out.println(sc.setInitParameter("Domain","Private"));
        }

        System.out.println("===============================================");
        Enumeration<String> eu = sc.getInitParameterNames();
        while (eu.hasMoreElements()){
            String s = eu.nextElement();
            System.out.println(s+":- "+sc.getInitParameter(s));
        }
        System.out.println("===============================================");


        System.out.println(sc.getAttribute("Stars"));
        System.out.println(sc.getAttribute("Domain"));
        System.out.println("===============================================");
        System.out.println("ADAPTED!!");
        System.out.println("===============================================");

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("App is stopped");
    }
}
