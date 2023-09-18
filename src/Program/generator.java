package Program;

import java.awt.Color;
import java.util.Random;

public class generator extends Thread{
	
	private Svemir svemir;
	private boolean pauzirano = false;
	public generator(Svemir e) 
	{
		svemir = e;
	}
	
	@Override
	public void run() {
		try {
			while(!isInterrupted()) {
				
				synchronized (this) {
					while(pauzirano) wait();
				}
				
				int x  = (int)(Math.random() * 200);
				int y = 0;
				int poluprecnik = (int)(Math.random()*(30-10) + 10);
				
				NebeskoTelo t;
				if(new Random().nextInt(4) == 0) t = new Planeta(x, y, poluprecnik);
				else t = new Kometa(x, y, poluprecnik);
				svemir.dodaj(t);
				sleep(900);
			}
		} catch (InterruptedException e) {}
	}
	
	public void pauziraj() { pauzirano = true; }
	
	public synchronized void nastavi() { pauzirano = false; notify(); }

	public synchronized void stani() {
		interrupt();
	}
}
