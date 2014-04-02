package com.lferre.geoapp.entitieslayer;


public class Trapezium {

    
    //<editor-fold defaultstate="collapsed" desc="Atributs">
    private double minorBase;
    private double majorBase;
    private double height;
    private static int numTrapezium;
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Comportament">
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public double getMinorBase() {
        return this.minorBase;
    }

    public void setMinorBase(double minorBase) {
        if(minorBase<=0D){
            throw new IllegalArgumentException("ERROR: The minorBase can't be negative or zero");
        }
        if(this.majorBase!=0 && minorBase>=this.majorBase){
            throw new IllegalArgumentException("ERROR: The minorBase can't be equal or bigger than majorBase");
        }
        this.minorBase = minorBase;
    }

    public double getMajorBase() {
        return this.majorBase;
    }

    public void setMajorBase(double majorBase) {
        if(majorBase<=0D){
            throw new IllegalArgumentException("ERROR: The majorBase can't be negative or zero");
        }
        if(this.minorBase!=0 && majorBase<=this.minorBase){
            throw new IllegalArgumentException("ERROR: The majorBase can't be equal or smaller than minorBase");
        }
        this.majorBase = majorBase;
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
    public Trapezium(double minorBase, double majorBase, double height) {
        this.setMinorBase(minorBase);
        this.setMajorBase(majorBase);
        this.setHeight(height);
        numTrapezium++;
    }
    public Trapezium() {
        this(1.0D, 2.0D, 1.D);
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Metodes">
    public double getSide(){
        return Math.hypot(this.getHeight(), (this.getMajorBase() - this.getMinorBase())/2);
    }
    public double getArea(){
        return (this.getMajorBase() + this.getMinorBase())/2 * this.getHeight();
    }
    public double getPerimeter(){
        return 2*this.getSide() + this.getMajorBase() + this.getMinorBase();
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Metodes Statics">
    public static int getNumTrapezium() {
        return numTrapezium;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Override, Sobreescritura de metodos heredados">
   
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Trapezi\n");
        sb.append("-------------\n");
        sb.append(String.format("-Radio: %2.f cm\n", this.getMinorBase()));
        sb.append(String.format("-Radio: %2.f cm\n", this.getMajorBase()));  
        sb.append(String.format("-Altura: %2.f cm\n", this.getHeight()));
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Trapezium)) {
            return false;
        }
        Trapezium other = (Trapezium)obj;
        return (this.getMinorBase() == other.getMinorBase() && this.getHeight() == other.getHeight() && this.getMajorBase() == other.getMajorBase());
    }

    @Override
    public int hashCode() {
        return String.format("%f %f %f", this.getMinorBase(), this.getMajorBase(),this.getHeight()).hashCode();
    }
   
//</editor-fold>
//</editor-fold>
       
}
