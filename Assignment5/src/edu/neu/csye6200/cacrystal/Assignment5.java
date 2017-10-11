
package edu.neu.csye6200.cacrystal;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import static java.lang.Integer.parseInt;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class Assignment5 extends CAApp {

	private static Logger log = Logger.getLogger(Assignment5.class.getName());

	protected JPanel northPanel = null;
	protected JButton startBtn = null;
	protected JButton stopBtn = null;
        protected JButton pauseBtn = null;
    private CACanvas caPanel = null;
    public JComboBox<String> comboboxRule=null;
    public JComboBox<String> comboboxRule1=null;
    private JTextField txtGenerationNum=null;
    private JLabel labelGenerationNum=null;
    public static int genNum = 28;
    public static boolean stopValue = false;
    public static boolean pauseValue = false;
    public static int ruleNum;
    public static int ruleNum1;
    
    
	
    /**
     * Sample app constructor
     */
    public Assignment5() {
        super.initGUI();
    	frame.setSize(1200, 1200);
		frame.setTitle("WolfApp");
		
    	caPanel = new CACanvas();
    	frame.add(caPanel, BorderLayout.CENTER); // Add to the center of our frame
		frame.setVisible(true); // The UI is built, so display it
    }
   

    public JPanel getNorthPanel() {
    	northPanel = new JPanel();
    	northPanel.setLayout(new FlowLayout());
    	
    	startBtn = new JButton("Start");
    	startBtn.addActionListener(this); // Allow the app to hear about button pushes
    	
//        pauseBtn = new JButton("Pause"); // Allow the app to hear about button pushes
//    	pauseBtn.addActionListener(this);
    	
    	stopBtn = new JButton("Stop"); // Allow the app to hear about button pushes
    	stopBtn.addActionListener(this);
    	
        
        
        comboboxRule = new JComboBox<>();
        comboboxRule1 = new JComboBox<>();
        labelGenerationNum = new JLabel("Number of Generations");
        txtGenerationNum=new  JTextField("28",3);
        comboboxRule.addItem("Select a rule");
        comboboxRule.addItem("Black and White");
        comboboxRule.addItem("Rainbow");
        comboboxRule.addItem("Grey");
        comboboxRule1.addItem("Select animation speed");
        comboboxRule1.addItem("Fast");
        comboboxRule1.addItem("Medium");
        comboboxRule1.addItem("Slow");
        northPanel.add(comboboxRule);
        northPanel.add(labelGenerationNum);
        northPanel.add(txtGenerationNum);
        northPanel.add(comboboxRule1);
        northPanel.add(startBtn);
        //northPanel.add(pauseBtn);
        northPanel.add(stopBtn);
    	return northPanel;
 
    }
    
    public String gettxtGenerationNum(){
        return txtGenerationNum.getText();
    }
    
	@Override
	public void actionPerformed(ActionEvent ae) {
		log.info("We received an ActionEvent " + ae);
		if (ae.getSource() == startBtn){
                    stopValue = false;
                    pauseValue = false;
                    ruleNum = comboboxRule.getSelectedIndex();
                    ruleNum1 = comboboxRule1.getSelectedIndex();
                   genNum = parseInt(txtGenerationNum.getText());
                        CAFlakeSet set = new CAFlakeSet();
                        set.addObserver(caPanel);
                        frame.add(caPanel, BorderLayout.CENTER);
                        Runnable r =set;
                        Thread t = new Thread(r);
                        t.start();
                    
                        
                        
                }
                else if(ae.getSource() == stopBtn){
			System.out.println("Stop pressed");
                        stopValue = true;
                        
                }
                
	}

	@Override
	public void windowOpened(WindowEvent e) {
		log.info("Window opened");
	}



	@Override
	public void windowClosing(WindowEvent e) {	
	}



	@Override
	public void windowClosed(WindowEvent e) {
	}



	@Override
	public void windowIconified(WindowEvent e) {
		log.info("Window iconified");
	}



	@Override
	public void windowDeiconified(WindowEvent e) {	
		log.info("Window deiconified");
	}



	@Override
	public void windowActivated(WindowEvent e) {
		log.info("Window activated");
	}



	@Override
	public void windowDeactivated(WindowEvent e) {	
		log.info("Window deactivated");
	}
	
	/**
	 * Sample Wolf application starting point
	 * @param args
	 */
	public static void main(String[] args) {
		Assignment5 app = new Assignment5();
		log.info("Assignment5 started");
                
	}
}
