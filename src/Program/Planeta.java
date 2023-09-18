package Program;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Planeta extends NebeskoTelo {
	
	private boolean krug = false;

	public Planeta(int a, int b, int c) {
		super(a, b, Color.GREEN, c);
		int br = new Random().nextInt(2);
		if(br == 0) krug = true;
		br = new Random().nextInt(4);
		if(br == 1) setColor(Color.RED);
		else if(br == 2) setColor(Color.YELLOW);
		else if(br == 3) setColor(Color.BLUE);
		
	}

	@Override
	public void iscrtaj(Graphics e) {
		e.setColor(color);
		e.fillOval(x, y, poluprecnik, poluprecnik);
		if(krug)
			e.drawOval(x - poluprecnik/2, y - poluprecnik/2, 2*poluprecnik,  2*poluprecnik);
	}
}