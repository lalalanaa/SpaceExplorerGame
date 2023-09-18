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
	private Button pokreni = new Button("Pokreni!"), zaustavi = new Button("Zaustavi"), nastavi = new Button("Nastavi");
	
	private void populateWindow() {
		add(svemir,BorderLayout.CENTER);
		Panel south = new Panel();
		south.add(zaustavi);
		south.add(pokreni);
		south.add(nastavi);
		add(south, BorderLayout.SOUTH);
		zaustavi.setEnabled(false);
		nastavi.setEnabled(false);
		
		pokreni.addActionListener((ae)->{
			gen.start();
			svemir.kreni();
			pokreni.setEnabled(false);
			zaustavi.setEnabled(true);
			svemir.requestFocus();
		});
		
		zaustavi.addActionListener((ae)->{
			gen.pauziraj();
			svemir.pauziraj();
			zaustavi.setEnabled(false);
			nastavi.setEnabled(true);
			svemir.requestFocus();
		});
		
		nastavi.addActionListener((ae)->{
			gen.nastavi();
			svemir.nastavi();
			zaustavi.setEnabled(true);
			nastavi.setEnabled(false);
			svemir.requestFocus();
		});
	}
	
	public Simulator() {
		setBounds(500, 150, 200,400);
		setResizable(false);
		
		svemir = new Svemir(this);
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
	
	public void kraj()
	{
		svemir.stani();
		gen.stani();
		zaustavi.setEnabled(false);
		nastavi.setEnabled(false);
	}
	
	
	public static void main(String[] args) {
		new Simulator();
	}
}
