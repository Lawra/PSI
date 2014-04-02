package com.lferre.geoapp.entitieslayer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class CylinderTest {

    //<editor-fold defaultstate="collapsed" desc="Inicializaci�n del juego de pruebas">
    
    public CylinderTest() {
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Ciclo de vida del juego de pruebas">
    
    @BeforeClass
    public static void init() {
        System.out.printf("\n\nINIT: Se carga el juego de pruebas %s en el Test-Runner\n", CylinderTest.class.getSimpleName());
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
        System.out.printf("FINISH: Se procede a descargar el juego de pruebas %s del Test-Runner\n", CylinderTest.class.getSimpleName());
    }

    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Unit Tests o pruebas del juego de pruebas">
    
    @Test
    public void testNumConstructors() {
        Class classDef = Cylinder.class;
        Assert.assertEquals("N�mero de constructores no v�lido", 2, classDef.getConstructors().length);
    }
    
    @Test
    public void testConstructorWithNoParameters() {
        Cylinder c = new Cylinder();
        Assert.assertEquals("Radio del cilindro no inicializado correctamente al valor por defecto", 1.0D, c.getRadius(), 0D);
        Assert.assertEquals("Altura del cilindro no inicializado correctamente al valor por defecto", 1.0D, c.getHeight(), 0D);
    }
    
    @Test
    public void testMainConstructor() {
        Cylinder c = new Cylinder(15.34D, 3.89D);
        Assert.assertEquals("Radio del cilindro no inicializado correctamente al valor indicado", 15.34D, c.getRadius(), 0D);
        Assert.assertEquals("Altura del cilindro no inicializada correctamente al valor indicado", 3.89D, c.getHeight(), 0D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testMainConstructorWithErrors01() {
        Cylinder c = new Cylinder(0D, 0D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testMainConstructorWithErrors02() {
        Cylinder c = new Cylinder(10.4D, 0D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testMainConstructorWithErrors03() {
        Cylinder c = new Cylinder(0D, 5.30D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testMainConstructorWithErrors04() {
        Cylinder c = new Cylinder(5.8D, -10.5D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testMainConstructorWithErrors05() {
        Cylinder c = new Cylinder(-14.39D, 3.8D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testMainConstructorWithErrors06() {
        Cylinder c = new Cylinder(-14.39D, -3.8D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetRadiusWithError01() {
        Cylinder c = new Cylinder();
        c.setRadius(0.0D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetRadiusWithError02() {
        Cylinder c = new Cylinder();
        c.setRadius(-10.0D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetHeightWithError01() {
        Cylinder c = new Cylinder();
        c.setHeight(0.0D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetHeightWithError02() {
        Cylinder c = new Cylinder();
        c.setHeight(-10.0D);
    }
    
    @Test
    public void testGetArea01() {
        Cylinder c1 = new Cylinder();
        Assert.assertEquals("El �rea del cilindro no coincide con el valor esperado", 12.566, c1.getArea(), 0.01);
    }
    
    @Test
    public void testGetArea02() {
        Cylinder c1 = new Cylinder(4, 8);
        Assert.assertEquals("El �rea del cilindro no coincide con el valor esperado", 301.592, c1.getArea(), 0.01);
    }
    
    @Test
    public void testGetArea03() {
        Cylinder c1 = new Cylinder(1, 10);
        Assert.assertEquals("El �rea del cilindro no coincide con el valor esperado", 69.115, c1.getArea(), 0.01);
    }
    
    @Test
    public void testGetVolume01() {
        Cylinder c1 = new Cylinder();
        Assert.assertEquals("El volumen del cilindro no coincide con el valor esperado", 3.1415, c1.getVolume(), 0.01);
    }
    
    @Test
    public void testGetVolume02() {
        Cylinder c1 = new Cylinder(4, 8);
        Assert.assertEquals("El volumen del cilindro no coincide con el valor esperado", 402.123, c1.getVolume(), 0.01);
    }
    
    @Test
    public void testGetVolume03() {
        Cylinder c1 = new Cylinder(1, 10);
        Assert.assertEquals("El volumen del cilindro no coincide con el valor esperado", 31.415, c1.getVolume(), 0.01);
    }
    
    @Test
    public void testEquals01()
    {
        Cylinder c1 = new Cylinder();
        Cylinder c2 = new Cylinder();
        Assert.assertTrue("Los dos cilindros deber�an ser iguales", c1.equals(c2));
    }
    
    @Test
    public void testEquals02()
    {
        Cylinder c1 = new Cylinder(5.0D, 3.5D);
        Cylinder c2 = new Cylinder(5.0D, 3.5D);
        Assert.assertTrue("Los dos cilindros deber�an ser iguales", c1.equals(c2));
    }
    
    @Test
    public void testEquals03()
    {
        Cylinder c1 = new Cylinder(1.0D, 1.0D);
        Cylinder c2 = new Cylinder();
        Assert.assertTrue("Los dos cilindros deber�an ser iguales", c1.equals(c2));
    }
    
    @Test
    public void testNoEquals01()
    {
        Cylinder c1 = new Cylinder(5.0D, 3.0D);
        Cylinder c2 = new Cylinder(4.0D, 3.5D);
        Assert.assertFalse("Los dos cilindros no deber�an ser iguales", c1.equals(c2));
    }
    
    @Test
    public void testNoEquals02()
    {
        Cylinder c1 = new Cylinder(5.0D, 3.5D);
        Assert.assertFalse("Los dos cilindros no deber�an ser iguales", c1.equals(null));
        Assert.assertFalse("Los dos cilindros no deber�an ser iguales", c1.equals("hola"));
        Assert.assertFalse("Los dos cilindros no deber�an ser iguales", c1.equals(5.0D));
    }
    
    @Test
    public void testHashCode01()
    {
        Cylinder c1 = new Cylinder();
        Cylinder c2 = new Cylinder();
        Assert.assertEquals("Los dos cilindros deber�an tener el mismo c�digo de hash", c1.hashCode(), c2.hashCode());
    }
    
    @Test
    public void testHashCode02()
    {
        Cylinder c1 = new Cylinder(5.0D, 3.5D);
        Cylinder c2 = new Cylinder(5.0D, 3.5D);
        Assert.assertEquals("Los dos cilindros deber�an tener el mismo c�digo de hash", c1.hashCode(), c2.hashCode());
    }
    
    @Test
    public void testHashCode03()
    {
        Cylinder c1 = new Cylinder(1.0D, 1.0D);
        Cylinder c2 = new Cylinder();
        Assert.assertEquals("Los dos cilindros deber�an tener el mismo c�digo de hash", c1.hashCode(), c2.hashCode());
    }
    
    @Test
    public void testHashCode04()
    {
        Cylinder c1 = new Cylinder(5.0D, 3.0D);
        Cylinder c2 = new Cylinder(4.0D, 3.5D);
        Assert.assertNotSame("Los dos cilindros no deber�an tener el mismo c�digo de hash", c1.hashCode(), c2.hashCode());
    }
    //</editor-fold>

}