package com.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DatabaseConnectionListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent event) {
		System.out.println("++++++++++++++++contextInitialized+++++++++++++++++");
		Session session = null;
		System.out.println("Making Connection");
		try {
			SessionFactory sessionFactory = new Configuration().configure("hibernate_config.xml").buildSessionFactory();
			session = sessionFactory.openSession();
			ServletContext ctx = event.getServletContext();
			ctx.setAttribute("orm-session", session);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("++++++++++++++++contextDestroyed+++++++++++++++++");
	}
}
