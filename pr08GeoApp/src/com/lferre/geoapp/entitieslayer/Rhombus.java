package com.lferre.geoapp.entitieslayer;


public class Rhombus {

//<editor-fold defaultstate="collapsed" desc="Atributs">
    private double xAxis;
    private double yAxis;
    private static int numRhombus;
//</editor-fold>

  //<editor-fold defaultstate="collapsed" desc="Metodes">
    
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public double getXAxis() {
        return this.xAxis;
    }

    public void setXAxis(double xAxis) {
        if(xAxis <= 0D){
            throw new IllegalArgumentException("ERROR: The xAxis can't be negative or zero");
        }
        this.xAxis = xAxis;
    }

    public double getYAxis() {
        return this.yAxis;
    }

    public void setYAxis(double yAxis) {
        if(yAxis <= 0D){
            throw new IllegalArgumentException("ERROR: The yAxis can't be negative or zero");
        }
        this.yAxis = yAxis;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Constructors">
    public Rhombus(double xAxis, double yAxis) {
        this.setXAxis(xAxis);
        this.setYAxis(yAxis);
        numRhombus++;
    }
    public Rhombus() {
        this(1.0D, 1.0D);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="metodes">
    public double getSide(){
        return Math.hypot(this.getXAxis()/2D, this.getYAxis()/2D);
    }
    public double getPerimeter(){
        return this.getSide() * 4;
    }
    public double getArea(){
        return this.getXAxis() * this.getYAxis() / 2;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Metodes Statics">
    public static int getNumRhombus() {
        return numRhombus;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Override, Sobreescritura de metodos heredados">
   
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rhombus\n");
        sb.append("-------------\n");
        sb.append(String.format("-xAxis: %2.f cm\n", this.getXAxis()));
        sb.append(String.format("-yAxis: %2.f cm\n", this.getYAxis()));
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Rhombus)) {
            return false;
        }
        Rhombus other = (Rhombus)obj;
        return (this.getXAxis() == other.getXAxis() && this.getYAxis() == other.getYAxis());
    }

    @Override
    public int hashCode() {
        return String.format("%f %f", this.getXAxis(),this.getYAxis()).hashCode();
    }
   
//</editor-fold>
    
//</editor-fold>
 
}
