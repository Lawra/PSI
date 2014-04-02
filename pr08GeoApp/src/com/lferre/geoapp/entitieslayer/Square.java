package com.lferre.geoapp.entitieslayer;


public class Square {

    
    //<editor-fold defaultstate="collapsed" desc="Estat: Atributs">
    private double side;
    private static int numSquare;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Comportament: metodes">
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public double getSide() {
        return this.side;
    }

    public void setSide(double side) {
        if(side <= 0D){
            throw new IllegalArgumentException("ERROR: The side can't be negative or zero");
        }
        this.side = side;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Constructors">
    public Square(double side) {
        this.setSide(side);
        numSquare++;
    }
    public Square() {
        this(1.0D);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Metodes">
    public double getArea(){       
        return Math.pow(this.getSide(), 2);
    }
    public double getPerimeter(){        
        return this.getSide()*4;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Metodes statics">
    public static int getNumSquare() {
        return numSquare;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Estructures d'inicialització">
    static{
        System.out.println("Square.class -> me estoy cargando en memoria");
    }
    static{
        System.out.println("Soy el siguiente");
    }
    {
        System.out.println("Soy el objeto que acaba de nacer");
    }
    
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Override, Sobreescritura de metodos heredados">
   
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Square\n");
        sb.append("-------------\n");
        sb.append(String.format("-Side: %2.f cm\n", this.getSide()));
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Square)) {
            return false;
        }
        Square other = (Square)obj;
        return this.getSide() == other.getSide();
    }

    @Override
    public int hashCode() {
        return String.format("%f", this.getSide()).hashCode();
    }
   
//</editor-fold>
    
    //</editor-fold>

}
