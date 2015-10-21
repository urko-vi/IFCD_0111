package com.ipartek.formacion.pojo;

import java.util.ArrayList;
import java.util.List;

public class Curso {
  /**
   * 
   */
  public int CODIGO_CURSO_NULO = -1;
  private int codigo;
  private String nombre;
  private String descripcion;
  private Lugar lugar;
  private TipoCurso tipoCurso;
  private List<Convocatoria> convocatorias;

  public List<Convocatoria> getConvocatorias() {
    return convocatorias;
  }

  public void setConvocatorias(List<Convocatoria> convocatorias) {
    this.convocatorias = convocatorias;
  }

  public TipoCurso getTipoCurso() {
    return tipoCurso;
  }

  public void setTipoCurso(TipoCurso tipoCurso) {
    this.tipoCurso = tipoCurso;
  }

  public Curso() {
    // setCodigo();
    setNombre("");
    setDescripcion("");
    setLugar(new Lugar());
    setTipoCurso(new TipoCurso());
    setConvocatorias(new ArrayList<Convocatoria>());

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

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public Lugar getLugar() {
    return lugar;
  }

  public void setLugar(Lugar lugar) {
    this.lugar = lugar;
  }

}
