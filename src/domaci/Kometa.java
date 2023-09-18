package Program;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Random;

public class Kometa extends NebeskoTelo {
	int rand;
	
	public Kometa(int a, int b, Color col, int c) {
		super(a, b, col, c);
		rand = new Random().nextInt(10000);
	}
	public int getX(double a) {
		return (int)(poluprecnik*Math.cos(a));
	}
	
	public int getY(double a) {
		return (int)(poluprecnik*Math.sin(a));
	}

	@Override
	public void iscrtaj(Graphics e) {
		e.setColor(Color.GRAY);
		Polygon p = new Polygon();
		
		for (double i = rand;i < 2*Math.PI+rand;i+=(2*Math.PI/5)) {
			p.addPoint((int)(x + this.getX(i)), (int)(y + getY(i)));
			}e.fillPolygon(p);
	}
	
}
