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
        
        try(Connection connection = ds.getConnection()) {
            
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM curso");
            
            while (rs.next()) {
                
                int id = rs.getInt("id");
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("-------------------------------------");                
            }
            
            stmt.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
