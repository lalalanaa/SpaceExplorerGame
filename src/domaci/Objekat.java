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
	abstract public void iscrtaj(Graphics e);
	
	public int distance(Objekat a,Objekat b) {
		double t = Math.pow((a.getX() - b.getY()), 2);
		t += Math.pow((a.getX() - b.getY()), 2);
		return (int)(t = Math.sqrt(t));
	}

}
