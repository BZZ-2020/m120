package L_N1_2;

import java.util.*;
import javax.swing.*;
import java.awt.*;

/*
 * Die Klasse OutputView ist ein Observer, der auf ein Zahlen-Objekt
 * wartet. Die Klasse meldet sich bei der Instanzierung beim Subject an.
 * 
 * Der Wert wird in der Anzeige ausgegeben.
 */
public abstract class OutputView extends JFrame implements Observer{

	static int xPos, yPos=50, xDelta = 100, yDelta = 75;
	protected JLabel outValue;
	
	public OutputView(Observable o){
		super("Ausgabe");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		o.addObserver(this);
		
		init();
		
		this.pack();
		Dimension d = this.getPreferredSize();
		this.setSize(new Dimension(300, (int)d.getHeight()));
		this.setVisible(true);
		
		xPos += xDelta;
		yPos += yDelta;
		this.setLocation(xPos, yPos);
	}
	
	
	private void init(){
		outValue = new JLabel("value");
		this.getContentPane().add(outValue, BorderLayout.CENTER);
	}
}
