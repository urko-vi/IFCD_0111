package com.ipartek.formacion.listeners;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionListener.
 *
 */
public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener {

  private static final Logger LOG = Logger.getLogger("ACCESOS");

  /**
   * Default constructor.
   */
  public SessionListener() {
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpSessionListener#sessionCreated(HttpSessionEvent).
   */
  @Override
  public void sessionCreated(HttpSessionEvent arg0) {
    // TODO Auto-generated method stub
  }

  /**
   * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent).
   */
  @Override
  public void sessionDestroyed(HttpSessionEvent arg0) {
    // TODO Auto-generated method stub
  }

  /**
   * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent).
   */
  @Override
  public void attributeAdded(HttpSessionBindingEvent arg0) {
    // TODO Auto-generated method stub
  }

  /**
   * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent).
   */
  @Override
  public void attributeRemoved(HttpSessionBindingEvent arg0) {
    // TODO Auto-generated method stub
  }

  /**
   * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent).
   */
  @Override
  public void attributeReplaced(HttpSessionBindingEvent arg0) {
    // TODO Auto-generated method stub
  }

}
