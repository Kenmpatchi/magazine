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

@WebServlet("/ajout")
public class add_produit extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        String name=request.getParameter("name");
        int price=Integer.parseInt(request.getParameter("price"));
        try {
            Controller c = new Controller();
            Produit p=new Produit(name,price);
            c.insert(p);
            response.sendRedirect("index.jsp");
        }
        catch (ClassNotFoundException| SQLException e){
            throw new RuntimeException(e);
        }
    }
}
