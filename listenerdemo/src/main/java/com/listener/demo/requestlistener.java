package com.listener.demo;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class requestlistener
 *
 */
@WebListener
public class requestlistener implements ServletRequestListener {

    public void requestDestroyed(ServletRequestEvent sre)  { 
         System.out.println("Request Destroyed");
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent sre)  { 
         System.out.println("Request Created");
    }
	
}
