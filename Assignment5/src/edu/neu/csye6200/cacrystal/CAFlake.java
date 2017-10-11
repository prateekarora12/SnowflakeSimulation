
package edu.neu.csye6200.cacrystal;
/**
 *
 * @author prateekarora
 */
public class CAFlake {

    CAFlakeCell[][] flake;
   private  int x;
   private int y;
    
    public CAFlake(){
        flake = new CAFlakeCell[65][65];
        for(int i = 0; i < flake.length; i++ ){
            for( int j = 0; j < flake[0].length; j++){
                flake[i][j] = new CAFlakeCell(0,0,0,0);
            }
        }
    }
    
    public CAFlakeCell[][] getInitialFlake(){
       
       for(int i=0;i<65;i++){
           for(int j=0;j<65;j++){
               flake[i][j] = new CAFlakeCell(0,0,0,0);    
           }
       }
      
       
       flake[32][32].setValue(1);
        return flake;
    }
    
    public CAFlakeCell[][] getFlake(){
        return flake;
    }
    
    public CAFlakeCell getFlakeviaCoordinates(int x, int y){
       return this.getFlake()[x][y];
    }

    public void setFlake(CAFlakeCell[][] flake) {
        this.flake = flake;
    }
    
    

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
 public void displayFlake(){
     
        for(int i = 0; i < flake.length; i++ ){
            for( int j = 0; j < flake[0].length; j++){
                if(flake[i][j].getValue()==1 ){
                    System.out.print("■ ");
                }
                else{
                    System.out.print("□ ");
                }
                
            }
            System.out.println();
        }
 }
   
    
    
 
}
