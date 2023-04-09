package com.example2.filter_Servlet;

import jakarta.servlet.*;

import java.io.IOException;


public class servFilters2 implements Filter {


    /*
    * filter is a component for intercepting and modifying req and resp.
    * filter can:
    * Marking access or blocking access
    * caching, compression, logging
    * authentication, access control, encryption
    * content transformation
    *
    * methods
    * - init()
    * - destroy()
    * - doFilter(req,resp,filter chain)
    * */

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        //filter logic
        System.out.println("Before filter - 2");
        //filter or servlet
        chain.doFilter(request,response);
        //post doFilter chain
        System.out.println("After servlet - 2");

    }

}
