package fr.clement.view;

import javax.swing.JFrame;

public class MarmitonFrame extends JFrame{
	
	public MarmitonFrame() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.initFrame();
	}
	
	private void initFrame() {
		this.setSize(1200,700);
		this.setTitle("Pandemic Game");
		this.setLocation(20,20);
		
	}
}
