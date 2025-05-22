package com.example.magazine.conroller;

import com.example.magazine.dbconnect;
import com.example.magazine.model.Produit;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    dbconnect db=new dbconnect();
    private Connection conn=null;
    private Statement st=null;
    private ResultSet rs=null;

    public Controller() throws ClassNotFoundException, SQLException {
        db.connect();
        conn=db.getConn();
    }

    public void insert(Produit p)throws SQLException {
        st=conn.createStatement();
        st.executeUpdate("insert into produit(name,price)values('"+p.getName()+"','"+p.getPrice()+ "')");
    }
    public List<Produit> selectAll()throws SQLException{
        st=conn.createStatement();
        rs=st.executeQuery("select * from produit");
        List<Produit> produits=new ArrayList<>();
        while (rs.next()){
            produits.add(new Produit(rs.getInt(1),rs.getString(2), rs.getInt(3)));
        }
        return produits;
    }
}
