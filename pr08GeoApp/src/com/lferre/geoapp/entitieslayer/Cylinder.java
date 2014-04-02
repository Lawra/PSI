package com.lferre.geoapp.entitieslayer;


public class Cylinder {
    
    //<editor-fold defaultstate="collapsed" desc="Atributs">
    private double radius;
    private double height;
    private static int numCylinder;
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Comportament">
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        if(radius<=0D){
            throw new IllegalArgumentException("ERROR: The radius can't be negative or zero");
        }
        this.radius = radius;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        if(height<=0D){
            throw new IllegalArgumentException("ERROR: The height can't be negative or zero");
        }
        this.height = height;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Constructors">
    public Cylinder(double radius, double height) {
        this.setRadius(radius);
        this.setHeight(height);
        numCylinder++;
    }
    public Cylinder() {
        this(1.0D, 1.0D);
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Metodes">
    public double getArea(){
        return (2 * Math.PI * this.getRadius() * this.getHeight()) + (2 * Math.PI * Math.pow(this.getRadius(), 2));
    }
    public double getVolume(){
        return Math.PI * Math.pow(this.getRadius(), 2) * this.getHeight();
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Metodes Statics">
    public static int getNumCylinder() {
        return numCylinder;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Override, Sobreescritura de metodos heredados">
   
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cylinder\n");
        sb.append("-------------\n");
        sb.append(String.format("-Radio: %2.f cm\n", this.getRadius()));
        sb.append(String.format("-Altura: %2.f cm\n", this.getHeight()));
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Cylinder)) {
            return false;
        }
        Cylinder other = (Cylinder)obj;
        return (this.getRadius() == other.getRadius() && this.getHeight() == other.getHeight());
    }

    @Override
    public int hashCode() {
        return String.format("%f %f", this.getRadius(),this.getHeight()).hashCode();
    }
   
//</editor-fold>
//</editor-fold>
}
