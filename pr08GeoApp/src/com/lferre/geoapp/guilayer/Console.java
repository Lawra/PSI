package com.lferre.geoapp.guilayer;

import com.lferre.geoapp.entitieslayer.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Scanner;


public class Console {
    static NumberFormat localeNfmt = null;
    static Scanner stdin = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        //<editor-fold defaultstate="collapsed" desc="Declaració variables">
        boolean incorrect;
        boolean go;
        int option = 0;
        double var1;
        double var2;
        double var3;
        Square cuadrado = null;
        Rectangle rectangulo = null;
        Circle circulo = null;
        Sphere esfera = null;
        Rhombus rombo = null;
        Ellipse elipse = null;
        Cylinder cilindro = null;
        Trapezium trapecio = null;
        //</editor-fold>
        
        System.out.println("****************************************************************************");
        System.out.println("****************************************************************************");
        System.out.println("************                                                    ************");
        System.out.println("************    G E O A P P   -  S H A P E S   I N   J A V A    ************");
        System.out.println("************                                                    ************");
        System.out.println("****************************************************************************");
        System.out.println("****************************************************************************");
        
        /*
        Rectangle r = new Rectangle(10.0D, 5.0D);
        Rectangle copia = r.clonar();
        System.out.println(r.equals(copia));
        System.out.println(r.hashCode());
        System.out.println(copia.hashCode());
        Rectangle aleatori = Rectangle.getRandom();
        System.out.printf("base: %.2f, altura: %.2f\n", aleatori.getBase(), aleatori.getHeight());
        */
        do{
            go = true;
            System.out.println(" MENÚ DE OPCIONES:");
            System.out.println("- - - - - - - - - - - - - - - ");
            System.out.println(" 1.- Crear un cuadrado");
            System.out.println(" 2.- Crear un rectángulo");
            System.out.println(" 3.- Crear un círculo");
            System.out.println(" 4.- Crear una esfera");
            System.out.println(" 5.- Crear un rombo");
            System.out.println(" 6.- Crear una elipse");
            System.out.println(" 7.- Crear un cilindro");
            System.out.println(" 8.- Crear un trapecio");
            System.out.println(" 9.- Salir");
            
            do{
                incorrect = false;
                System.out.printf("Escoge una opción (1-9): ");
                try {
                    option = Integer.parseInt(stdin.nextLine());
                    if(option<1 || option>9){
                        incorrect = true;
                        System.out.println("ERROR: Has d'escollir una opció entre el 1 i el 9");
                    }
                } catch (Exception e) {
                    incorrect = true;
                    System.out.println("Error: Se debe introducir un valor numérico!!!");
                }

            }while(incorrect);
            
            //<editor-fold defaultstate="collapsed" desc="switch">
            switch(option){
                case 1:
                    //<editor-fold defaultstate="collapsed" desc="cuadrado">
                    System.out.println("\n---------------------------------");
                    System.out.println(" Figura: Cuadrado");
                    System.out.println("---------------------------------");
                    System.out.println("Introduce el valor de:");
                    
                    do{
                        incorrect = false;
                        var1 = readDouble("  - Lado (en cm): ");
                        try {
                            cuadrado = new Square(var1);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            incorrect = true;
                        }
                    }while(incorrect);
                    System.out.printf("> Área: %.2f cm2\n",cuadrado.getArea());
                    System.out.printf("> Perímetro: %.2f cm\n", cuadrado.getPerimeter());
                    //</editor-fold>
                    break;
                case 2:
                    //<editor-fold defaultstate="collapsed" desc="rectangulo">
                    System.out.println("\n---------------------------------");
                    System.out.println(" Figura: rectángulo");
                    System.out.println("---------------------------------");
                    System.out.println("Introduce los valores de:");
                    
                    do{
                        incorrect = false;
                        var1 = readDouble("  - Base (en cm): ");
                        var2 = readDouble("  - Altura (en cm): ");
                        try {
                            rectangulo = new Rectangle(var1, var2);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            incorrect = true;
                        }
                    }while(incorrect);
                    
                    System.out.printf("> Área: %.2f cm2\n",rectangulo.getArea());
                    System.out.printf("> Perímetro: %.2f cm\n", rectangulo.getPerimeter());
                    System.out.printf("> Metodo utilizado del área: %s\n", Rectangle.getAreaFormula());
                    System.out.printf("> Metodo utilizado del perimetro: %s\n", Rectangle.getPerimeterFormula());
//</editor-fold>
                    break;
                case 3:
                    //<editor-fold defaultstate="collapsed" desc="circulo">
                    System.out.println("\n---------------------------------");
                    System.out.println(" Figura: círculo");
                    System.out.println("---------------------------------");
                    System.out.println("Introduce el valor de:");
                    
                    do{
                        incorrect = false;
                        var1 = readDouble("  - Radio (en cm): ");
                        try {
                            circulo = new Circle(var1);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            incorrect = true;
                        }
                    }while(incorrect);

                    System.out.printf("> Área: %.2f cm2\n",circulo.getArea());
                    System.out.printf("> Perímetro: %.2f cm\n", circulo.getPerimeter());
                    //</editor-fold>
                    break;
                case 4:
                    //<editor-fold defaultstate="collapsed" desc="esfera">
                    System.out.println("\n---------------------------------");
                    System.out.println(" Figura: esfera");
                    System.out.println("---------------------------------");
                    System.out.println("Introduce el valor de:");
                    
                    do{
                        incorrect = false;
                        var1 = readDouble("  - Radio (en cm): ");
                        try {
                            esfera = new Sphere(var1);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            incorrect = true;
                        }
                    }while(incorrect);
                    System.out.printf("> Área: %.2f cm2\n",esfera.getArea());
                    System.out.printf("> Volumen: %.2f cm3\n", esfera.getVolume());
                    //</editor-fold>
                    break;
                case 5:
                    //<editor-fold defaultstate="collapsed" desc="rombo">
                    System.out.println("\n---------------------------------");
                    System.out.println(" Figura: rombo");
                    System.out.println("---------------------------------");
                    System.out.println("Introduce los valores de:");
                    
                    do{
                        incorrect = false;
                        var1 = readDouble("  - xAxis (en cm): ");
                        var2 = readDouble("  - yAxis (en cm): ");
                        try {
                            rombo = new Rhombus(var1, var2);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            incorrect = true;
                        }
                    }while(incorrect);
                    System.out.printf("> Área: %.2f cm2\n",rombo.getArea());
                    System.out.printf("> Perímetro: %.2f cm\n", rombo.getPerimeter());
                    //</editor-fold>
                    break;
                case 6:
                    //<editor-fold defaultstate="collapsed" desc="elipse">
                    System.out.println("\n---------------------------------");
                    System.out.println(" Figura: elipse");
                    System.out.println("---------------------------------");
                    System.out.println("Introduce los valores de:");
                    
                    do{
                        incorrect = false;
                        var1 = readDouble("  - xAxis (en cm): ");
                        var2 = readDouble("  - yAxis (en cm): ");
                        try {
                            elipse = new Ellipse(var1, var2);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            incorrect = true;
                        }
                    }while(incorrect);
                    System.out.printf("> Área: %.2f cm2\n",elipse.getArea());
                    System.out.printf("> Perímetro: %.2f cm\n", elipse.getPerimeter());
                    //</editor-fold>
                    break;
                case 7:
                    //<editor-fold defaultstate="collapsed" desc="cilindro">
                    System.out.println("\n---------------------------------");
                    System.out.println(" Figura: cilindro");
                    System.out.println("---------------------------------");
                    System.out.println("Introduce los valores de:");
                    
                    do{
                        incorrect = false;
                        var1 = readDouble("  - Radio (en cm): ");
                        var2 = readDouble("  - Altura (en cm): ");
                        try {
                            cilindro = new Cylinder(var1, var2);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            incorrect = true;
                        }
                    }while(incorrect);
                    System.out.printf("> Área: %.2f cm2\n",cilindro.getArea());
                    System.out.printf("> Perímetro: %.2f cm\n", cilindro.getVolume());
                    //</editor-fold>
                    break;
                case 8:
                    //<editor-fold defaultstate="collapsed" desc="Trapecio">
                    System.out.println("\n---------------------------------");
                    System.out.println(" Figura: trapecio");
                    System.out.println("---------------------------------");
                    System.out.println("Introduce los valores de:");
                    
                    do{
                        incorrect = false;
                        var1 = readDouble("  - Base menor (en cm): ");
                        var2 = readDouble("  - Base mayor (en cm): ");
                        var3 = readDouble("  - Altura (en cm): ");
                        try {
                            trapecio = new Trapezium(var1, var2, var3);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            incorrect = true;
                        }
                    }while(incorrect);
                    System.out.printf("> Área: %.2f cm2\n",trapecio.getArea());
                    System.out.printf("> Perímetro: %.2f cm\n", trapecio.getPerimeter());
                    //</editor-fold>
                    break;
                case 9:
                    printNumGeo();
                    System.exit(0);
                    break;
                default:     
            }
//</editor-fold>
            
            stdin.nextLine();
        }while(go);
        
    }

    public static void printNumGeo(){
        System.out.println("\n----- Geometrias creadas -----");
        System.out.printf("- Has creado %d cuadrados\n", Square.getNumSquare());
        System.out.printf("- Has creado %d rectangulos\n", Rectangle.getNumRectangle());
        System.out.printf("- Has creado %d circulos\n", Circle.getNumCircle());
        System.out.printf("- Has creado %d cilindros\n", Cylinder.getNumCylinder());
        System.out.printf("- Has creado %d elipses\n", Ellipse.getNumEllipse());
        System.out.printf("- Has creado %d rombos\n", Rhombus.getNumRhombus());
        System.out.printf("- Has creado %d esferas\n", Sphere.getNumSphere());
        System.out.printf("- Has creado %d trapecios\n", Trapezium.getNumTrapezium());
        System.out.println("------------------------------");
    }
    
    
    public static double readDouble(String message) {
        double value = 0D;
        
        NumberFormat formatter = NumberFormat.getNumberInstance();
        boolean isCorrectValue = false;
        do {
            System.out.print(message);
            try {
                value = formatter.parse(stdin.nextLine()).doubleValue();
                if (value > 0D) {
                    isCorrectValue = true;
                }
                else {
                    System.out.println("Error: Se debe introducir un valor positivo!!!");
                }
            }
            catch (ParseException ex) {
                System.out.println("Error: Se debe introducir un valor numérico!!!");
            }
        }
        while (!isCorrectValue);
        
        return value;
    }
    
}
