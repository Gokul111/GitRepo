package com.l7.i18n;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ListenerExample implements ServletContextListener {

    public ListenerExample() {
        // TODO Auto-generated constructor stub
    }
    public void contextDestroyed(ServletContextEvent sce)  { 
       System.out.println("Server stopped");
    }

    public void contextInitialized(ServletContextEvent sce)  { 
         System.out.println("Server Running");
    }
	
}
