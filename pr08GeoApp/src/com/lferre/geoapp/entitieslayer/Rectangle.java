package com.lferre.geoapp.entitieslayer;

import java.util.Random;

public class Rectangle {
    
    //<editor-fold defaultstate="collapsed" desc="Estat: Atributs">
    private double base;
    private double height;
    private static int numRectangle;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Comportament: metodes">
    //<editor-fold defaultstate="collapsed" desc="Setters/Getters">
     public double getBase() {
        return base;
    }

    public void setBase(double base) {
        if(base <= 0D){
            throw new IllegalArgumentException("ERROR: The base can't be negative or zero");
        }
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if(height <= 0D){
            throw new IllegalArgumentException("ERROR: The height can't be negative or zero");
        }
        this.height = height;
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Constructor">
    public Rectangle(double base, double height) {
        this.setBase(base);
        this.setHeight(height);
        numRectangle++;
    }
    public Rectangle() {
        this(1.0D, 1.0D);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Metodes">
    public double getArea(){       
        return this.getBase() * this.getHeight();
    }
    public double getPerimeter(){        
        return (this.getBase()*2 + this.getHeight()*2);
    }
    public Rectangle clonar(){
        return new Rectangle(this.getBase(), this.getHeight());
    }
//</editor-fold>
        
    //<editor-fold defaultstate="collapsed" desc="Metodes Statics">
    public static int getNumRectangle() {
        return numRectangle;
    }
    
    public static String getAreaFormula(){
        return "Area = Base x Altura";
    }
    
    public static String getPerimeterFormula(){
        return "Perimetro = (Base x 2) + (Altura x 2)";
    }
    public static Rectangle getRandom(){
        Random rnd = new Random();
        double v1 = rnd.nextInt() + rnd.nextDouble();
        double v2 = rnd.nextInt() + rnd.nextDouble();
        return new Rectangle(v1, v2);
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Override, Sobreescritura de metodos heredados">
   
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rectangle\n");
        sb.append("-------------\n");
        sb.append(String.format("-Base: %2.f cm\n", this.getBase()));
        sb.append(String.format("-Altura: %2.f cm\n", this.getHeight()));
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Rectangle)) {
            return false;
        }
        Rectangle other = (Rectangle)obj;
        return (this.getBase() == other.getBase() && this.getHeight() == other.getHeight());
    }

    @Override
    public int hashCode() {
        return String.format("%f %f", this.getBase(),this.getHeight()).hashCode();
    }
   
//</editor-fold>
    
    //</editor-fold>

}
