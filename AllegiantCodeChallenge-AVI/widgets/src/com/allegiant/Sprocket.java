package com.allegiant;

import java.io.Serializable;

public class Sprocket implements Serializable  {

    private int id;
    private double price;
    private Color color;

    public Sprocket(int id, double price, Color color) {
    	this.id = id;
    	this.price = price;
    	this.color = color;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    @Override
    public boolean equals(Object o) {
    	if (o instanceof Sprocket) 
        {
    		Sprocket sprocketToComparteTo = (Sprocket) o;
          
    		return sprocketToComparteTo.id == this.id;
        }
        return false;
    }
}
