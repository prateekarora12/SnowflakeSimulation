package edu.neu.csye6200.cacrystal;

import static edu.neu.csye6200.cacrystal.CARule.col;
import java.util.logging.Logger;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;


public class CACanvas extends JPanel implements Observer{

	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(CACanvas.class.getName());
        private int cellSize = 11;
    private Color color = null;
    private long counter = 0L;
	private CAFlake currentFlake = null;
    /**
     * CellAutCanvas constructor
     */
	public CACanvas() {
		color = Color.WHITE;
                currentFlake = new CAFlake();
              //  currentFlake = currentFlake.getInitialFlake();
	}

        CAFlakeSet flakeset = new CAFlakeSet();
	/**
	 * The UI thread calls this method when the screen changes, or in response
	 * to a user initiated call to repaint();
	 */
	public void paint(Graphics g) {
                            System.out.println("repaint");

		drawCellularAutomaton(g); // Our Added-on drawing
    }
	
	/**
	 * Draw the CA graphics panel
	 * @param g
	 */
	public void drawCellularAutomaton(Graphics g) {
		log.info("Drawing cell automation " + counter++);
		Graphics2D g2d = (Graphics2D) g;
		Dimension size = getSize();
		
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, size.width, size.height);
		
		g2d.setColor(Color.RED);
		g2d.drawString("Snowflake Automaton 2D", 10, 15);
              
		CAFlakeCell[][] flake = currentFlake.flake;
		int maxRows = size.height / cellSize;
		int maxCols = size.width / cellSize;
		
                     for(int i = 0; i < flake.length; i++ ){
                        for( int j = 0; j < flake[0].length; j++){
                            col = new Color(flake[i][j].getColorRed(),flake[i][j].getColorGreen(), flake[i][j].getColorBlue());
                            if(flake[i][j].getValue()==1 ){
                             paintRect( g2d, i*cellSize, j*cellSize + 20, cellSize-1, col); 
                        }
                        else{
                             paintRect( g2d, i*cellSize, j*cellSize + 20, cellSize-1, Color.WHITE); 
                            }
                
                    }
                    
                        
                   }      
                           
			  
			  
		   
		
	}
	
	
	
	/*
	 * A convenience routine to set the color and paint a square
	 * @param g2d the graphics context
	 * @param x horizontal offset in pixels
	 * @param y vertical offset in pixels
	 * @param size the square size in pixels
	 * @param color the color to draw
	 */
	private void paintRect(Graphics2D g2d, int x, int y, int size, Color color) {
		g2d.setColor(color);
		g2d.fillRect(x, y, size, size);
	}

    @Override
    public void update(Observable o, Object arg) {
      
      this.repaint();
            this.currentFlake = (CAFlake)arg;
            System.out.println(currentFlake);
          
        
        
    }
	
}
