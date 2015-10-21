package com.ipartek.formacion.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Candidato {
  public static final int CODIGO_CANDIDATO = -1;

  private int codigo;
  private String nombre;
  private String apellido1;
  private String apellido2;
  private List<Convocatoria> convocatoria;

  public Candidato() {
    super();
    setCodigo(Candidato.CODIGO_CANDIDATO);
    setNombre("");
    setApellido1("");
    setApellido2("");
    setConvocatoria(new ArrayList<Convocatoria>());
  }

  public List<Convocatoria> getConvocatoria() {
    return convocatoria;
  }

  public void setConvocatoria(List<Convocatoria> convocatoria) {
    this.convocatoria = convocatoria;
  }

  public void setConvocatoria(Set<Convocatoria> convocatorias) {
    // HashSet<Convocatoria> co = (HashSet<Convocatoria>) convocatorias;
    convocatoria = new ArrayList<Convocatoria>(convocatorias);
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido1() {
    return apellido1;
  }

  public void setApellido1(String apellido1) {
    this.apellido1 = apellido1;
  }

  public String getApellido2() {
    return apellido2;
  }

  public void setApellido2(String apellido2) {
    this.apellido2 = apellido2;
  }

}
