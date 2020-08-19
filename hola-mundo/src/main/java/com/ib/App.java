package com.ib; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    
    public static final ApplicationContext CONTEXT;
    
    static {
        CONTEXT = new ClassPathXmlApplicationContext("app-config.xml");
    }
    
    @Autowired private Sumadora sumadora;
    
    public static void main( String[] args ) {
        // Con Spring ya no hace fala
        /*
        App app = new App();
        app.run();
        */
        App app = CONTEXT.getBean(App.class);
        app.run();
    }

    // Con Spring ya no hace fala
    /*
    public App() { 
        //this.sumadora = new Sumadora();
    }
    */
    
    public void run() {
        int a = 1;
        int b = 3;
        //Sumadora sumadora = new Sumadora();
        int r = sumadora.sumar(a, b);
        System.out.println("Resultado: " + r);
    }
}
