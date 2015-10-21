package com.ipartek.formacion.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_curso")
public class TipoCurso {
  public static final int CURSO_NULO = -1;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int codigo;
  @Column(name = "nombre")
  private String nombre;

  public TipoCurso() {
    super();
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

}
