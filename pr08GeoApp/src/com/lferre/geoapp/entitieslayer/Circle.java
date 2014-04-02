package com.lferre.geoapp.entitieslayer;


public class Circle {

    //<editor-fold defaultstate="collapsed" desc="Estat: Atributs">
    private double radius;
    private static int numCircle;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Comportament: metodes">
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        if(radius <= 0D){
            throw new IllegalArgumentException("ERROR: The radius can't be negative or zero");
        }
        this.radius = radius;
    }
    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructor">
    public Circle(double radius) {
        this.setRadius(radius);
        numCircle++;
    }
    public Circle() {
        this(1.0D);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Metodes">
    public double getArea(){       
        return Math.pow(this.getRadius(), 2) * Math.PI;
    }
    public double getPerimeter(){        
        return 2 * Math.PI * this.getRadius();
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Metodes Statics">
    public static int getNumCircle() {
        return numCircle;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Override, Sobreescritura de metodos heredados">
   
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Circle\n");
        sb.append("-------------\n");
        sb.append(String.format("-Radio: %2.f cm\n", this.getRadius()));
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Circle)) {
            return false;
        }
        Circle other = (Circle)obj;
        return (this.getRadius() == other.getRadius());
    }

    @Override
    public int hashCode() {
        return String.format("%f", this.getRadius()).hashCode();
    }
   
//</editor-fold>
    
    //</editor-fold>

    
}
