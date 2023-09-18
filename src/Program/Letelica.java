package Program;

import java.awt.Color;
import java.awt.Graphics;

public class Letelica extends Objekat{
	
	private int osnovica, visina;

	public Letelica(int a, int b, int osn, int vis) {
		super(a, b, Color.CYAN);
		osnovica = osn;
		visina = vis;
	}
	
	public boolean preklapaSe(NebeskoTelo n)
	{
		return osnovica/2 + visina + n.getR() < x - n.getX();
	}

	@Override
	public void iscrtaj(Graphics e) {
		
		e.setColor(color);
		int x[] = new int[3], y[] = new int[3];
		
		for(int i = 0; i < 3; i++)
		{
			x[i] = (int)(this.x + visina/2 * Math.cos((i+0.25) * 2 * Math.PI / 3));
			y[i] = (int)(this.y + visina/2 * Math.sin((i+0.25) * 2 * Math.PI / 3));
		}
		e.fillPolygon(x, y, 3);
	}

}
