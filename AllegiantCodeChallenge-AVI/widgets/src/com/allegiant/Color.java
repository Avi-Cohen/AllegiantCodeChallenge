package com.allegiant;

import java.io.Serializable;

public class Color implements Serializable  {
    private int red;
    private int blue;
    private int green;
    
    private double saturation;
    
    public Color(int red, int blue, int green) {
        this.red = red;
        this.blue = blue;
        this.green = green;
        
        double L;
        double maxRGB = max(red/255.0, green/255.0, blue/255.0);
        double minRGB = min(red/255.0, green/255.0, blue/255.0);
        L = 0.5*(maxRGB + minRGB);
        if(L < 1)
        	saturation = (maxRGB - minRGB)/(1-Math.abs(2*L-1));
        else 
        	if (L == 0)
        		saturation = 0;
    
        
    }

    
    
    
    public double getSaturation() {
    	return saturation;
    }

   
    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }
    
    public double max(double x, double y, double z) {
    	double max = Math.max(x, Math.max(y, z));
    	return max;
    }
    
    public double min(double x, double y, double z) {
    	double min = Math.min(x, Math.min(y, z));
    	return min;
    }
}
