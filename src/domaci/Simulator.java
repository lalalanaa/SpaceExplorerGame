package Program;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Simulator extends Frame {
	protected Svemir svemir;
	protected generator gen;
	private Button dugme = new Button("Pokreni!");
	
	private void populateWindow() {
		add(svemir,BorderLayout.CENTER);
		add(dugme,BorderLayout.SOUTH);
		dugme.addActionListener((ae)->{
			gen.start();
			svemir.kreni();
			dugme.setEnabled(false);
			svemir.requestFocus();
		});
	}
	
	public Simulator() {
		setBounds(500,150,400,600);
		setResizable(false);
		
		svemir = new Svemir();
		svemir.requestFocus();
		gen = new generator(svemir);
		
		populateWindow();
		
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				dispose();
				svemir.stani();
				gen.stani();
			}
		});
		
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new Simulator();
	}
}
