package com.teachmeskills.lesson_25.servlets;

import com.teachmeskills.lesson_25.storage.MockStorage;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();

        resp.setContentType("text/html");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username != null && password != null) {

            if (MockStorage.doesUserExist(username, password)) {

                HttpSession session = req.getSession();

                if (session.getAttribute("username") != null) {

                    if (session.getAttribute("username").equals(username)) {

                        out.println("<h2>You are already authenticated</h2>");

                    } else {

                        session.removeAttribute("username");
                        session.removeAttribute("role");

                        session.setAttribute("username", username);
                        session.setAttribute("role", MockStorage.getRole(username, password));

                        out.println("<h2>authentication was successful</h2>");
                    }
                } else {

                    session.setAttribute("username", username);
                    session.setAttribute("role", MockStorage.getRole(username, password));

                    out.println("<h2>authentication was successful</h2>");
                }
            } else {
                out.println("<h2>Incorrect login or password</h2>");
            }
        } else {
            out.println("<h2>Invalid input</h2>");
        }
    }
}
