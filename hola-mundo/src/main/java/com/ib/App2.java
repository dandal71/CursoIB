package com.ib;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App2 {

    public static final ApplicationContext CONTEXT;
    
    @Autowired private DataSource ds;
    
    static {
        CONTEXT = new ClassPathXmlApplicationContext("app-config.xml");
    }
    
    public static void main(String[] args) {
        App2 app = CONTEXT.getBean(App2.class);
        app.run();
    }

    public void run() {
        
        try(Connection conn = ds.getConnection()) {
            
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT curso_id, descripcion FROM cursos");
            
            while (rs.next()) {
                
                int id = rs.getInt("curso_id");
                String descripcion = rs.getString("descripcion");
                
                System.out.println("Curso: [" + id + "] " + descripcion);
            }
            
            stmt.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
