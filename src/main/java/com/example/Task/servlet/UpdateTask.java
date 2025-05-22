package com.example.Task.servlet;

import com.example.Task.conroller.Controller;
import com.example.Task.model.Task;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/update")
public class UpdateTask extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String deadline = req.getParameter("deadline");

        try {
            Controller c = new Controller();
            Task t = new Task(id, title, description, deadline);
            c.update(t);
            resp.sendRedirect("index.jsp");
        }
        catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
