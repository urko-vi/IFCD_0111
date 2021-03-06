package com.ipartek.formacion.controller;

import com.ipartek.formacion.controller.config.ControllerConfig;
import com.ipartek.formacion.controller.config.WebConfig;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontControllerServlet
 */
public class FrontControllerServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  private static final String MAPPING_FILE = "mapping";
  private ServletContext context = null;
  private WebConfig webConfig = null;

  /**
   * @see Servlet#init(ServletConfig)
   */
  @Override
  public void init(ServletConfig config) throws ServletException {
    super.init(config);
    context = config.getServletContext();
    String mappingFile = null;
    String controllersProps = config.getInitParameter(FrontControllerServlet.MAPPING_FILE);
    mappingFile = context.getRealPath(controllersProps);
    webConfig = new WebConfig(mappingFile);

  }

  /**
   * @see Servlet#destroy()
   */
  @Override
  public void destroy() {
    webConfig = null;
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doProcess(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doProcess(request, response);
  }

  private void doProcess(HttpServletRequest request, HttpServletResponse response) {

    final String servletPath = request.getServletPath();
    final String actionPath = servletPath.substring(1, servletPath.lastIndexOf("."));

    final Map<String, ControllerConfig> controllers = webConfig.getControllers();
    final ControllerConfig ctrConfig = controllers.get(actionPath);

    View view = null;
    if (ctrConfig != null) {
      String actionUrl = ctrConfig.getAction();
      // System.out.println(actionUrl);
      if (actionPath.equals(actionUrl)) {
        try {
          final IActionController controller = ctrConfig.invokeController();
          view = controller.execute(request, response);
          prepareModelData(request, view);
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
        dispatchRequestToView(view, webConfig, request, response);
      }
    } else {
      throw new UnsupportedOperationException(String.format(
          "action %s is not found in mapping file.", actionPath));
    }

  }

  private void dispatchRequestToView(View view, WebConfig webConfig2, HttpServletRequest request,
      HttpServletResponse response) {
    try {
      String forward = view.getFoward();
      final RequestDispatcher rd = context.getRequestDispatcher(forward);
      rd.forward(request, response);
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  private void prepareModelData(HttpServletRequest request, View view) {
    final Map<String, ?> model = view.getDatos();
    if (model != null) {
      for (Entry<String, ?> data : model.entrySet()) {
        request.setAttribute(data.getKey(), data.getValue());
      }
    }

  }
}
