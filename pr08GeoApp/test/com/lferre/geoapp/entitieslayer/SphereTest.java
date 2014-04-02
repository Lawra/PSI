package com.lferre.geoapp.entitieslayer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SphereTest {

    //<editor-fold defaultstate="collapsed" desc="Inicializaci�n del juego de pruebas">
    
    public SphereTest() {
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Ciclo de vida del juego de pruebas">
    
    @BeforeClass
    public static void init() {
        System.out.printf("\n\nINIT: Se carga el juego de pruebas %s en el Test-Runner\n", SphereTest.class.getSimpleName());
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
        System.out.printf("FINISH: Se procede a descargar el juego de pruebas %s del Test-Runner\n", SphereTest.class.getSimpleName());
    }

    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Unit Tests o pruebas del juego de pruebas">
    @Test
    public void testNumConstructors() {
        Class classDef = Sphere.class;
        Assert.assertEquals("N�mero de constructores no v�lido", 2, classDef.getConstructors().length);
    }
    
    @Test
    public void testConstructorWithNoParameters() {
        Sphere s = new Sphere();
        Assert.assertEquals("Radio de la esfera no inicializado correctamente al valor por defecto", 1.0D, s.getRadius(), 0D);
    }
    
    @Test
    public void testMainConstructor() {
        Sphere s = new Sphere(3.8D);
        Assert.assertEquals("Radio de la esfera no inicializado correctamente al valor indicado", 3.8D, s.getRadius(), 0D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testMainConstructorWithErrors01() {
        Sphere s = new Sphere(0D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testMainConstructorWithErrors02() {
        Sphere s = new Sphere(-13.28D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetRadiusWithError01() {
        Sphere s = new Sphere();
        s.setRadius(0.0D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetRadiusWithError02() {
        Sphere s = new Sphere();
        s.setRadius(-10.0D);
    }
    
    @Test
    public void testGetArea01() {
        Sphere s1 = new Sphere();
        Assert.assertEquals("El �rea de la esfera no coincide con el valor esperado", 12.56, s1.getArea(), 0.01);
    }
    
    @Test
    public void testGetArea02() {
        Sphere s1 = new Sphere(5.0);
        Assert.assertEquals("El �rea de la esfera no coincide con el valor esperado", 314.15, s1.getArea(), 0.01);
    }
    
    @Test
    public void testGetArea03() {
        Sphere s1 = new Sphere(9.0);
        Assert.assertEquals("El �rea de la esfera no coincide con el valor esperado", 1017.87, s1.getArea(), 0.01);
    }
    
    @Test
    public void testGetVolume01() {
        Sphere s1 = new Sphere();
        Assert.assertEquals("El volumen de la esfera no coincide con el valor esperado", 4.18, s1.getVolume(), 0.01);
    }
    
    @Test
    public void testGetVolume02() {
        Sphere s1 = new Sphere(5.0);
        Assert.assertEquals("El volumen de la esfera no coincide con el valor esperado", 523.59, s1.getVolume(), 0.01);
    }
    
    @Test
    public void testGetVolume03() {
        Sphere s1 = new Sphere(9.0);
        Assert.assertEquals("El volumen de la esfera no coincide con el valor esperado", 3053.62, s1.getVolume(), 0.01);
    }
    
    @Test
    public void testEquals01()
    {
        Sphere s1 = new Sphere();
        Sphere s2 = new Sphere();
        Assert.assertTrue("Las dos esferas deber�an ser iguales", s1.equals(s2));
    }
    
    @Test
    public void testEquals02()
    {
        Sphere s1 = new Sphere(5.0D);
        Sphere s2 = new Sphere(5.0D);
        Assert.assertTrue("Las dos esferas deber�an ser iguales", s1.equals(s2));
    }
    
    @Test
    public void testEquals03()
    {
        Sphere s1 = new Sphere(1.0D);
        Sphere s2 = new Sphere();
        Assert.assertTrue("Las dos esferas deber�an ser iguales", s1.equals(s2));
    }
    
    @Test
    public void testNoEquals01()
    {
        Sphere s1 = new Sphere(5.0D);
        Sphere s2 = new Sphere(4.0D);
        Assert.assertFalse("Las dos esferas no deber�an ser iguales", s1.equals(s2));
    }
    
    @Test
    public void testNoEquals02()
    {
        Sphere s1 = new Sphere(5.0D);
        Assert.assertFalse("Las dos esferas no deber�an ser iguales", s1.equals(null));
        Assert.assertFalse("Las dos esferas no deber�an ser iguales", s1.equals("hola"));
        Assert.assertFalse("Las dos esferas no deber�an ser iguales", s1.equals(5.0D));
    }
    
    @Test
    public void testHashCode01()
    {
        Sphere s1 = new Sphere();
        Sphere s2 = new Sphere();
        Assert.assertEquals("Las dos esferas deber�an tener el mismo c�digo de hash", s1.hashCode(), s2.hashCode());
    }
    
    @Test
    public void testHashCode02()
    {
        Sphere s1 = new Sphere(5.0D);
        Sphere s2 = new Sphere(5.0D);
        Assert.assertEquals("Las dos esferas deber�an tener el mismo c�digo de hash", s1.hashCode(), s2.hashCode());
    }
    
    @Test
    public void testHashCode03()
    {
        Sphere s1 = new Sphere(1.0D);
        Sphere s2 = new Sphere();
        Assert.assertEquals("Las dos esferas deber�an tener el mismo c�digo de hash", s1.hashCode(), s2.hashCode());
    }
    
    @Test
    public void testHashCode04()
    {
        Sphere s1 = new Sphere(5.0D);
        Sphere s2 = new Sphere(4.0D);
        Assert.assertNotSame("Las dos esferas no deber�an tener el mismo c�digo de hash", s1.hashCode(), s2.hashCode());
    }
    //</editor-fold>

}