package com.example.Task.conroller;

import com.example.Task.dbconnect;
import com.example.Task.model.Task;

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

    public void insert(Task t) throws SQLException {
        st = conn.createStatement();
        st.executeUpdate("insert into task(title, description, deadline) values('"
                + t.getTitle() + "', '" + t.getDescription() + "', '" + t.getDeadline() + "')");
    }

    public List<Task> selectAll() throws SQLException {
        st = conn.createStatement();
        rs = st.executeQuery("select * from task");
        List<Task> tasks = new ArrayList<>();
        while (rs.next()) {
            tasks.add(new Task(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
        }
        return tasks;
    }

    public void update(Task t) throws SQLException {
        st = conn.createStatement();
        st.executeUpdate("update task set title='" + t.getTitle() + "', description='"
                + t.getDescription() + "', deadline='" + t.getDeadline() + "' where id=" + t.getId());
    }

    public void delete(int id) throws SQLException {
        st = conn.createStatement();
        st.executeUpdate("delete from task where id=" + id);
    }
}
