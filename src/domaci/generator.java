package Program;

import java.awt.Color;
import java.util.Random;

public class generator extends Thread{
	
	private Svemir svemir;
	protected boolean flag = false;
	public generator(Svemir e) 
	{
		svemir = e;
	}
	
	@Override
	public void run() {
		try {
			while(!isInterrupted()) {
				
				int x  = (int)(Math.random()*200);
				int y = 0;
				int poluprecnik = (int)(Math.random()*(30-10) + 10);
				
				NebeskoTelo t = new Kometa(x,y,Color.GRAY,poluprecnik);
				svemir.dodaj(t);
				sleep(900);
			}
		} catch (InterruptedException e) {}
	}

	public synchronized void stani() {
		interrupt();
	}
}
