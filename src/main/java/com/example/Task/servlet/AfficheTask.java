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

@WebServlet("/affiche")
public class AfficheTask extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Controller c = new Controller();
            String affiche = "<table border='1'>";
            affiche += "<tr><th>Title</th><th>Description</th><th>Deadline</th><th>Actions</th></tr>";
            for (Task t : c.selectAll()) {
                affiche += "<tr>";
                affiche += "<td>" + t.getTitle() + "</td>";
                affiche += "<td>" + t.getDescription() + "</td>";
                affiche += "<td>" + t.getDeadline() + "</td>";
                affiche += "<td>";
                affiche += "<form action='delete' method='post'><input type='hidden' name='id' value='" + t.getId() + "'>";
                affiche += "<input type='submit' value='Delete'></form>";
                affiche += " <a href='update.jsp?id=" + t.getId() + "'>Update</a>";
                affiche += "</td>";
                affiche += "</tr>";
            }
            affiche += "</table>";
            affiche += "";
            req.setAttribute("tasks", affiche);
            req.getRequestDispatcher("affiche.jsp").forward(req, resp);
        }
        catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
