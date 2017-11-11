package weiqi;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

public class App extends JFrame {
	//private boolean dirty;
	private Board ba;
	
	private void handleEvents() {
		addWindowListener(new WindowAdapter() {
	        
	        public void windowClosing(WindowEvent e) {
	                // Terminate the program after the close button is clicked.
	                System.exit(0);
	        }
	});
	}
	
	public App() {
		super("WEIQI");
		handleEvents();
		ba = new Board();
		add(ba);
		pack();
		setVisible(true);
	}
}