package Maufgabe1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ListenerDemo extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2488889547100219311L;
	private JButton btnOne, btnTwo, btnThree;
	private String actionBtnThree = "Schaltfläche 3";
	
	public ListenerDemo(){
		super("Beispiele für Listner");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//
		init();
		//
		this.pack();
		this.setVisible(true);
	}
	
	private void init(){
		JPanel btnPanel = new JPanel(new GridLayout(3,1));
		btnOne   = new JButton("Schatlfläche 1");
		btnTwo   = new JButton("Schaltfläche 2");
		btnThree = new JButton(actionBtnThree);
		//
		btnPanel.add(btnOne);
		btnPanel.add(btnTwo);
		btnPanel.add(btnThree);
		this.getContentPane().add(btnPanel, BorderLayout.CENTER);
		//
		/*
		 * Listener 1
		 * Ist als externe Klasse zu erstellen und der Schaltfläche btnOne zuzuordnen.
		 * Es ist der Text der Beschriftung im StdOut auszugeben.
		 * 
		 */
		btnOne.addActionListener(new ActionListenerClass());

		/*
		 * Listener 2 ist als Elementklasse zu erstellen und der Schaltfläche btnTwo zuzuordnen.
		 * Es ist der Text der Beschriftung im StdOut auszugeben.
		 * 
		 */
		btnTwo.addActionListener(new BtntwoListener());

		
		/*
		 * Listener 3 ist als anonyme Klasse zu erstellen und der Schaltfläche btnThree zuzuordnen.
		 * Es ist der Text der Beschriftung im StdOut auszugeben.
		 * 
		 */
		btnThree.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(actionBtnThree);
			}
		});
		
	}

	// Aufgabe 2
	class BtntwoListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(btnTwo.getText());
		}
	}
	
	public static void main(String[] args){
		new ListenerDemo();
	}
	
}
