package com.ipartek.formacion.service;

import com.ipartek.formacion.pojo.Convocatoria;
import com.ipartek.formacion.pojo.excepciones.ConvocatoriaException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ConvocatoriaServiceTest {
  private static ConvocatoriaService sc = null;
  static List<Convocatoria> convocatorias = null;
  private static final String DRIVER = "com.mysql.jdbc.Driver";
  private static final String IP = "locahost/formacion";
  private static final String URL = "jdbc:mysql://" + ConvocatoriaServiceTest.IP;
  private static final String USER = "alumno";
  private static final String PASSWORD = "alumno";
  private static Connection conexion = null;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    // https://blogs.oracle.com/randystuph/entry/injecting_jndi_datasources_for_junit
    ConvocatoriaServiceTest.sc = new ConvocatoriaService();
    ConvocatoriaServiceTest.convocatorias = new ArrayList<Convocatoria>();
    Convocatoria conv = new Convocatoria();

    conv.setCodigo(1);
    conv.setNombre("primera convocatoria");
    conv.setDescripcion("Es la primera convocatoria");

    ConvocatoriaServiceTest.convocatorias.add(conv);

    conv = new Convocatoria();
    conv.setCodigo(2);
    conv.setNombre("segunda convocatoria");
    conv.setDescripcion("Es la segunda convocatoria");

    ConvocatoriaServiceTest.convocatorias.add(conv);
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {
    ConvocatoriaServiceTest.sc = null;
    ConvocatoriaServiceTest.convocatorias = null;
    if (ConvocatoriaServiceTest.conexion != null) {
      ConvocatoriaServiceTest.conexion.close();
    }
  }

  @Before
  public void setUp() throws Exception {
    ConvocatoriaServiceTest.sc = new ConvocatoriaService();
  }

  @After
  public void tearDown() throws Exception {
    ConvocatoriaServiceTest.sc = null;
  }

  /**
   * @throws ConvocatoriaException
   * 
   */

  @Test
  public void testGetById() throws ConvocatoriaException {

    Convocatoria actual = ConvocatoriaServiceTest.sc.getById(1);
    Convocatoria expected = null;
    expected = new Convocatoria();

    expected.setCodigo(1);
    expected.setNombre("primera convocatoria");
    expected.setDescripcion("Es la primera convocatoria");
    // comprobar que los dos datos que se devuelven estan bien
    Assert.assertEquals(
        "Validar que el elemento convocatoria sea de nombre:" + expected.getNombre()
        + actual.getNombre(), expected.getCodigo(), actual.getCodigo());
    // comprobar que los objetos son distintos
    actual = ConvocatoriaServiceTest.sc.getById(2);
    Assert.assertNotEquals("Non ", expected.getCodigo(), actual.getCodigo());
  }

}
