package com.ipartek.formacion.service;

import com.ipartek.formacion.bean.Convocatoria;
import com.ipartek.formacion.bean.excepciones.ConvocatoriaException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ConvocatoriaServiceTest {

  private ConvocatoriaService cs = null;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {

  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {
  }

  @Before
  public void setUp() throws Exception {
    cs = new ConvocatoriaService();
  }

  @After
  public void tearDown() throws Exception {
    cs = null;
  }

  @Test
  public void testGetAll() {

  }

  @Test
  public void testCreate() {

  }

  @Test
  public void testGetById() throws ConvocatoriaException {

    int codigo = 1;
    Convocatoria actual = new Convocatoria();

    actual = cs.getById(codigo);
    Convocatoria expected = new Convocatoria();
    expected.setCodigo(codigo);
    expected.setNombre("Primera Convovatoria");

    Assert.assertEquals("La convocatoria de codigo:" + codigo + "no coincide.",
        expected.getCodigo(), actual.getCodigo());

    // Assert.assertEquals("El codigo no es el que se ha demandado" + codigo, codigo,
    // actual.getCodigo());
    codigo = -1;
    actual = cs.getById(codigo);
    Assert.assertNull("El codigo pedido", actual);
  }

  @Test
  public void testUpdate() {
    // int codigo = 0;
    // Convocatoria expected = cs.getById(codigo);
    // expected.setNombre("segunda convocatoria");

    // cs.update(expected);
    // Convocatoria actual = cs.getById(codigo);
    // Assert.assertEquals("La convocatoria de codigo:" + codigo + "no coincide.", expected,
    // actual);

    // expected = cs.getById(codigo);
    // expected.setNombre("segunda convocatoria");
    // expected.setCodigo(-1);
    // cs.update(expected);
    // actual = cs.getById(codigo);
    // Assert.assertNotEquals("No deberian ser iguales", expected, actual);
    /*
     * expected = cs.getById(codigo); expected.setNombre("segunda convocatoria");
     * expected.setCodigo(2); cs.update(expected); actual = cs.getById(codigo);
     * Assert.assertNotEquals("No deberian ser iguales", expected, actual);
     */
  }

  @Test
  public void testDelete() {
    int codigo = 1;
    Assert.assertTrue(cs.delete(codigo));
    Assert.assertNull(cs.getById(codigo));
    codigo = 2;
    Assert.assertFalse("", cs.delete(codigo));
  }

}
