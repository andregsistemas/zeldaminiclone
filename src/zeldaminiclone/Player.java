package zeldaminiclone;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends Rectangle{
	
	public int spd = 4; //spd = speed de velocidade de movimenta��o do Player pelo mapa
	public boolean right, up, down, left; //Vari�veis de controle do Player
	
	public Player(int x, int y) { //M�todo para movimenta��o do personagem na Interface di jogo.
		super(x, y, 32, 32); //largura e altura do player
	}
	public void tick() { //M�todo de controle do Player
		if(right) {
			x+=spd;
		}else if(left) {
			x-=spd;
		}
		
		if(up) {
			y-=spd;
		}else if(down) {
			y+=spd;
		}
		
	}
	
	public void render(Graphics g){
		g.setColor(Color.blue);
		g.fillRect(x, y, width, height);
	}

}
