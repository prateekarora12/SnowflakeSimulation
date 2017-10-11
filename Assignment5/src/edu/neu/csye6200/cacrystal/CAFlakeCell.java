/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.cacrystal;

/**
 *
 * @author prateekarora
 */
public class CAFlakeCell {
   
   private int value;
   private int colorRed;
   private int colorBlue;
   private int colorGreen;

    public int getColorRed() {
        return colorRed;
    }

    public void setColorRed(int colorRed) {
        this.colorRed = colorRed;
    }

    public int getColorBlue() {
        return colorBlue;
    }

    public void setColorBlue(int colorBlue) {
        this.colorBlue = colorBlue;
    }

    public int getColorGreen() {
        return colorGreen;
    }

    public void setColorGreen(int colorGreen) {
        this.colorGreen = colorGreen;
    }
   
   
   
    public CAFlakeCell(int value, int colorRed,int colorGreen, int colorBlue){
        this.value = value;
        this.colorBlue = colorBlue;
        this.colorGreen = colorGreen;
        this.colorRed = colorRed;
    }

    
    

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
}
