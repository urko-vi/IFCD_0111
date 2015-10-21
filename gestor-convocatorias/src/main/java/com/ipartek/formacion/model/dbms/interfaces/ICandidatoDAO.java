package com.ipartek.formacion.model.dbms.interfaces;

import com.ipartek.formacion.pojo.Candidato;

import java.util.List;

public interface ICandidatoDAO {
  // CREATE
  public void create(Candidato candidato);

  // READ ---> GetByID GetAll
  public Candidato getById(int codigo);

  public List<Candidato> getAll();

  // UPDATE
  public int update(Candidato candidato);

  // DELETE
  public boolean delete(int codigo);

  public List<Candidato> getByNombre(String nombre);

}
