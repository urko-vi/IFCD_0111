package com.ipartek.formacion.bean;

public class Profesor extends Usuario {
  private String nss;

  public Profesor() {
    super();
  }

  public String getNss() {
    return nss;
  }

  public void setNss(final String nss) {
    this.nss = nss;
  }

}
