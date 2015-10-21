package com.ipartek.formacion.model.dbms;

import com.ipartek.formacion.model.dbms.interfaces.ICandidatoDAO;
import com.ipartek.formacion.pojo.Candidato;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CandidatoDAO implements ICandidatoDAO {
  private SessionFactory factoria;
  private Session sesion;
  private Transaction transaccion;

  @Override
  public void create(Candidato candidato) {
    // int codigo;
    factoria = new Configuration().configure().buildSessionFactory();
    sesion = factoria.openSession();
    transaccion = sesion.beginTransaction();

    sesion.saveOrUpdate(candidato);
    transaccion.commit();
  }

  @Override
  public Candidato getById(int codigo) {
    Candidato candidato = null;
    factoria = new Configuration().configure().buildSessionFactory();
    sesion = factoria.openSession();

    candidato = sesion.get(Candidato.class, codigo);

    return candidato;
  }

  @Override
  public List<Candidato> getAll() {
    List<Candidato> candidatos = null;

    factoria = new Configuration().configure().buildSessionFactory();
    sesion = factoria.openSession();
    final String SQL = "from Candidato candidato";

    candidatos = sesion.createQuery(SQL).list();

    return candidatos;
  }

  @Override
  public int update(Candidato candidato) {
    factoria = new Configuration().configure().buildSessionFactory();
    sesion = factoria.openSession();
    transaccion = sesion.beginTransaction();
    sesion.saveOrUpdate(candidato);
    transaccion.commit();
    return candidato.getCodigo();
  }

  @Override
  public boolean delete(int codigo) {
    factoria = new Configuration().configure().buildSessionFactory();
    sesion = factoria.openSession();
    transaccion = sesion.beginTransaction();
    sesion.delete(getById(codigo));
    transaccion.commit();
    return false;
  }

  @Override
  public List<Candidato> getByNombre(String nombre) {
    List<Candidato> candidatos = null;
    factoria = new Configuration().configure().buildSessionFactory();
    sesion = factoria.openSession();
    final String SQL = "FROM Candidato candidato WHERE candidato.nombre =:nombre";

    Query consulta = sesion.createQuery(SQL);
    consulta.setString("nombre", nombre);
    candidatos = consulta.list();

    return candidatos;
  }

}
