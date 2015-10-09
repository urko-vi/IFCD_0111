package com.ipartek.formacion.listeners;

import com.ipartek.formacion.bean.Usuario;
import com.ipartek.formacion.util.Constantes;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpSession;
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
    HttpSession sesion = arg0.getSession();
    // fijamos el tiempo maximo de session
    // hay que pasarselo en segundos
    // si se pone un 0 no caduca la session
    sesion.setMaxInactiveInterval(60 * 30);
    SessionListener.LOG.trace("La sesion: " + sesion.getId() + " " + " segundos");
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
    HttpSession sesion = arg0.getSession();
    Usuario user = (Usuario) sesion.getAttribute(Constantes.ATT_USUARIO);
    SessionListener.LOG.trace("Usuario " + user.getUserName() + " segundos");
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
