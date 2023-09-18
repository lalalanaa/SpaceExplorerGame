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
	private boolean pauzirano = false, kraj = false;
	private Simulator owner;
	Boolean gameBoolean = true;
	Boolean pauseBoolean = false;
	private int istrazenost = 0;
	private Letelica l = new Letelica(90, 300, 40, 40);
	private Thread nit;
	private ArrayList<NebeskoTelo> tela = new ArrayList<>();
	
	public Svemir(Simulator o) 
	{
		nit = new Thread(this);
		owner = o;
		setBackground(Color.BLACK);
	}
	
	public void pauziraj() { pauzirano = true; }
	
	public void nastavi() { pauzirano = false; synchronized (nit) { nit.notify(); }}
	
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
				synchronized (nit) { while(pauzirano) nit.wait(); }
				istrazenost++;
				pomeri(5);
				for(NebeskoTelo n : tela)
				{
					if(n instanceof Planeta && l.preklapaSe(n)) istrazenost += 100;
					else if(n instanceof Kometa && l.preklapaSe(n)) { kraj = true; repaint(); owner.kraj(); }
				}
				repaint();
				nit.sleep(100);
			}
		}catch (InterruptedException e) {}
	}
	
	@Override
	public void paint(Graphics e) {
		for(NebeskoTelo t : tela)
			t.iscrtaj(e);
		l.iscrtaj(e);
		Color staro = e.getColor();
		e.setColor(Color.red);
		if(kraj)
			e.drawString("KRAJ", 87, 30);
		e.setColor(staro);
		e.setColor(Color.white);
		e.setFont(new Font("Arial", 12, Font.BOLD));
		e.drawString(istrazenost + "", 92, 10);
		e.setColor(staro);
	}
	
	public synchronized void pomeri(int y) 
	{
		for (int i = 0; i < tela.size(); i++) {
			tela.get(i).setY(y);
		}
	}
	
	public synchronized void kreni()
	{
		nit.start();
		notifyAll();
	}
	public synchronized void stani() {
		nit.interrupt();
		notifyAll();
	}
	
	
}
