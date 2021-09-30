package zeldaminiclone;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Blocks extends Rectangle{

	public Blocks(int x, int y) {
		super(x, y, 30,30 );
	}
	
	public void render(Graphics g) {
		// Renderiza Bloco na cor Mangenta
		g.setColor(Color.magenta);
		g.fillRect(x, y, width, height);
		
		// Renderiza uma borda em preto no bloco mangenta
		g.setColor(Color.black);
		g.drawRect(x, y, width, height);
		
	}
	
}
