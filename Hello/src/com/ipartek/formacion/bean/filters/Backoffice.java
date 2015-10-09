package com.ipartek.formacion.bean.filters;

import com.ipartek.formacion.util.Constantes;

import org.apache.log4j.Logger;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class Backoffice.
 */
public class Backoffice implements Filter {
  private static final Logger log = Logger.getLogger(Backoffice.class);

  /**
   * Default constructor.
   */
  public Backoffice() {
    // TODO Auto-generated constructor stub
  }

  /**
   * @see Filter#destroy().
   */
  @Override
  public void destroy() {
    // TODO Auto-generated method stub
  }

  /**
   * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
   */
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
    HttpServletResponse res = (HttpServletResponse) response;
    String urlPedida = req.getRequestURL().toString();
    if (urlPedida.contains(Constantes.RUTA_BACKUP)) {
      {
        // urlPedida.indexOf(".");
        HttpSession sesion = req.getSession();
        if (sesion == null || sesion.getAttribute(Constantes.ATT_USUARIO) == null) {
          String ipAddress = req.getHeader("X-FORWARDED-FOR");

          Backoffice.log.error("La IP se intando colar. " + ipAddress);
          res.sendRedirect(Constantes.JSP_PAGINA_LOGIN);
        } else {
          chain.doFilter(request, response);
        }
      }
    }
  }

  /**
   * @see Filter#init(FilterConfig).
   */
  @Override
  public void init(FilterConfig fConfig) throws ServletException {
    // TODO Auto-generated method stub
  }

}
