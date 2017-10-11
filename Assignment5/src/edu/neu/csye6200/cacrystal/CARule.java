package edu.neu.csye6200.cacrystal;

import java.awt.Color;

/**
 *
 * @author prateekarora
 */
public class CARule {
     
    /**
     *
     */
    public static Color col;
    
    CAFlake flake = new CAFlake();
    
    CAFlakeCell[][] flakeList = flake.getInitialFlake();
    
    public CAFlakeCell getUpperCell(int x, int y){ 
        if(y==0){return new CAFlakeCell(0,255,255,255);}
          return flakeList[x][y-1];
       }
   public CAFlakeCell getLowerCell(int x, int y){ 
       if(y==64){return new CAFlakeCell(0,255,255,255);}
          return flakeList[x][y+1];
       }
   public CAFlakeCell getLeftCell(int x, int y){
       if(x==0){return new CAFlakeCell(0,255,255,255);}
          return flakeList[x-1][y];
       }
   public CAFlakeCell getRightCell(int x, int y){ 
       if(x==64){return new CAFlakeCell(0,255,255,255);}
          return flakeList[x+1][y];
       }
   
   public CAFlakeCell getUpperCellList(int x, int y,CAFlakeCell[][] list){ 
        if(y==0){return new CAFlakeCell(0,255,255,255);}
          return list[x][y-1];
       }
   public CAFlakeCell getLowerCellList(int x, int y,CAFlakeCell[][] list){ 
       if(y==64){return new CAFlakeCell(0,255,255,255);}
          return list[x][y+1];
       }
   public CAFlakeCell getLeftCellList(int x, int y, CAFlakeCell[][] list){
       if(x==0){return new CAFlakeCell(0,255,255,255);}
          return list[x-1][y];
       }
   public CAFlakeCell getRightCellList(int x, int y,CAFlakeCell[][] list){ 
       if(x==64){return new CAFlakeCell(0,255,255,255);}
          return list[x+1][y];
       }
   
    
   public CAFlakeCell getNextCell(CAFlakeCell uppercell,CAFlakeCell lowercell, CAFlakeCell leftcell, CAFlakeCell rightcell){
        int count = 0;
        if (uppercell.getValue()==1){
            count ++;
        }
        if (leftcell.getValue()==1){
            count ++;
        }
        if (rightcell.getValue()==1){
            count ++;
        }
        if (lowercell.getValue()==1){
            count ++;
        }
        if (count == 1 || count == 3){
            return new CAFlakeCell(1,255,255,255);
        }
        return new CAFlakeCell(0,255,255,255);
       
   }
   
   
   
   
   public CAFlake getNextFlake(CAFlake currentFlake){
       CAFlake newFlake = new CAFlake();
       
       CAFlakeCell[][] nFlake = newFlake.getFlake();
       CAFlakeCell[][] cFlake = currentFlake.getFlake();
       col = Color.BLACK;
       for(int i = 0; i < cFlake.length; i++){
           for(int j = 0; j < cFlake[i].length; j++){
               CAFlakeCell currentCell = cFlake[i][j];
               if(currentCell.getValue() == 1){
                   nFlake[i][j] = new CAFlakeCell(1,0,0,0);
               }
               else{
                   CAFlakeCell upperCell = getUpperCellList(i, j, cFlake);
                   CAFlakeCell leftCell = getLeftCellList(i, j, cFlake);
                   CAFlakeCell underCell = getLowerCellList(i, j, cFlake);
                   CAFlakeCell rightCell = getRightCellList(i, j, cFlake);

                   nFlake[i][j] = getNextCell(upperCell,leftCell,underCell,rightCell);
               }
           }
       }
       return newFlake;
   }
   
   public CAFlake getNextFlake2(CAFlake currentFlake){
       CAFlake newFlake = new CAFlake();
       
       CAFlakeCell[][] nFlake = newFlake.getFlake();
       CAFlakeCell[][] cFlake = currentFlake.getFlake();
       for(int i = 0; i < cFlake.length; i++){
           for(int j = 0; j < cFlake[i].length; j++){
               int redVal = validColor(i*5);
                int greenVal = validColor(255-j*5);
                int blueVal = validColor((j*5)-(i*2));
               CAFlakeCell currentCell = cFlake[i][j];
               
               if(currentCell.getValue() == 1){
                   nFlake[i][j] = new CAFlakeCell(1,redVal,greenVal,blueVal);
               }
               else{
                   CAFlakeCell upperCell = getUpperCellList(i, j, cFlake);
                   CAFlakeCell leftCell = getLeftCellList(i, j, cFlake);
                   CAFlakeCell underCell = getLowerCellList(i, j, cFlake);
                   CAFlakeCell rightCell = getRightCellList(i, j, cFlake);

                   nFlake[i][j] = getNextCell(upperCell,leftCell,underCell,rightCell);
               }
           }
       }
       return newFlake;
   }
   
   public CAFlake getNextFlake3(CAFlake currentFlake){
       CAFlake newFlake = new CAFlake();
       
       CAFlakeCell[][] nFlake = newFlake.getFlake();
       CAFlakeCell[][] cFlake = currentFlake.getFlake();
       for(int i = 0; i < cFlake.length; i++){
           for(int j = 0; j < cFlake[i].length; j++){
               int redVal = validColor((j*5)/2 + (i*5)/2);
                int greenVal = validColor((j*5)/2 + (i*5)/2);
                int blueVal = validColor((j*5)/2 + (i*5)/2);
               CAFlakeCell currentCell = cFlake[i][j];
               if(currentCell.getValue() == 1){
                   nFlake[i][j] = new CAFlakeCell(1,redVal,greenVal,blueVal);
               }
               else{
                   CAFlakeCell upperCell = getUpperCellList(i, j, cFlake);
                   CAFlakeCell leftCell = getLeftCellList(i, j, cFlake);
                   CAFlakeCell underCell = getLowerCellList(i, j, cFlake);
                   CAFlakeCell rightCell = getRightCellList(i, j, cFlake);

                   nFlake[i][j] = getNextCell(upperCell,leftCell,underCell,rightCell);
               }
           }
       }
       return newFlake;
   }



   private int validColor(int colorVal) {
		if (colorVal > 255)
			colorVal = 255;
		if (colorVal < 0)
			colorVal = 0;
		return colorVal;
	}
   
   
   
   
//   public CAFlake nextFlake(CAFlake oldFlake){
// 
//       CAFlakeCell[][] oldList = oldFlake.getFlake();
//        for(int i =0;i<65;i++){ 
//           for(int j =0;j<65;j++){
//               if(flakeList[i][j].getValue() == 1){
//                   flakeList[i][j].setValue(1);
//               }
//               else if(this.getLowerCellList(i, j,oldList).getValue() == 1 && this.getRightCell(i, j).getValue() == 0){
//                   flakeList[i][j].setValue(1);
//               }
//               else if(this.getLowerCellList(i, j,oldList).getValue() == 1 && this.getRightCell(i, j).getValue() == 1){
//                   flakeList[i][j].setValue(0);
//               }
//               else if(this.getLowerCellList(i, j,oldList) == 0 && this.getRightCell(i, j).getValue() == 0 && this.getLeftCell(i, j).getValue() == 0 && this.getUpperCell(i, j).getValue() == 0){
//                   flakeList[i][j].setValue(0);
//               }
//               else if(this.getLowerCell(i, j).getValue() == 1 && this.getRightCell(i, j).getValue() == 1 && this.getLeftCell(i, j).getValue() == 1 && this.getUpperCell(i, j).getValue() == 1){
//                   flakeList[i][j].setValue(0);
//               }
//               else if(this.getLowerCell(i, j).getValue() == 1 && this.getRightCell(i, j).getValue() == 1 && this.getLeftCell(i, j).getValue() == 1 && this.getUpperCell(i, j).getValue() == 0){
//                   flakeList[i][j].setValue(1);
//               }
//               
//           }
//       
//        }
//        return flake;
//         
//   }
   
   
    
    
}
