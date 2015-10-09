package com.ipartek.formacion.listeners;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class InitListener.
 *
 */
public class InitListener implements ServletContextListener, ServletContextAttributeListener {

  private static final String PATH_LOG4J = "WEB-INF/conf/log4j.properties";
  private static final Logger log = Logger.getLogger(InitListener.class);

  /**
   * Default constructor.
   */
  public InitListener() {
    // TODO Auto-generated constructor stub
  }

  /**
   * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent).
   */
  @Override
  public void attributeAdded(ServletContextAttributeEvent arg0) {
    // TODO Auto-generated method stub
  }

  /**
   * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent).
   */
  @Override
  public void attributeRemoved(ServletContextAttributeEvent arg0) {
    // TODO Auto-generated method stub
  }

  /**
   * @see ServletContextListener#contextDestroyed(ServletContextEvent).
   */
  @Override
  public void contextDestroyed(ServletContextEvent arg0) {
    // TODO Auto-generated method stub
  }

  /**
   * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent).
   */
  @Override
  public void attributeReplaced(ServletContextAttributeEvent arg0) {
    // TODO Auto-generated method stub
  }

  /**
   * @see ServletContextListener#contextInitialized(ServletContextEvent).
   */
  @Override
  public void contextInitialized(ServletContextEvent arg0) {
    cargaLog4j(arg0);
  }

  private void cargaLog4j(ServletContextEvent sce) {

    try {
      String pathReal = sce.getServletContext().getRealPath("/");
      PropertyConfigurator.configure(pathReal + InitListener.PATH_LOG4J);

      InitListener.log.trace("LOG cargado");
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
