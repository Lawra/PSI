package com.lferre.geoapp.entitieslayer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TrapeziumTest {

    //<editor-fold defaultstate="collapsed" desc="Inicializaci�n del juego de pruebas">
    
    public TrapeziumTest() {
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Ciclo de vida del juego de pruebas">
    
    @BeforeClass
    public static void init() {
        System.out.printf("\n\nINIT: Se carga el juego de pruebas %s en el Test-Runner\n", TrapeziumTest.class.getSimpleName());
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
        System.out.printf("FINISH: Se procede a descargar el juego de pruebas %s del Test-Runner\n", TrapeziumTest.class.getSimpleName());
    }

    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Unit Tests o pruebas del juego de pruebas">
    @Test
    public void testNumConstructors() {
        Class classDef = Trapezium.class;
        Assert.assertEquals("N�mero de constructores no v�lido", 2, classDef.getConstructors().length);
    }
    
    @Test
    public void testConstructorWithNoParameters() {
        Trapezium t = new Trapezium();
        Assert.assertEquals("Base menor del trapecio no inicializada correctamente al valor por defecto", 1.0D, t.getMinorBase(), 0D);
        Assert.assertEquals("Base mayor del trapecio no inicializada correctamente al valor por defecto", 2.0D, t.getMajorBase(), 0D);
        Assert.assertEquals("Altura del trapecio no inicializado correctamente al valor por defecto", 1.0D, t.getHeight(), 0D);
    }
    
    @Test
    public void testMainConstructor() {
        Trapezium t = new Trapezium(4.0D, 10.0D, 5.0D);
        Assert.assertEquals("Base menor del trapecio no inicializada correctamente al valor indicado", 4.0D, t.getMinorBase(), 0D);
        Assert.assertEquals("Base mayor del trapecio no inicializada correctamente al valor indicado", 10.0D, t.getMajorBase(), 0D);
        Assert.assertEquals("Altura del trapecio no inicializada correctamente al valor indicado", 5.0D, t.getHeight(), 0D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testMainConstructorWithErrors01() {
        Trapezium t = new Trapezium(0D, 0D, 0D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testMainConstructorWithErrors02() {
        Trapezium t = new Trapezium(10D, 0D, 15.5D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testMainConstructorWithErrors03() {
        Trapezium t = new Trapezium(10D, 10D, 0D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testMainConstructorWithErrors04() {
        Trapezium t = new Trapezium(0D, 10.5D, 25.5D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testMainConstructorWithErrors05() {
        Trapezium t = new Trapezium(-13.28D, -5.0D, -3.8D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testMainConstructorWithErrors06() {
        Trapezium t = new Trapezium(-13.28D, 5.0D, 3.8D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testMainConstructorWithErrors07() {
        Trapezium t = new Trapezium(13.28D, -5.0D, 3.8D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testMainConstructorWithErrors08() {
        Trapezium t = new Trapezium(13.28D, 5.0D, -3.8D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testMainConstructorWithErrors09() {
        Trapezium t = new Trapezium(4.0D, 4.0D, 3.8D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testMainConstructorWithErrors10() {
        Trapezium t = new Trapezium(6.0D, 4.0D, 3.8D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetMinorBaseWithError01() {
        Trapezium t = new Trapezium();
        t.setMinorBase(0.0D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetMinorBaseWithError02() {
        Trapezium t = new Trapezium();
        t.setMinorBase(-10.0D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetMinorBaseWithError03() {
        Trapezium t = new Trapezium(4.0D, 6.0D, 10.0D);
        t.setMinorBase(7.0D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetMajorBaseWithError01() {
        Trapezium t = new Trapezium();
        t.setMajorBase(0.0D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetMajorBaseWithError02() {
        Trapezium t = new Trapezium();
        t.setMajorBase(-10.0D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetMajorBaseWithError03() {
        Trapezium t = new Trapezium(4.0D, 6.0D, 5.0D);
        t.setMajorBase(3.0D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetHeightWithError01() {
        Trapezium t = new Trapezium();
        t.setHeight(0.0D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetHeightWithError02() {
        Trapezium t = new Trapezium();
        t.setHeight(-10.0D);
    }
    
    @Test
    public void testGetArea01() {
        Trapezium t1 = new Trapezium();
        Assert.assertEquals("El �rea del trapecio no coincide con el valor esperado", 1.5, t1.getArea(), 0);
    }
    
    @Test
    public void testGetArea02() {
        Trapezium t1 = new Trapezium(4, 8, 5);
        Assert.assertEquals("El �rea del trapecio no coincide con el valor esperado", 30.0, t1.getArea(), 0);
    }
    
    @Test
    public void testGetArea03() {
        Trapezium t1 = new Trapezium(1, 10, 3);
        Assert.assertEquals("El �rea del trapecio no coincide con el valor esperado", 16.5, t1.getArea(), 0);
    }
    
    @Test
    public void testGetPerimeter01() {
        Trapezium t1 = new Trapezium();
        Assert.assertEquals("El per�metro del trapecio no coincide con el valor esperado", 5.236, t1.getPerimeter(), 0.01);
    }
    
    @Test
    public void testGetPerimeter02() {
        Trapezium t1 = new Trapezium(4, 8, 5);
        Assert.assertEquals("El per�metro del trapecio no coincide con el valor esperado", 22.770, t1.getPerimeter(), 0.01);
    }
    
    @Test
    public void testGetPerimeter03() {
        Trapezium t1 = new Trapezium(1, 10, 3);
        Assert.assertEquals("El per�metro del trapecio no coincide con el valor esperado", 21.816, t1.getPerimeter(), 0.01);
    }
    
    @Test
    public void testGetSide01() {
        Trapezium t1 = new Trapezium();
        Assert.assertEquals("El lado del trapecio no coincide con el valor esperado", 1.118, t1.getSide(), 0.01);
    }
    
    @Test
    public void testGetSide02() {
        Trapezium t1 = new Trapezium(4, 8, 5);
        Assert.assertEquals("El lado del trapecio no coincide con el valor esperado", 5.385, t1.getSide(), 0.01);
    }
    
    @Test
    public void testGetSide03() {
        Trapezium t1 = new Trapezium(1, 10, 3);
        Assert.assertEquals("El lado del trapecio no coincide con el valor esperado", 5.408, t1.getSide(), 0.01);
    }
    
    @Test
    public void testEquals01()
    {
        Trapezium t1 = new Trapezium();
        Trapezium t2 = new Trapezium();
        Assert.assertTrue("Los dos trapecios deber�an ser iguales", t1.equals(t2));
    }
    
    @Test
    public void testEquals02()
    {
        Trapezium t1 = new Trapezium(5.0D, 8.5D, 4.0D);
        Trapezium t2 = new Trapezium(5.0D, 8.5D, 4.0D);
        Assert.assertTrue("Los dos trapecios deber�an ser iguales", t1.equals(t2));
    }
    
    @Test
    public void testEquals03()
    {
        Trapezium t1 = new Trapezium(1.0D, 2.0D, 1.0D);
        Trapezium t2 = new Trapezium();
        Assert.assertTrue("Los dos trapecios deber�an ser iguales", t1.equals(t2));
    }
    
    @Test
    public void testNoEquals01()
    {
        Trapezium t1 = new Trapezium(5.0D, 8.0D, 5.0D);
        Trapezium t2 = new Trapezium(4.0D, 11.5D, 5.0D);
        Assert.assertFalse("Los dos trapecios no deber�an ser iguales", t1.equals(t2));
    }
    
    @Test
    public void testNoEquals02()
    {
        Trapezium t1 = new Trapezium(6.0D, 10.0D, 4.0D);
        Assert.assertFalse("Los dos trapecios no deber�an ser iguales", t1.equals(null));
        Assert.assertFalse("Los dos trapecios no deber�an ser iguales", t1.equals("hola"));
        Assert.assertFalse("Los dos trapecios no deber�an ser iguales", t1.equals(5.0D));
    }
    
    @Test
    public void testHashCode01()
    {
        Trapezium t1 = new Trapezium();
        Trapezium t2 = new Trapezium();
        Assert.assertEquals("Los dos trapecios deber�an tener el mismo c�digo de hash", t1.hashCode(), t2.hashCode());
    }
    
    @Test
    public void testHashCode02()
    {
        Trapezium t1 = new Trapezium(5.0D, 8.5D, 4.0D);
        Trapezium t2 = new Trapezium(5.0D, 8.5D, 4.0D);
        Assert.assertEquals("Los dos trapecios deber�an tener el mismo c�digo de hash", t1.hashCode(), t2.hashCode());
    }
    
    @Test
    public void testHashCode03()
    {
        Trapezium t1 = new Trapezium(1.0D, 2.0D, 1.0D);
        Trapezium t2 = new Trapezium();
        Assert.assertEquals("Los dos trapecios deber�an tener el mismo c�digo de hash", t1.hashCode(), t2.hashCode());
    }
    
    @Test
    public void testHashCode04()
    {
        Trapezium t1 = new Trapezium(5.0D, 8.0D, 5.0D);
        Trapezium t2 = new Trapezium(4.0D, 11.5D, 5.0D);
        Assert.assertNotSame("Los dos trapecios no deber�an tener el mismo c�digo de hash", t1.hashCode(), t2.hashCode());
    }
    //</editor-fold>

    
}