package Program;

import java.awt.Color;

public abstract class NebeskoTelo extends Objekat {
	int poluprecnik;
	
	public NebeskoTelo(int a, int b, Color col,int c) {
		super(a, b, col);
		poluprecnik = c;
	}
}
