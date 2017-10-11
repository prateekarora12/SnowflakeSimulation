/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.cacrystal;

import static edu.neu.csye6200.cacrystal.Assignment5.genNum;
import static edu.neu.csye6200.cacrystal.Assignment5.stopValue;
import static edu.neu.csye6200.cacrystal.Assignment5.pauseValue;
import static edu.neu.csye6200.cacrystal.Assignment5.ruleNum;
import static edu.neu.csye6200.cacrystal.Assignment5.ruleNum1;
import java.util.ArrayList;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author prateekarora
 */



public class CAFlakeSet extends Observable implements Runnable{

  ArrayList<CAFlake> flakeList;
  
  private int generationNum;
  public static int currentFlakeValue ; 
  //public static 
  
    
  public CAFlakeSet(){
      
      flakeList = new ArrayList<CAFlake>();
      
      
  }
  
  public CAFlakeSet(int ruleNum, int generationNum){
      flakeList = new ArrayList<CAFlake>();
      
      this.generationNum = generationNum;
  }
  
  
  


    @Override
    public void run() {
       // int genNum = 
       CARule carule = new CARule();
      CAFlake firstF = new CAFlake();
      generationNum = genNum;
      
      int timerSpeed = 200;
      if(ruleNum1 == 1){
          timerSpeed = 100;
      }
      else if(ruleNum1 == 2){
          timerSpeed = 200;
      }
      else if(ruleNum1 == 3){
          timerSpeed = 300;
      }
      
      
     
      
      firstF.getInitialFlake();
      flakeList.add(firstF);
      
      //firstF.displayFlake();
      
      
      if(ruleNum == 1){
      CAFlake newflake = carule.getNextFlake(firstF); 
      for(int i=0;i<generationNum;i++){ 
          CAFlake newflake2 = carule.getNextFlake(newflake);
          if(pauseValue == true){
              newflake2 = carule.getNextFlake(flakeList.get(currentFlakeValue));
          }
        
        if(stopValue == false ){
        setChanged();
        notifyObservers(newflake2);
           try {
               Thread.sleep(timerSpeed);
           } catch (InterruptedException ex) {
               Logger.getLogger(CAFlakeSet.class.getName()).log(Level.SEVERE, null, ex);
           }
        flakeList.add(newflake2);
       currentFlakeValue = flakeList.size()-1;
        newflake = newflake2;
        }
      }
      }
      else if(ruleNum == 2){
      CAFlake newflake = carule.getNextFlake2(firstF); 
      for(int i=0;i<generationNum;i++){ 
          CAFlake newflake2 = carule.getNextFlake2(newflake);
          if(pauseValue == true){
              newflake2 = carule.getNextFlake2(flakeList.get(currentFlakeValue));
          }
        
        if(stopValue == false ){
        setChanged();
        notifyObservers(newflake2);
           try {
               Thread.sleep(timerSpeed);
           } catch (InterruptedException ex) {
               Logger.getLogger(CAFlakeSet.class.getName()).log(Level.SEVERE, null, ex);
           }
        flakeList.add(newflake2);
       currentFlakeValue = flakeList.size()-1;
        newflake = newflake2;
        }
      }
      
      }
      else if(ruleNum == 3){
      CAFlake newflake = carule.getNextFlake3(firstF); 
      for(int i=0;i<generationNum;i++){ 
          CAFlake newflake2 = carule.getNextFlake3(newflake);
          if(pauseValue == true){
              newflake2 = carule.getNextFlake3(flakeList.get(currentFlakeValue));
          }
        
        if(stopValue == false ){
        setChanged();
        notifyObservers(newflake2);
           try {
               Thread.sleep(timerSpeed);
           } catch (InterruptedException ex) {
               Logger.getLogger(CAFlakeSet.class.getName()).log(Level.SEVERE, null, ex);
           }
        flakeList.add(newflake2);
       currentFlakeValue = flakeList.size()-1;
        newflake = newflake2;
        }
      }
      
      }
              
    
      }
    
      
      
    
}
    
      
      
      
   
    
    
    
    
    
    