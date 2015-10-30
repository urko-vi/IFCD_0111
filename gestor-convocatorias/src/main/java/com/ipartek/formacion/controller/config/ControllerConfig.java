package com.ipartek.formacion.controller.config;

import com.ipartek.formacion.controller.IActionController;

public class ControllerConfig {
  private String action;
  private String actionClass;

  public ControllerConfig(String action, String actionClass) {
    super();
    setAction(action);
    setActionClass(actionClass);
  }

  public IActionController invokeController() {
    IActionController accion = null;
    if (actionClass != null && !actionClass.isEmpty()) {
      try {
        // System.out.println(actionClass);
        accion = (IActionController) Class.forName(actionClass).newInstance();

      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return accion;
  }

  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }

  public String getActionClass() {
    return actionClass;
  }

  public void setActionClass(String actionClass) {
    this.actionClass = actionClass;
  }
}
