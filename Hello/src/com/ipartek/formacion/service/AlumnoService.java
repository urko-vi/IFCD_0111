package com.ipartek.formacion.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;

import com.ipartek.formacion.bean.Alumno;
import com.ipartek.formacion.bean.excepciones.AlumnoException;
import com.ipartek.formacion.service.interfaces.IAlumnoService;

public class AlumnoService implements IAlumnoService {

  private ArrayList<Alumno> alumnos = null;
  private int i;

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

      if (al.getCodigoAlumno() == codigo) {
        alumno = al;
      }
    }

    return alumno;
  }

  @Override
  public boolean delete(final int id) {
    int i = 0, longitud = alumnos.size();
    boolean encontrado = false;
    // || --> OR
    // && --> AND

    while (i < longitud && encontrado == false) {
      if (alumnos.get(i).getCodigoAlumno() == id) {
        alumnos.remove(i);
        encontrado = true;
      }

      i++;
    }
    return encontrado;
  }

  @Override
  public int create(final Alumno alumno) {
    int posicion = Alumno.CODIGOALUMNO;

    if (alumnos.add(alumno)) {

      // se captura el código de la base de datos
      posicion = i;
      i++;
    }

    return posicion;
  }

  @Override
  public int update(final Alumno alumno) {

    for (Alumno al : alumnos) {
      // encontrar por id
      if (al.getCodigoAlumno() == alumno.getCodigoAlumno()) {
        // capturar la posicon
        int index = alumnos.indexOf(al);
        // lo vamos machacar
        // alumnos[i] = alumno;
        alumnos.add(index, alumno);
      }
    }
    return alumno.getCodigoAlumno();
  }

  private void init() {
    i = 0;
    alumnos = new ArrayList<Alumno>();
    Alumno alumno = null;

    SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
    // GregorianCalendar calendar = new
    // GregorianCalendar();

    try {
      alumno = new Alumno();
      alumno.setCodigoAlumno(i);
      alumno.setNombre("David");
      alumno.setApellidos("Aranzadi");
      alumno.setnhermanos(0);
      alumno.setfnacimiento(fmt.parse("12/09/1990"));
      // calendar.setTime(fmt.parse("12/09/1990"));

      alumnos.add(alumno);
      i++;
    } catch (AlumnoException e) {
      e.printStackTrace();
    } catch (ParseException e) {
      e.printStackTrace();
    }

    try {
      alumno = new Alumno();
      alumno.setCodigoAlumno(i);
      alumno.setNombre("Maria");
      alumno.setApellidos("Gonzalez");
      alumnos.add(alumno);
      i++;
    } catch (AlumnoException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }

    try {
      alumno = new Alumno();
      alumno.setCodigoAlumno(i);
      alumno.setNombre("Alexander");
      alumno.setApellidos("Revuelta");
      alumnos.add(alumno);
      i++;
    } catch (AlumnoException e) {
      e.printStackTrace();
    }
    Alumno al;
    try {
      al = new Alumno();
      if (alumno.equals(al)) {

      }
    } catch (AlumnoException e1) {
      e1.printStackTrace();
    }

    try {
      alumno = new Alumno();
      alumno.setCodigoAlumno(i);
      alumno.setNombre("Alain");
      alumno.setApellidos("Revuelta");
      alumnos.add(alumno);
      i++;
    } catch (AlumnoException e) {
      e.printStackTrace();
    }

    try {
      alumno = new Alumno();
      alumno.setCodigoAlumno(i);
      alumno.setNombre("Carlos");
      alumno.setApellidos("Mateo");
      alumnos.add(alumno);
      i++;
    } catch (AlumnoException e) {
      e.printStackTrace();
    }
    Collections.sort(alumnos);
  }
}
