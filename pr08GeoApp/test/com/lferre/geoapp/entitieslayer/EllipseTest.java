package com.lferre.geoapp.entitieslayer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EllipseTest {

    //<editor-fold defaultstate="collapsed" desc="Inicializaci�n del juego de pruebas">
    
    public EllipseTest() {
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Ciclo de vida del juego de pruebas">
    
    @BeforeClass
    public static void init() {
        System.out.printf("\n\nINIT: Se carga el juego de pruebas %s en el Test-Runner\n", EllipseTest.class.getSimpleName());
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
        System.out.printf("FINISH: Se procede a descargar el juego de pruebas %s del Test-Runner\n", EllipseTest.class.getSimpleName());
    }

    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Unit Tests o pruebas del juego de pruebas">
    
    @Test
    public void testNumConstructors() {
        Class classDef = Ellipse.class;
        Assert.assertEquals("N�mero de constructores no v�lido", 2, classDef.getConstructors().length);
    }
    
    @Test
    public void testConstructorWithNoParameters() {
        Ellipse e = new Ellipse();
        Assert.assertEquals("Eje X de la elipse no inicializado correctamente al valor por defecto", 1.0D, e.getXAxis(), 0D);
        Assert.assertEquals("Eje Y de la elipse no inicializado correctamente al valor por defecto", 1.0D, e.getYAxis(), 0D);
    }
    
    @Test
    public void testMainConstructor() {
        Ellipse e = new Ellipse(15.34D, 3.89D);
        Assert.assertEquals("Eje X de la elipse no inicializado correctamente al valor indicado", 15.34D, e.getXAxis(), 0D);
        Assert.assertEquals("Eje Y de la elipse no inicializado correctamente al valor indicado", 3.89D, e.getYAxis(), 0D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testMainConstructorWithErrors01() {
        Ellipse e = new Ellipse(0D, 0D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testMainConstructorWithErrors02() {
        Ellipse e = new Ellipse(10.4D, 0D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testMainConstructorWithErrors03() {
        Ellipse e = new Ellipse(0D, 5.30D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testMainConstructorWithErrors04() {
        Ellipse e = new Ellipse(5.8D, -10.5D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testMainConstructorWithErrors05() {
        Ellipse e = new Ellipse(-14.39D, 3.8D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testMainConstructorWithErrors06() {
        Ellipse e = new Ellipse(-14.39D, -3.8D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetXAxisWithError01() {
        Ellipse e = new Ellipse();
        e.setXAxis(0.0D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetXAxisWithError02() {
        Ellipse e = new Ellipse();
        e.setXAxis(-10.0D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetYAxisWithError01() {
        Ellipse e = new Ellipse();
        e.setYAxis(0.0D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetYAxisWithError02() {
        Ellipse e = new Ellipse();
        e.setYAxis(-10.0D);
    }
    
    @Test
    public void testGetArea01() {
        Ellipse e1 = new Ellipse();
        Assert.assertEquals("El �rea de la elipse no coincide con el valor esperado", 0.785, e1.getArea(), 0.01);
    }
    
    @Test
    public void testGetArea02() {
        Ellipse e1 = new Ellipse(4, 8);
        Assert.assertEquals("El �rea de la elipse no coincide con el valor esperado", 25.132, e1.getArea(), 0.01);
    }
    
    @Test
    public void testGetArea03() {
        Ellipse e1 = new Ellipse(1, 10);
        Assert.assertEquals("El �rea de la elipse no coincide con el valor esperado", 7.853, e1.getArea(), 0.01);
    }
    
    @Test
    public void testGetPerimeter01() {
        Ellipse e1 = new Ellipse();
        Assert.assertEquals("El per�metro de la elipse no coincide con el valor esperado", 3.1415, e1.getPerimeter(), 0.01);
    }
    
    @Test
    public void testGetPerimeter02() {
        Ellipse e1 = new Ellipse(4, 8);
        Assert.assertEquals("El per�metro de la elipse no coincide con el valor esperado", 19.869, e1.getPerimeter(), 0.01);
    }
    
    @Test
    public void testGetPerimeter03() {
        Ellipse e1 = new Ellipse(1, 10);
        Assert.assertEquals("El per�metro de la elipse no coincide con el valor esperado", 22.3252, e1.getPerimeter(), 0.01);
    }
    
    @Test
    public void testEquals01()
    {
        Ellipse e1 = new Ellipse();
        Ellipse e2 = new Ellipse();
        Assert.assertTrue("Las dos elipses deber�an ser iguales", e1.equals(e2));
    }
    
    @Test
    public void testEquals02()
    {
        Ellipse e1 = new Ellipse(5.0D, 3.5D);
        Ellipse e2 = new Ellipse(5.0D, 3.5D);
        Assert.assertTrue("Las dos elipses deber�an ser iguales", e1.equals(e2));
    }
    
    @Test
    public void testEquals03()
    {
        Ellipse e1 = new Ellipse(1.0D, 1.0D);
        Ellipse e2 = new Ellipse();
        Assert.assertTrue("Las dos elipses deber�an ser iguales", e1.equals(e2));
    }
    
    @Test
    public void testNoEquals01()
    {
        Ellipse e1 = new Ellipse(5.0D, 3.0D);
        Ellipse e2 = new Ellipse(4.0D, 3.5D);
        Assert.assertFalse("Las dos elipses no deber�an ser iguales", e1.equals(e2));
    }
    
    @Test
    public void testNoEquals02()
    {
        Ellipse e1 = new Ellipse(5.0D, 3.5D);
        Assert.assertFalse("Las dos elipses no deber�an ser iguales", e1.equals(null));
        Assert.assertFalse("Las dos elipses no deber�an ser iguales", e1.equals("hola"));
        Assert.assertFalse("Las dos elipses no deber�an ser iguales", e1.equals(5.0D));
    }
    
    @Test
    public void testHashCode01()
    {
        Ellipse e1 = new Ellipse();
        Ellipse e2 = new Ellipse();
        Assert.assertEquals("Las dos elipses deber�an tener el mismo c�digo de hash", e1.hashCode(), e2.hashCode());
    }
    
    @Test
    public void testHashCode02()
    {
        Ellipse e1 = new Ellipse(5.0D, 3.5D);
        Ellipse e2 = new Ellipse(5.0D, 3.5D);
        Assert.assertEquals("Las dos elipses deber�an tener el mismo c�digo de hash", e1.hashCode(), e2.hashCode());
    }
    
    @Test
    public void testHashCode03()
    {
        Ellipse e1 = new Ellipse(1.0D, 1.0D);
        Ellipse e2 = new Ellipse();
        Assert.assertEquals("Las dos elipses deber�an tener el mismo c�digo de hash", e1.hashCode(), e2.hashCode());
    }
    
    @Test
    public void testHashCode04()
    {
        Ellipse e1 = new Ellipse(5.0D, 3.0D);
        Ellipse e2 = new Ellipse(4.0D, 3.5D);
        Assert.assertNotSame("Las dos elipses no deber�an tener el mismo c�digo de hash", e1.hashCode(), e2.hashCode());
    }
    //</editor-fold>

}