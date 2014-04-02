package com.lferre.geoapp.entitieslayer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



public class SquareTest {
    
    //<editor-fold defaultstate="collapsed" desc="Inicializaci�n del juego de pruebas">
    
    public SquareTest() {
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Ciclo de vida del juego de pruebas">
    
    @BeforeClass
    public static void init() {
        System.out.printf("\n\nINIT: Se carga el juego de pruebas %s en el Test-Runner\n", SquareTest.class.getSimpleName());
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
        System.out.printf("FINISH: Se procede a descargar el juego de pruebas %s del Test-Runner\n", SquareTest.class.getSimpleName());
    }

    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Unit Tests o pruebas del juego de pruebas">
    
    @Test
    public void testNumConstructors() {
        Class classDef = Square.class;
        Assert.assertEquals("N�mero de constructores no v�lido", 2, classDef.getConstructors().length);
    }
    
    @Test
    public void testConstructorWithNoParameters() {
        Square s = new Square();
        Assert.assertEquals("Lado del cuadrado no inicializado correctamente al valor por defecto", 1.0D, s.getSide(), 0D);
    }
    
    @Test
    public void testMainConstructor() {
        Square s = new Square(3.8D);
        Assert.assertEquals("Lado del cuadrado no inicializado correctamente al valor indicado", 3.8D, s.getSide(), 0D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testMainConstructorWithErrors01() {
        Square s = new Square(0D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testMainConstructorWithErrors02() {
        Square s = new Square(-10.0D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetSideWithError01() {
        Square s = new Square();
        s.setSide(0.0D);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetSideWithError02() {
        Square s = new Square();
        s.setSide(-10.0D);
    }
    
    @Test
    public void testGetArea01() {
        Square c1 = new Square();
        Assert.assertEquals("El �rea del cuadrado no coincide con el valor esperado", 1.0, c1.getArea(), 0.0);
    }
    
    @Test
    public void testGetArea02() {
        Square c1 = new Square(2.0D);
        Assert.assertEquals("El �rea del cuadrado no coincide con el valor esperado", 4.0, c1.getArea(), 0.0);
    }
    
    @Test
    public void testGetArea03() {
        Square c1 = new Square(4.0D);
        Assert.assertEquals("El �rea del cuadrado no coincide con el valor esperado", 16.0, c1.getArea(), 0.0);
    }
    
    @Test
    public void testGetPerimeter01() {
        Square c1 = new Square();
        Assert.assertEquals("El per�metro del cuadrado no coincide con el valor esperado", 4.0, c1.getPerimeter(), 0.0);
    }
    
    @Test
    public void testGetPerimeter02() {
        Square c1 = new Square(2.0D);
        Assert.assertEquals("El per�metro del cuadrado no coincide con el valor esperado", 8.0, c1.getPerimeter(), 0.0);
    }
    
    @Test
    public void testGetPerimeter03() {
        Square c1 = new Square(4.0D);
        Assert.assertEquals("El per�metro del cuadrado no coincide con el valor esperado", 16.0, c1.getPerimeter(), 0.0);
    }

    @Test
    public void testEquals01()
    {
        Square s1 = new Square();
        Square s2 = new Square();
        Assert.assertTrue("Los dos cuadrados deber�an ser iguales", s1.equals(s2));
    }
    
    @Test
    public void testEquals02()
    {
        Square s1 = new Square(5.0D);
        Square s2 = new Square(5.0D);
        Assert.assertTrue("Los dos cuadrados deber�an ser iguales", s1.equals(s2));
    }
    
    @Test
    public void testEquals03()
    {
        Square s1 = new Square(1.0D);
        Square s2 = new Square();
        Assert.assertTrue("Los dos cuadrados deber�an ser iguales", s1.equals(s2));
    }
    
    @Test
    public void testNoEquals01()
    {
        Square s1 = new Square(5.0D);
        Square s2 = new Square(4.0D);
        Assert.assertFalse("Los dos cuadrados no deber�an ser iguales", s1.equals(s2));
    }
    
    @Test
    public void testNoEquals02()
    {
        Square s1 = new Square(5.0D);
        Assert.assertFalse("Los dos cuadrados no deber�an ser iguales", s1.equals(null));
        Assert.assertFalse("Los dos cuadrados no deber�an ser iguales", s1.equals("hola"));
        Assert.assertFalse("Los dos cuadrados no deber�an ser iguales", s1.equals(5.0D));
    }
    
    @Test
    public void testHashCode01()
    {
        Square s1 = new Square();
        Square s2 = new Square();
        Assert.assertEquals("Los dos cuadrados deber�an tener el mismo c�digo de hash", s1.hashCode(), s2.hashCode());
    }
    
    @Test
    public void testHashCode02()
    {
        Square s1 = new Square(5.0D);
        Square s2 = new Square(5.0D);
        Assert.assertEquals("Los dos cuadrados deber�an tener el mismo c�digo de hash", s1.hashCode(), s2.hashCode());
    }
    
    @Test
    public void testHashCode03()
    {
        Square s1 = new Square(1.0D);
        Square s2 = new Square();
        Assert.assertEquals("Los dos cuadrados deber�an tener el mismo c�digo de hash", s1.hashCode(), s2.hashCode());
    }
    
    @Test
    public void testHashCode04()
    {
        Square s1 = new Square(5.0D);
        Square s2 = new Square(4.0D);
        Assert.assertNotSame("Los dos cuadrados no deber�an tener el mismo c�digo de hash", s1.hashCode(), s2.hashCode());
    }
    //</editor-fold>

}
