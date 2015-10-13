package com.ipartek.formacion.bean.filters;

import com.ipartek.formacion.util.Constantes;

import org.apache.log4j.Logger;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class JspFilter
 */
public class JspFilter implements Filter {

  private static final Logger logger = Logger.getLogger(JspFilter.class);

  /**
   * Default constructor.
   */
  public JspFilter() {
    // TODO Auto-generated constructor stub
  }

  /**
   * @see Filter#destroy()
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

    // place your code here
    // compobamos que sea instancia de HttpServletRequest
    if (request instanceof HttpServletRequest) {
      HttpServletRequest req = (HttpServletRequest) request;
      RequestDispatcher dispatch = req.getRequestDispatcher(Constantes.JSP_PAGINA_LOGIN);
      // HttpServletRes req = (HttpServletRequest) request;
      if (!Constantes.JSP_PAGINA_LOGIN.equalsIgnoreCase(req.getRequestURI())
          || !"/Hello/".equalsIgnoreCase(req.getRequestURI())) {
        //
        HttpSession sesion = req.getSession();
        if (sesion == null || sesion.getAttribute(Constantes.ATT_USUARIO) == null) {
          String ipAddress = req.getHeader("X-FORWARDED-FOR");

          JspFilter.logger.error(req.getRequestURI() + "La IP se intando colar. " + ipAddress
              + " Remote adress" + req.getRemoteAddr());
          dispatch.forward(req, response);
        } else {
          chain.doFilter(request, response);
        }

      } else {
        chain.doFilter(request, response);
      }
    }

    //

    // pass the request along the filter chain
    chain.doFilter(request, response);
  }

  /**
   * @see Filter#init(FilterConfig).
   */
  @Override
  public void init(FilterConfig fConfig) throws ServletException {

  }

}
