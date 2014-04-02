package com.lferre.geoapp.entitieslayer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class RhombusTest {

    //<editor-fold defaultstate="collapsed" desc="Inicializaci�n del juego de pruebas">
    
    public RhombusTest() {
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Ciclo de vida del juego de pruebas">
    
    @BeforeClass
    public static void init() {
        System.out.printf("\n\nINIT: Se carga el juego de pruebas %s en el Test-Runner\n", RhombusTest.class.getSimpleName());
    }
    
    @Before
    public void setUp() {
        System.out.println("SETUP: Inicio de ejecuci�n de una prueba unitaria");
    }
    
    @After
    public void tearDown() {
        System.out.println("TEARDOWN: Fin de ejecuci�n de una prueba unitaria");
    }
    
    @AfterClass
    public static void finish() {
        System.out.printf("FINISH: Se procede a descargar el juego de pruebas %s del Test-Runner\n", RhombusTest.class.getSimpleName());
    }

    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Unit Tests o pruebas del juego de pruebas">
    @Test
    public void testNumConstructors() {
        Class classDef = Rhombus.class;
        Assert.assertEquals("N�mero de constructores no v�lido", 2, classDef.getConstructors().length);
    }
    
    @Test
    public void testConstructorWithNoParameters() {
        Rhombus r = new Rhombus();
        Assert.assertEquals("Eje X del rombo no inicializado correctamente al valor por defecto", 1.0D, r.getXAxis(), 0D);
        Assert.assertEquals("Eje Y del rombo no inicializado correctamente al valor por defecto", 1.0D, r.getYAxis(), 0D);
    }
    
    @Test
    public void testMainConstructor() {
        Rhombus r = new Rhombus(3.8D, 13.9D);
        Assert.assertEquals("Eje X del rombo no inicializado correctamente al valor indicado", 3.8D, r.getXAxis(), 0D);
        Assert.assertEquals("Eje Y del rombo no inicializado correctamente al valor indicado", 13.9D, r.getYAxis(), 0D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testMainConstructorWithErrors01() {
        Rhombus r = new Rhombus(0D, 0D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testMainConstructorWithErrors02() {
        Rhombus r = new Rhombus(0D, 5.3D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testMainConstructorWithErrors03() {
        Rhombus r = new Rhombus(12.3D, 0D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testMainConstructorWithErrors04() {
        Rhombus r = new Rhombus(5.8D, -10.5D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testMainConstructorWithErrors05() {
        Rhombus r = new Rhombus(-14.39D, 3.8D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testMainConstructorWithErrors06() {
        Rhombus r = new Rhombus(-14.39D, -3.8D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetXAxisWithError01() {
        Rhombus r = new Rhombus();
        r.setXAxis(0.0D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetXAxisWithError02() {
        Rhombus r = new Rhombus();
        r.setXAxis(-10.0D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetYAxisWithError01() {
        Rhombus r = new Rhombus();
        r.setYAxis(0.0D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetYAxisWithError02() {
        Rhombus r = new Rhombus();
        r.setYAxis(-10.0D);
    }
    
    @Test
    public void testGetArea01() {
        Rhombus r1 = new Rhombus();
        Assert.assertEquals("El �rea del rombo no coincide con el valor esperado", 0.5, r1.getArea(), 0);
    }
    
    @Test
    public void testGetArea02() {
        Rhombus r1 = new Rhombus(4, 8);
        Assert.assertEquals("El �rea del rombo no coincide con el valor esperado", 16.0, r1.getArea(), 0);
    }
    
    @Test
    public void testGetArea03() {
        Rhombus r1 = new Rhombus(1, 10);
        Assert.assertEquals("El �rea del rombo no coincide con el valor esperado", 5.0, r1.getArea(), 0);
    }
    
    @Test
    public void testGetPerimeter01() {
        Rhombus r1 = new Rhombus();
        Assert.assertEquals("El per�metro del rombo no coincide con el valor esperado", 2.828, r1.getPerimeter(), 0.01);
    }
    
    @Test
    public void testGetPerimeter02() {
        Rhombus r1 = new Rhombus(4, 8);
        Assert.assertEquals("El per�metro del rombo no coincide con el valor esperado", 17.885, r1.getPerimeter(), 0.01);
    }
    
    @Test
    public void testGetPerimeter03() {
        Rhombus r1 = new Rhombus(1, 10);
        Assert.assertEquals("El per�metro del rombo no coincide con el valor esperado", 20.0995, r1.getPerimeter(), 0.01);
    }
    
    @Test
    public void testGetSide01() {
        Rhombus r1 = new Rhombus();
        Assert.assertEquals("El lado del rombo no coincide con el valor esperado", 0.707, r1.getSide(), 0.01);
    }
    
    @Test
    public void testGetSide02() {
        Rhombus r1 = new Rhombus(4, 8);
        Assert.assertEquals("El lado del rombo no coincide con el valor esperado", 4.472, r1.getSide(), 0.01);
    }
    
    @Test
    public void testGetSide03() {
        Rhombus r1 = new Rhombus(1, 10);
        Assert.assertEquals("El lado del rombo no coincide con el valor esperado", 5.024, r1.getSide(), 0.01);
    }
    
    
    @Test
    public void testEquals01()
    {
        Rhombus r1 = new Rhombus();
        Rhombus r2 = new Rhombus();
        Assert.assertTrue("Los dos rombos deber�an ser iguales", r1.equals(r2));
    }
    
    @Test
    public void testEquals02()
    {
        Rhombus r1 = new Rhombus(5.0D, 3.5D);
        Rhombus r2 = new Rhombus(5.0D, 3.5D);
        Assert.assertTrue("Los dos rombos deber�an ser iguales", r1.equals(r2));
    }
    
    @Test
    public void testEquals03()
    {
        Rhombus r1 = new Rhombus(1.0D, 1.0D);
        Rhombus r2 = new Rhombus();
        Assert.assertTrue("Los dos rombos deber�an ser iguales", r1.equals(r2));
    }
    
    @Test
    public void testNoEquals01()
    {
        Rhombus r1 = new Rhombus(5.0D, 3.0D);
        Rhombus r2 = new Rhombus(4.0D, 3.5D);
        Assert.assertFalse("Los dos rombos no deber�an ser iguales", r1.equals(r2));
    }
    
    @Test
    public void testNoEquals02()
    {
        Rhombus r1 = new Rhombus(5.0D, 3.5D);
        Assert.assertFalse("Los dos rombos no deber�an ser iguales", r1.equals(null));
        Assert.assertFalse("Los dos rombos no deber�an ser iguales", r1.equals("hola"));
        Assert.assertFalse("Los dos rombos no deber�an ser iguales", r1.equals(5.0D));
    }
    
    @Test
    public void testHashCode01()
    {
        Rhombus r1 = new Rhombus();
        Rhombus r2 = new Rhombus();
        Assert.assertEquals("Los dos rombos deber�an tener el mismo c�digo de hash", r1.hashCode(), r2.hashCode());
    }
    
    @Test
    public void testHashCode02()
    {
        Rhombus r1 = new Rhombus(5.0D, 3.5D);
        Rhombus r2 = new Rhombus(5.0D, 3.5D);
        Assert.assertEquals("Los dos rombos deber�an tener el mismo c�digo de hash", r1.hashCode(), r2.hashCode());
    }
    
    @Test
    public void testHashCode03()
    {
        Rhombus r1 = new Rhombus(1.0D, 1.0D);
        Rhombus r2 = new Rhombus();
        Assert.assertEquals("Los dos rombos deber�an tener el mismo c�digo de hash", r1.hashCode(), r2.hashCode());
    }
    
    @Test
    public void testHashCode04()
    {
        Rhombus r1 = new Rhombus(5.0D, 3.0D);
        Rhombus r2 = new Rhombus(4.0D, 3.5D);
        Assert.assertNotSame("Los dos rombos no deber�an tener el mismo c�digo de hash", r1.hashCode(), r2.hashCode());
    }
    //</editor-fold>
    
}