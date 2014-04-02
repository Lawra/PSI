package com.lferre.geoapp.entitieslayer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RectangleTest {

    //<editor-fold defaultstate="collapsed" desc="Inicializaci�n del juego de pruebas">
    
    public RectangleTest() {
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Ciclo de vida del juego de pruebas">
    
    @BeforeClass
    public static void init() {
        System.out.printf("\n\nINIT: Se carga el juego de pruebas %s en el Test-Runner\n", RectangleTest.class.getSimpleName());
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
        System.out.printf("FINISH: Se procede a descargar el juego de pruebas %s del Test-Runner\n", RectangleTest.class.getSimpleName());
    }

    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Unit Tests o pruebas del juego de pruebas">
    @Test
    public void testNumConstructors() {
        Class classDef = Rectangle.class;
        Assert.assertEquals("N�mero de constructores no v�lido", 2, classDef.getConstructors().length);
    }
    
    @Test
    public void testConstructorWithNoParameters() {
        Rectangle r = new Rectangle();
        Assert.assertEquals("Base del rect�ngulo no inicializada correctamente al valor por defecto", 1.0D, r.getBase(), 0D);
        Assert.assertEquals("Altura del rect�ngulo no inicializada correctamente al valor por defecto", 1.0D, r.getHeight(), 0D);
    }
    
    @Test
    public void testMainConstructor() {
        Rectangle r = new Rectangle(3.5D, 10.38D);
        Assert.assertEquals("Base del rect�ngulo no inicializada correctamente al valor indicado", 3.5D, r.getBase(), 0D);
        Assert.assertEquals("Altura del rect�ngulo no inicializada correctamente al valor indicado", 10.38D, r.getHeight(), 0D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testMainConstructorWithErrors01() {
        Rectangle r = new Rectangle(0D, 0D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testMainConstructorWithErrors02() {
        Rectangle r = new Rectangle(10.4D, 0D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testMainConstructorWithErrors03() {
        Rectangle r = new Rectangle(0D, 5.30D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testMainConstructorWithErrors04() {
        Rectangle r = new Rectangle(5.8D, -10.5D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testMainConstructorWithErrors05() {
        Rectangle r = new Rectangle(-14.39D, 3.8D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testMainConstructorWithErrors06() {
        Rectangle r = new Rectangle(-14.39D, -3.8D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetBaseWithError01() {
        Rectangle r = new Rectangle();
        r.setBase(0.0D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetBaseWithError02() {
        Rectangle r = new Rectangle();
        r.setBase(-10.0D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetHeightWithError01() {
        Rectangle r = new Rectangle();
        r.setHeight(0.0D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetHeightWithError02() {
        Rectangle r = new Rectangle();
        r.setHeight(-10.0D);
    }
    
    @Test
    public void testGetArea01() {
        Rectangle r1 = new Rectangle();
        Assert.assertEquals("El �rea del rect�ngulo no coincide con el valor esperado", 1.0, r1.getArea(), 0);
    }
    
    @Test
    public void testGetArea02() {
        Rectangle r1 = new Rectangle(4, 8);
        Assert.assertEquals("El �rea del rect�ngulo no coincide con el valor esperado", 32.0, r1.getArea(), 0);
    }
    
    @Test
    public void testGetArea03() {
        Rectangle r1 = new Rectangle(1, 10);
        Assert.assertEquals("El �rea del rect�ngulo no coincide con el valor esperado", 10.0, r1.getArea(), 0);
    }
    
    @Test
    public void testGetPerimeter01() {
        Rectangle r1 = new Rectangle();
        Assert.assertEquals("El per�metro del rect�ngulo no coincide con el valor esperado", 4.0, r1.getPerimeter(), 0);
    }
    
    @Test
    public void testGetPerimeter02() {
        Rectangle r1 = new Rectangle(4, 8);
        Assert.assertEquals("El per�metro del rect�ngulo no coincide con el valor esperado", 24.0, r1.getPerimeter(), 0);
    }
    
    @Test
    public void testGetPerimeter03() {
        Rectangle r1 = new Rectangle(1, 10);
        Assert.assertEquals("El per�metro del rect�ngulo no coincide con el valor esperado", 22.0, r1.getPerimeter(), 0);
    }
    
    
    @Test
    public void testEquals01()
    {
        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle();
        Assert.assertTrue("Los dos rect�ngulos deber�an ser iguales", r1.equals(r2));
    }
    
    @Test
    public void testEquals02()
    {
        Rectangle r1 = new Rectangle(5.0D, 3.5D);
        Rectangle r2 = new Rectangle(5.0D, 3.5D);
        Assert.assertTrue("Los dos rect�ngulos deber�an ser iguales", r1.equals(r2));
    }
    
    @Test
    public void testEquals03()
    {
        Rectangle r1 = new Rectangle(1.0D, 1.0D);
        Rectangle r2 = new Rectangle();
        Assert.assertTrue("Los dos rect�ngulos deber�an ser iguales", r1.equals(r2));
    }
    
    @Test
    public void testNoEquals01()
    {
        Rectangle r1 = new Rectangle(5.0D, 3.0D);
        Rectangle r2 = new Rectangle(4.0D, 3.5D);
        Assert.assertFalse("Los dos rect�ngulos no deber�an ser iguales", r1.equals(r2));
    }
    
    @Test
    public void testNoEquals02()
    {
        Rectangle r1 = new Rectangle(5.0D, 3.5D);
        Assert.assertFalse("Los dos rect�ngulos no deber�an ser iguales", r1.equals(null));
        Assert.assertFalse("Los dos rect�ngulos no deber�an ser iguales", r1.equals("hola"));
        Assert.assertFalse("Los dos rect�ngulos no deber�an ser iguales", r1.equals(5.0D));
    }
    
    @Test
    public void testHashCode01()
    {
        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle();
        Assert.assertEquals("Los dos rect�ngulos deber�an tener el mismo c�digo de hash", r1.hashCode(), r2.hashCode());
    }
    
    @Test
    public void testHashCode02()
    {
        Rectangle r1 = new Rectangle(5.0D, 3.5D);
        Rectangle r2 = new Rectangle(5.0D, 3.5D);
        Assert.assertEquals("Los dos rect�ngulos deber�an tener el mismo c�digo de hash", r1.hashCode(), r2.hashCode());
    }
    
    @Test
    public void testHashCode03()
    {
        Rectangle r1 = new Rectangle(1.0D, 1.0D);
        Rectangle r2 = new Rectangle();
        Assert.assertEquals("Los dos rect�ngulos deber�an tener el mismo c�digo de hash", r1.hashCode(), r2.hashCode());
    }
    
    @Test
    public void testHashCode04()
    {
        Rectangle r1 = new Rectangle(5.0D, 3.0D);
        Rectangle r2 = new Rectangle(4.0D, 3.5D);
        Assert.assertNotSame("Los dos rect�ngulos no deber�an tener el mismo c�digo de hash", r1.hashCode(), r2.hashCode());
    }
    //</editor-fold>

}