package com.ipartek.formacion.service;

import com.ipartek.formacion.bean.Alumno;
import com.ipartek.formacion.bean.excepciones.AlumnoException;
import com.ipartek.formacion.service.interfaces.IAlumnoService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;

public class AlumnoService implements IAlumnoService {

  private ArrayList<Alumno> alumnos = null;
  private int nalumno;

  public AlumnoService() {
    init();
  }

  @Override
  public ArrayList<Alumno> getAll() {
    return alumnos;
  }

  @Override
  public Alumno getById(final int codigo) {
    // alumno que vamos a devolver
    Alumno alumno = null;
    // Alumno[] alum = null;

    for (int i = 0; i < alumnos.size(); i++) {
      // alumno con codigo a comparar
      Alumno al = alumnos.get(i);

      if (al.getCodigoUsuario() == codigo) {
        alumno = al;
      }
    }

    return alumno;
  }

  @Override
  public boolean delete(final int id) {
    int index = 0;
    int longitud = alumnos.size();
    boolean encontrado = false;
    // || --> OR
    // && --> AND

    while (index < longitud && encontrado == false) {
      if (alumnos.get(index).getCodigoUsuario() == id) {
        alumnos.remove(index);
        encontrado = true;
      }

      index++;
    }
    return encontrado;
  }

  @Override
  public int create(final Alumno alumno) {
    int posicion = Alumno.CODIGOALUMNO;

    if (alumnos.add(alumno)) {

      // se captura el código de la base de datos
      posicion = nalumno;
      nalumno++;
    }

    return posicion;
  }

  @Override
  public int update(final Alumno alumno) {

    for (Alumno al : alumnos) {
      // encontrar por id
      if (al.getCodigoUsuario() == alumno.getCodigoUsuario()) {
        // capturar la posicon
        int index = alumnos.indexOf(al);
        // lo vamos machacar
        // alumnos[i] = alumno;
        alumnos.add(index, alumno);
      }
    }
    return alumno.getCodigoUsuario();
  }

  private void init() {
    nalumno = 0;
    alumnos = new ArrayList<Alumno>();
    Alumno alumno = null;

    SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
    // GregorianCalendar calendar = new
    // GregorianCalendar();

    try {
      alumno = new Alumno();
      alumno.setCodigoUsuario(nalumno);
      alumno.setNombre("David");
      alumno.setApellidos("Aranzadi");
      alumno.setnhermanos(0);
      alumno.setfnacimiento(fmt.parse("12/09/1990"));
      // calendar.setTime(fmt.parse("12/09/1990"));

      alumnos.add(alumno);
      nalumno++;
    } catch (AlumnoException e) {
      e.printStackTrace();
    } catch (ParseException e) {
      e.printStackTrace();
    }

    try {
      alumno = new Alumno();
      alumno.setCodigoUsuario(nalumno);
      alumno.setNombre("Maria");
      alumno.setApellidos("Gonzalez");
      alumnos.add(alumno);
      nalumno++;
    } catch (AlumnoException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }

    try {
      alumno = new Alumno();
      alumno.setCodigoUsuario(nalumno);
      alumno.setNombre("Alexander");
      alumno.setApellidos("Revuelta");
      alumnos.add(alumno);
      nalumno++;
    } catch (AlumnoException e) {
      e.printStackTrace();
    }

    try {
      alumno = new Alumno();
      alumno.setCodigoUsuario(nalumno);
      alumno.setNombre("Alain");
      alumno.setApellidos("Revuelta");
      alumnos.add(alumno);
      nalumno++;
    } catch (AlumnoException e) {
      e.printStackTrace();
    }

    try {
      alumno = new Alumno();
      alumno.setCodigoUsuario(nalumno);
      alumno.setNombre("Carlos");
      alumno.setApellidos("Mateo");
      alumnos.add(alumno);
      nalumno++;
    } catch (AlumnoException e) {
      e.printStackTrace();
    }
    Collections.sort(alumnos);
  }
}
