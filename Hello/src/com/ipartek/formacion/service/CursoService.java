package com.ipartek.formacion.service;

import com.ipartek.formacion.bean.Alumno;
import com.ipartek.formacion.bean.Curso;
import com.ipartek.formacion.bean.excepciones.CursoException;
import com.ipartek.formacion.service.exceptions.CursoServiceException;
import com.ipartek.formacion.service.interfaces.ICursoService;
import com.ipartek.formacion.util.TipoCurso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CursoService implements ICursoService {

  private List<Curso> cursos = null;
  private static int i;

  public CursoService() {
    init();
  }

  /**
   * Metodo que añade un <code>Alumno</code>.
   * 
   * @param alumno
   *          <code>Alumno</code> es <code>Alumno</code>a añadir.
   */
  public void addAlumno(final Alumno alumno) {
    Curso curso = cursos.get(0);
    Map<Integer, Alumno> listado = curso.getListadoAlumnos();
    listado.put(alumno.getCodigoUsuario(), alumno);

  }

  @Override
  public Curso getById(final int codigo) throws CursoServiceException {
    Curso curso = null;
    int posicion = Curso.CODIGO_CURSO;

    posicion = encontrarCurso(codigo);
    if (posicion > Curso.CODIGO_CURSO) {
      curso = cursos.get(posicion);
    } else {
      throw new CursoServiceException(CursoServiceException.MSG_CURSO_NO_ENCONTRADO,
          CursoServiceException.COD_CURSO_NO_ENCONTRADO);
    }

    return curso;
  }

  @Override
  public int update(final Curso curso) throws CursoServiceException {
    int posicion = -1;
    int codigo = Curso.CODIGO_CURSO;

    posicion = encontrarCurso(curso.getCodigo());

    if (posicion > Curso.CODIGO_CURSO) {
      cursos.add(posicion, curso);
      codigo = curso.getCodigo();
    } else {
      throw new CursoServiceException(CursoServiceException.MSG_CURSO_NO_ENCONTRADO,
          CursoServiceException.COD_CURSO_NO_ENCONTRADO);
    }
    return codigo;
  }

  private int encontrarCurso(final int codigoCurso) {
    int index = 0;
    int longitud = cursos.size();
    int posicion = -1;
    boolean encontrado = false;
    do {
      if (cursos.get(index).getCodigo() == codigoCurso) {
        encontrado = true;
        posicion = index;
      }
      index++;
    } while (index < longitud && encontrado == false);
    return posicion;
  }

  /**
   * Obtener el <code>Map</code> de alumnos matriculados en un <code>Curso</code>.
   * 
   * @param codigoCurso
   *          <code>int</code> el campo clave del <code>Curso</code> del que desamos informacion.
   * @return <code>Map</code> con los datos de los alumnos.
   */
  public Map<Integer, Alumno> readAlumnos(final int codigoCurso) {
    Curso curso = null;
    Map<Integer, Alumno> listado = null;
    try {
      curso = getById(codigoCurso);
      listado = curso.getListadoAlumnos();
    } catch (CursoServiceException e) {
      e.printStackTrace();
    }

    /*
     * for(Map.Entry<Integer, Alumno> entry: listado.entrySet()){ Integer codigo = entry.getKey();
     * Alumno alum = entry.getValue(); }
     * 
     * Iterator it = listado.keySet().iterator(); while(it.hasNext()){ Map.Entry<Integer, Alumno>
     * entry = (Map.Entry<Integer, Alumno>)it.next(); Integer codigo = entry.getKey(); Alumno alum =
     * entry.getValue(); }
     */
    return listado;
  }

  private final void init() {
    CursoService.i = 0;
    // creamos el objeto de listado de cursos
    cursos = new ArrayList<Curso>();
    // creamos un curso
    Curso curso = null;

    try {
      curso = new Curso();
      curso.setCodigo(CursoService.i);
      curso.setNombre("Java");
      curso.setTipoCurso(TipoCurso.PROGRACION);
      // creamos el listado de alumnos
      HashMap<Integer, Alumno> listadoAlumnos = null;
      // creamos un objeto de tipo servicio
      // que nos carga la lista completa de alumnos
      AlumnoService as = new AlumnoService();
      // obtenemos el listado completo de alumnos
      ArrayList<Alumno> alumnos = as.getAll();

      listadoAlumnos = new HashMap<Integer, Alumno>();
      for (Alumno al : alumnos) {
        listadoAlumnos.put(al.getCodigoUsuario(), al);
      }

      cursos.add(curso);
    } catch (CursoException e) {
      e.printStackTrace();
    }
    CursoService.i++;
  }

  /**
   * Incrementa el precio de los cursos en función de su tipo.
   */
  public void incrementarPrecio() {
    for (int i = 0; i < cursos.size(); i++) {
      Curso curso = cursos.get(i);
      switch (curso.getTipoCurso()) {
        case PROGRACION:
          try {
            curso.setPrecio(curso.getPrecio() + 50.0);
          } catch (CursoException e) {
            e.printStackTrace();
          }
          break;
        case DESIGN:
          try {
            curso.setPrecio(curso.getPrecio() + 70.0);
          } catch (CursoException e) {
            e.printStackTrace();
          }
          break;
        case OFIMATICA:
          try {
            curso.setPrecio(curso.getPrecio() + 150.0);
          } catch (CursoException e) {
            e.printStackTrace();
          }
          break;
        default:

          break;
      }
    }
  }

  @Override
  public List<Curso> getAll() {

    return cursos;
  }

  @Override
  public boolean delete(final int codigoCurso) {
    boolean exito = false;
    int posicion = encontrarCurso(codigoCurso);

    if (posicion != Curso.CODIGO_CURSO) {
      cursos.remove(posicion);
      exito = true;
    }
    return exito;
  }

  @Override
  public int create(final Curso curso) {
    int posicion = Curso.CODIGO_CURSO;
    try {
      curso.setCodigo(CursoService.i);
      cursos.add(curso);
      CursoService.i++;
    } catch (CursoException e) {
      e.printStackTrace();
    }
    return posicion;
  }
}
