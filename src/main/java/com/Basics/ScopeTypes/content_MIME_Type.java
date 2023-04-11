package com.Basics.ScopeTypes;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;

public class content_MIME_Type extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        resp.setContentType("image/png");//mime type
        ServletOutputStream sos = resp.getOutputStream();

        //read img
        InputStream ipS = getServletContext().getResourceAsStream("/IMAGES/java_logo.png");
        byte[] bar = new byte[ipS.available()];
        ipS.read(bar);

        sos.write(bar);
        sos.flush();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
