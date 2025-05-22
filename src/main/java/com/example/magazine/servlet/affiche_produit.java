package com.example.magazine.servlet;

import com.example.magazine.conroller.Controller;
import com.example.magazine.model.Produit;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/affiche")
public class affiche_produit extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Controller c = new Controller();
            String affiche="<lu>";
            for (Produit p : c.selectAll()){
                affiche+="<li>"+p.getName()+"</li><li>"+p.getPrice()+"</li>";
            }
            affiche+="</lu>";
            req.setAttribute("produits",affiche);
            req.getRequestDispatcher("afficher.jsp").forward(req,resp);
        }
        catch (ClassNotFoundException | SQLException e){
            throw new RuntimeException(e);
        }
    }
}
