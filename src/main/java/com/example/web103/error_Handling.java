package com.example.web103;

import com.example.CustomException.myException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class error_Handling extends HttpServlet {

    //web container generates a default error page.
    //we can also specify custom default page


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        throw new myException();
    }
}
