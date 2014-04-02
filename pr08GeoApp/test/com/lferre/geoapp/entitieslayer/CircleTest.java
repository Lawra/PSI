package com.lferre.geoapp.entitieslayer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



public class CircleTest {

    //<editor-fold defaultstate="collapsed" desc="Inicializaci�n del juego de pruebas">
    
    public CircleTest() {
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Ciclo de vida del juego de pruebas">
    
    @BeforeClass
    public static void init() {
        System.out.printf("\n\nINIT: Se carga el juego de pruebas %s en el Test-Runner\n", CircleTest.class.getSimpleName());
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
        System.out.printf("FINISH: Se procede a descargar el juego de pruebas %s del Test-Runner\n", CircleTest.class.getSimpleName());
    }

    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Unit Tests o pruebas del juego de pruebas">
    @Test
    public void testNumConstructors() {
        Class classDef = Circle.class;
        Assert.assertEquals("N�mero de constructores no v�lido", 2, classDef.getConstructors().length);
    }
    
    @Test
    public void testConstructorWithNoParameters() {
        Circle c = new Circle();
        Assert.assertEquals("Radio del c�rculo no inicializado correctamente al valor por defecto", 1.0D, c.getRadius(), 0D);
    }
    
    @Test
    public void testMainConstructor() {
        Circle c = new Circle(4.58D);
        Assert.assertEquals("Radio del c�rculo no inicializado correctamente al valor indicado", 4.58D, c.getRadius(), 0D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testMainConstructorWithErrors01() {
        Circle c = new Circle(0D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testMainConstructorWithErrors02() {
        Circle c = new Circle(-13.28D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetRadiusWithError01() {
        Circle c = new Circle();
        c.setRadius(0.0D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetRadiusWithError02() {
        Circle c = new Circle();
        c.setRadius(-10.0D);
    }
    
    @Test
    public void testGetArea01() {
        Circle c1 = new Circle();
        Assert.assertEquals("El �rea del c�rculo no coincide con el valor esperado", 3.14, c1.getArea(), 0.01);
    }
    
    @Test
    public void testGetArea02() {
        Circle c1 = new Circle(5.0);
        Assert.assertEquals("El �rea del c�rculo no coincide con el valor esperado", 78.53, c1.getArea(), 0.01);
    }
    
    @Test
    public void testGetArea03() {
        Circle c1 = new Circle(9.0);
        Assert.assertEquals("El �rea del c�rculo no coincide con el valor esperado", 254.46, c1.getArea(), 0.01);
    }
    
    @Test
    public void testGetPerimeter01() {
        Circle c1 = new Circle();
        Assert.assertEquals("El per�metro del c�rculo no coincide con el valor esperado", 6.28, c1.getPerimeter(), 0.01);
    }
    
    @Test
    public void testGetPerimeter02() {
        Circle c1 = new Circle(5.0);
        Assert.assertEquals("El per�metro del c�rculo no coincide con el valor esperado", 31.41, c1.getPerimeter(), 0.01);
    }
    
    @Test
    public void testGetPerimeter03() {
        Circle c1 = new Circle(9.0);
        Assert.assertEquals("El per�metro del c�rculo no coincide con el valor esperado", 56.54, c1.getPerimeter(), 0.01);
    }
    
    @Test
    public void testEquals01()
    {
        Circle c1 = new Circle();
        Circle c2 = new Circle();
        Assert.assertTrue("Los dos c�rculos deber�an ser iguales", c1.equals(c2));
    }
    
    @Test
    public void testEquals02()
    {
        Circle c1 = new Circle(5.0D);
        Circle c2 = new Circle(5.0D);
        Assert.assertTrue("Los dos c�rculos deber�an ser iguales", c1.equals(c2));
    }
    
    @Test
    public void testEquals03()
    {
        Circle c1 = new Circle(1.0D);
        Circle c2 = new Circle();
        Assert.assertTrue("Los dos c�rculos deber�an ser iguales", c1.equals(c2));
    }
    
    @Test
    public void testNoEquals01()
    {
        Circle c1 = new Circle(5.0D);
        Circle c2 = new Circle(4.0D);
        Assert.assertFalse("Los dos c�rculos no deber�an ser iguales", c1.equals(c2));
    }
    
    @Test
    public void testNoEquals02()
    {
        Circle c1 = new Circle(5.0D);
        Assert.assertFalse("Los dos c�rculos no deber�an ser iguales", c1.equals(null));
        Assert.assertFalse("Los dos c�rculos no deber�an ser iguales", c1.equals("hola"));
        Assert.assertFalse("Los dos c�rculos no deber�an ser iguales", c1.equals(5.0D));
    }
    
    @Test
    public void testHashCode01()
    {
        Circle c1 = new Circle();
        Circle c2 = new Circle();
        Assert.assertEquals("Los dos c�rculos deber�an tener el mismo c�digo de hash", c1.hashCode(), c2.hashCode());
    }
    
    @Test
    public void testHashCode02()
    {
        Circle c1 = new Circle(5.0D);
        Circle c2 = new Circle(5.0D);
        Assert.assertEquals("Los dos c�rculos deber�an tener el mismo c�digo de hash", c1.hashCode(), c2.hashCode());
    }
    
    @Test
    public void testHashCode03()
    {
        Circle c1 = new Circle(1.0D);
        Circle c2 = new Circle();
        Assert.assertEquals("Los dos c�rculos deber�an tener el mismo c�digo de hash", c1.hashCode(), c2.hashCode());
    }
    
    @Test
    public void testHashCode04()
    {
        Circle c1 = new Circle(5.0D);
        Circle c2 = new Circle(4.0D);
        Assert.assertNotSame("Los dos c�rculos no deber�an tener el mismo c�digo de hash", c1.hashCode(), c2.hashCode());
    }
    //</editor-fold>

}