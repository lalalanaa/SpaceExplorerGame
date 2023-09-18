package Program;

import java.awt.*;

abstract public class Objekat {
	protected int x,y;
	protected Color color;
	
	public Objekat(int a,int b,Color col) {
		x = a;
		y = b;
		color = col;
	}
	public void setX(int a) {
		x+=a;
	}
	public void setY(int a) {
		y+=a;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public void setColor(Color c) { color = c; }
	
	abstract public void iscrtaj(Graphics e);
	
	public static double rastojanje(Objekat a, Objekat b) {
		return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
	}

}
