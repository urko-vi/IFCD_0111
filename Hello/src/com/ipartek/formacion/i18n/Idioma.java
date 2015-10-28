package com.ipartek.formacion.i18n;

public enum Idioma {
  CASTELLANO("es_ES", "es", "ES", "Castellano"), INGLES("en_EN", "en", "EN", "Ingles"), EUSKERA(
      "eu_ES", "eu", "ES", "Euskera");

  private String locale;
  private String lenguaje;
  private String pais;
  private String texto;

  private Idioma(String locale, String lenguaje, String pais, String texto) {
    this.locale = locale;
    this.lenguaje = lenguaje;
    this.pais = pais;
    this.texto = texto;
  }

  public String getLocale() {
    return locale;
  }

  public void setLocale(String locale) {
    this.locale = locale;
  }

  public String getLenguaje() {
    return lenguaje;
  }

  public void setLenguaje(String lenguaje) {
    this.lenguaje = lenguaje;
  }

  public String getPais() {
    return pais;
  }

  public void setPais(String pais) {
    this.pais = pais;
  }

  public String getTexto() {
    return texto;
  }

  public void setTexto(String texto) {
    this.texto = texto;
  }

}
