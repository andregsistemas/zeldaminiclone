package zeldaminiclone;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class World {
	
	public static List<Blocks> blocos = new ArrayList<Blocks>();
	
	//M�todo para rederizar Mapa
	public World() {
		for(int xx = 0; xx < 15; xx++) { //renderiza Blocos Superior
			blocos.add(new Blocks(xx*32, 0));
		}
		for(int xx = 0; xx < 15; xx++) {
			blocos.add(new Blocks(xx*32,480-32)); //Renderiza BLocos Inferior
		}
		for(int yy = 0; yy < 15; yy++) {
			blocos.add(new Blocks(0, yy*32)); //Renderiza Blocos a Esquerda
		}
		for(int yy = 0; yy < 15; yy++) {
			blocos.add(new Blocks(480-32, yy*32)); //Renderiza Blocos da Direita
		}
	}
	// Metodo de Colis�o
	public static boolean isFree(int x, int y) {
		for(int i = 0; i < blocos.size(); i++) {
			Blocks blocoAtual = blocos.get(i);
			if(blocoAtual.intersects(new Rectangle(x, y, 32, 32))) {
				return false;
			}
		}
		return true;
	}
			
	public void render(Graphics g) {
		for(int i = 0; i < blocos.size(); i++) {
			blocos.get(i).render(g);
		}
		
		
	}
	
	
}
