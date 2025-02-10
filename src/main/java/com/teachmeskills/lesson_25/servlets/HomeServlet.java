package com.teachmeskills.lesson_25.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();

        resp.setContentType("text/html");

        HttpSession session = req.getSession();

        if (session.getAttribute("role") != null) {

            writer.println("<h3>The person has been identified</h3>");
            writer.println("<p>User name : " + session.getAttribute("username") + "</p>");
            writer.println("<p>Role : " + session.getAttribute("role") + "</p>");

        } else {

            writer.println("<h3>The person has not been identified</h3>");
        }
    }
}
