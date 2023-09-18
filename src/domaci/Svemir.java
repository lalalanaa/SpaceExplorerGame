package Program;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.management.InstanceNotFoundException;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

public class Svemir extends Canvas implements Runnable{
	private boolean flag = false;
	Boolean gameBoolean = true;
	Boolean pauseBoolean = false;
	int score = 0;
	private Thread nit;
	private ArrayList<NebeskoTelo> tela = new ArrayList<>();
	
	public Svemir() 
	{
		nit = new Thread(this);
		setBackground(Color.BLACK);
	}
	
	public void dodaj(NebeskoTelo a) 
	{
		tela.add(a);
		repaint();
	}
	
	@Override
	public void run() {
		try {
			while(!nit.isInterrupted()) 
			{
				pomeri(5);
				repaint();
				nit.sleep(100);
				
			}
		}catch (InterruptedException e) {}
	}
	
	public synchronized  void kreni()
	{	
		flag = true;
		nit.start();
		notifyAll();
	}
	public synchronized void stani() {
		nit.interrupt();
	
	}
	
	@Override
	public void paint(Graphics e) {
		for(NebeskoTelo t : tela)
			t.iscrtaj(e);
	}
	
	public synchronized void pomeri(int y) 
	{
		for (int i = 0; i < tela.size(); i++) {
			tela.get(i).setY(y);
		}
	}
}
