package com.lferre.myvueling.utilities;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;

public class StringUtilitiesTest {
    
    //<editor-fold defaultstate="collapsed" desc="Inicializaci�n del juego de pruebas">
    
    public StringUtilitiesTest() {
    
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Ciclo de vida del juego de pruebas">
    
    @BeforeClass
    public static void init() {
        System.out.printf("\n\nINIT: Se carga el juego de pruebas %s en el Test-Runner\n", StringUtilitiesTest.class.getSimpleName());
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
        System.out.printf("FINISH: Se procede a descargar el juego de pruebas %s del Test-Runner\n", StringUtilitiesTest.class.getSimpleName());
    }

    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Unit Tests o pruebas del juego de pruebas">
    
    @Test
    public void testIsFinal() {
        Class<?> utilityClass = StringUtilities.class;
        Assert.assertTrue("La clase no se ha marcado con el modificador final", Modifier.isFinal(utilityClass.getModifiers()));
    }
    
    @Test
    public void testNoPublicConstructor() {
        Class<?> utilityClass = StringUtilities.class;
        Constructor<?>[] constructors = utilityClass.getDeclaredConstructors();
        
        Assert.assertEquals("La clase debe ofrecer un �nico constructor", 1, constructors.length);
        Assert.assertTrue("El �nico constructor que ofrece la clase debe ser privado", Modifier.isPrivate(constructors[0].getModifiers()));
    }
   
    
    
    @Test
    public void testIsNullOrEmptyFalse01() {
        Assert.assertTrue("isNullOrEmpty --> false", StringUtilities.isNullOrEmpty("  "));
    }
    
    @Test
    public void testIsNullOrEmptyFalse02() {
        Assert.assertTrue("isNullOrEmpty --> false", StringUtilities.isNullOrEmpty(""));
    }
    
    @Test
    public void testIsNullOrEmptyFalse03() {
        Assert.assertTrue("isNullOrEmpty --> false", StringUtilities.isNullOrEmpty(null));
    }
    
    @Test
    public void testIsNullOrEmptyTrue01() {
        Assert.assertFalse("isNullOrEmpty --> true", StringUtilities.isNullOrEmpty("Hola"));
    }
    
    @Test
    public void testIsNullOrEmptyTrue02() {
        Assert.assertFalse("isNullOrEmpty --> true", StringUtilities.isNullOrEmpty("         a"));
    }
    
    @Test
    public void testIsNullOrEmptyTrue03() {
        Assert.assertFalse("isNullOrEmpty --> true", StringUtilities.isNullOrEmpty("Barcelona"));
    }
    
    @Test(expected=NullPointerException.class)
    public void testTruncateWithErrors01() {
        StringUtilities.truncate(null, 10, "...");
    }
    
    @Test(expected=NullPointerException.class)
    public void testTruncateWithErrors02() {
        StringUtilities.truncate("Texto a truncar", 10, null);
    }
    
    @Test(expected=NullPointerException.class)
    public void testTruncateWithErrors03() {
        StringUtilities.truncate("Texto a truncar", 10, "");
    }
    
    @Test(expected=NullPointerException.class)
    public void testTruncateWithErrors04() {
        StringUtilities.truncate("Texto a truncar", 10, "  ");
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testTruncateWithErrors05() {
        StringUtilities.truncate("Texto a truncar", 0, "...");
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testTruncateWithErrors06() {
        StringUtilities.truncate("Texto a truncar", -5, "...");
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testTruncateWithErrors07() {
        StringUtilities.truncate("Texto a truncar", 3, "...");
    }
    
    @Test(expected=NullPointerException.class)
    public void testTruncateWithErrors08() {
        StringUtilities.truncate(null, 10);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testTruncateWithErrors09() {
        StringUtilities.truncate("Texto a truncar", 0);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testTruncateWithErrors10() {
        StringUtilities.truncate("Texto a truncar", -5);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testTruncateWithErrors11() {
        StringUtilities.truncate("Texto a truncar", 1);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testTruncateWithErrors12() {
        StringUtilities.truncate("Texto a truncar", 3);
    }
    
    @Test
    public void testTruncate01() { 
        Assert.assertEquals("El m�todo truncate no est� bien implementado", "Esto es un texto ...", StringUtilities.truncate("Esto es un texto tan largo que da palo", 20, "..."));
    }
    
    @Test
    public void testTruncate02() { 
        Assert.assertEquals("El m�todo truncate no est� bien implementado", "Esto es un texto tan la..", StringUtilities.truncate("Esto es un texto tan largo que da palo", 25, ".."));
    }
    
    @Test
    public void testTruncate03() { 
        Assert.assertEquals("El m�todo truncate no est� bien implementado", "Esto es un texto ...", StringUtilities.truncate("Esto es un texto tan largo que da palo", 20));
    }
    
    @Test
    public void testTruncate04() { 
        Assert.assertEquals("El m�todo truncate no est� bien implementado", "Esto es un texto tan l...", StringUtilities.truncate("Esto es un texto tan largo que da palo", 25));
    }
    
    @Test
    public void testNoTruncate01() {
        Assert.assertEquals("El m�todo truncate no est� bien implementado", "Esto es un texto tan largo que da palo", StringUtilities.truncate("Esto es un texto tan largo que da palo", 40, "..."));
    }
    
    @Test
    public void testNoTruncate02() {
        Assert.assertEquals("El m�todo truncate no est� bien implementado", "", StringUtilities.truncate("", 25, ".."));
    }
    
    @Test
    public void testNoTruncate03() {
        Assert.assertEquals("El m�todo truncate no est� bien implementado", "  ", StringUtilities.truncate("  ", 25, "..")); 
    }
    
    @Test
    public void testNoTruncate04() {
        Assert.assertEquals("El m�todo truncate no est� bien implementado", "Esto es un texto tan largo que da palo", StringUtilities.truncate("Esto es un texto tan largo que da palo", 40));
   }
    
    @Test
    public void testNoTruncate05() {
        Assert.assertEquals("El m�todo truncate no est� bien implementado", "", StringUtilities.truncate("", 25));
    }
    
    @Test
    public void testNoTruncate06() {
        Assert.assertEquals("El m�todo truncate no est� bien implementado", "  ", StringUtilities.truncate("  ", 25));
    }
    
    @Test(expected=NullPointerException.class)
    public void testCapitalizeWithErrors() {
        StringUtilities.capitalize(null);
    }
    
    @Test
    public void testCapitalize01() {
        Assert.assertEquals("El m�todo capitalize no est� bien implementado", "", StringUtilities.capitalize(""));
    }
 
    @Test
    public void testCapitalize02() {
        Assert.assertEquals("El m�todo capitalize no est� bien implementado", "", StringUtilities.capitalize("   "));
    }
    
    @Test
    public void testCapitalize03() {
        Assert.assertEquals("El m�todo capitalize no est� bien implementado", "Jordi Ari�o Santos", StringUtilities.capitalize("JORDI ARI�O SANTOS"));
    }
    
    @Test
    public void testCapitalize04() {
        Assert.assertEquals("El m�todo capitalize no est� bien implementado", "M� Jes�s Rodr�guez", StringUtilities.capitalize("m� jes�s rodr�guez"));
    }
    
    @Test
    public void testCapitalize05() {
        Assert.assertEquals("El m�todo capitalize no est� bien implementado", "Jordi Ari�o Santos", StringUtilities.capitalize("  jORDI aRI�O sANTOS   "));
    }
    
    @Test
    public void testCapitalize06() {
        Assert.assertEquals("El m�todo capitalize no est� bien implementado", "Jordi Ari�o Santos", StringUtilities.capitalize("    jordi ari�o santos  "));
    }
    
    @Test
    public void testCapitalize07() {
        Assert.assertEquals("El m�todo capitalize no est� bien implementado", "Jordi Ari�o Santos", StringUtilities.capitalize("    jordi   ari�o    santos  "));
    }
    
    @Test
    public void testCapitalize08() {
        Assert.assertEquals("El m�todo capitalize no est� bien implementado", "Ari�o Santos, Jordi", StringUtilities.capitalize("    ari�o santos, jordi"));
    }
    
    @Test
    public void testCapitalize09() {
        Assert.assertEquals("El m�todo capitalize no est� bien implementado", "Rodr�guez Pliego, M� Jes�s", StringUtilities.capitalize("rodr�guez pliego, m� jes�s"));
    }
    
    @Test
    public void testCapitalize10() {
        Assert.assertEquals("El m�todo capitalize no est� bien implementado", "Pedro J Ramirez", StringUtilities.capitalize("pedro j ramirez"));
    }
    
    @Test
    public void testCapitalize11() {
        Assert.assertEquals("El m�todo capitalize no est� bien implementado", "Pedro J. Ramirez", StringUtilities.capitalize("pedro j. ramirez"));
    }
    
    @Test(expected=NullPointerException.class)
    public void testRemoveWhiteSpacesWithErrors() {
        StringUtilities.removeWhiteSpaces(null);
    }
    
    @Test
    public void testRemoveWhiteSpaces01() {
        Assert.assertEquals("El m�todo removeWhiteSpaces no est� bien implementado", "", StringUtilities.removeWhiteSpaces("      "));
    }
    
    @Test
    public void testRemoveWhiteSpaces02() {
        Assert.assertEquals("El m�todo removeWhiteSpaces no est� bien implementado", "", StringUtilities.removeWhiteSpaces(""));
    }
    
    @Test
    public void testRemoveWhiteSpaces03() {
        Assert.assertEquals("El m�todo removeWhiteSpaces no est� bien implementado", "Holaestoesunacadenadetexto", StringUtilities.removeWhiteSpaces(" Hola esto    es una   cadena de texto   "));
    }
    
    @Test
    public void testRemoveWhiteSpaces04() {
        Assert.assertEquals("El m�todo removeWhiteSpaces no est� bien implementado", "Holaestoesunacadenadetexto", StringUtilities.removeWhiteSpaces("Hola esto es una cadena de texto"));
    }
    
    @Test(expected=NullPointerException.class)
    public void testTrimWhiteSpacesWithErrors() {
        StringUtilities.trimWhiteSpaces(null);
    }
    
    @Test
    public void testTrimWhiteSpaces01() {
        Assert.assertEquals("El m�todo trimWhiteSpaces no est� bien implementado", "", StringUtilities.trimWhiteSpaces("      "));
    }
    
    @Test
    public void testTrimWhiteSpaces02() {
        Assert.assertEquals("El m�todo trimWhiteSpaces no est� bien implementado", "", StringUtilities.trimWhiteSpaces(""));
    }
    
    @Test
    public void testTrimWhiteSpaces03() {
        Assert.assertEquals("El m�todo trimWhiteSpaces no est� bien implementado", "Hola esto es una cadena de texto", StringUtilities.trimWhiteSpaces(" Hola esto    es una   cadena de texto   "));
    }
    
    @Test
    public void testTrimWhiteSpaces04() {
        Assert.assertEquals("El m�todo trimWhiteSpaces no est� bien implementado", "Mar�a G�mez Santos", StringUtilities.trimWhiteSpaces("Mar�a G�mez Santos"));
    }
    
    @Test
    public void testTrimWhiteSpaces05() {
        Assert.assertEquals("El m�todo trimWhiteSpaces no est� bien implementado", "Mar�a G�mez Santos", StringUtilities.trimWhiteSpaces("Mar�a   G�mez   Santos"));
    }
    
    @Test
    public void testTrimWhiteSpaces06() {
        Assert.assertEquals("El m�todo trimWhiteSpaces no est� bien implementado", "Mar�a G�mez Santos", StringUtilities.trimWhiteSpaces("  Mar�a   G�mez   Santos   "));
    }
    
    @Test(expected=NullPointerException.class)
    public void testRemovePunctuationsWithErrors() {
        StringUtilities.removePunctuations(null);
    }
    
    @Test
    public void testRemovePunctuations01()
    {
        Assert.assertEquals("El m�todo removePunctuations no est� bien implementando", "Qu� esta pasando No lo s� peta o no", StringUtilities.removePunctuations("�Qu� esta pasando?. !No lo s�!!!!!; peta!!!!!!, o no!!!!!."));
    }
    
    @Test(expected=NullPointerException.class)
    public void testRemoveDiacriticsWithErrors() {
        StringUtilities.removeDiacritics(null);
    }
    
    @Test
    public void testRemoveDiacritics01()
    {
        Assert.assertEquals("El m�todo removeDiacritics no est� bien implementando", "El dia de antes fue una ilusion. Manana dios dira!!!.", StringUtilities.removeDiacritics("El d�a de ant�s fue una ilusi�n. Ma�ana di�s dir�!!!."));
    }
    
    @Test(expected=NullPointerException.class)
    public void testRemoveNoDigitsWithErrors() {
        StringUtilities.removeNoDigits(null);
    }
    
    @Test
    public void testRemoveNoDigits01()
    {
        Assert.assertEquals("El m�todo removeNoDigits no est� bien implementando", "0034932060249", StringUtilities.removeNoDigits("+0034 93.206.02.49"));
    }
    

    //</editor-fold>
    
}