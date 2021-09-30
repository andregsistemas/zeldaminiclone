package zeldaminiclone;

import java.awt.Color; //utilizado para colorir os blocos.
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends Rectangle{
	
	public int spd = 4; //spd = speed de velocidade de movimenta��o do Player pelo mapa
	public boolean right, up, down, left; //Vari�veis de controle do Player
	
	public Player(int x, int y) { //M�todo para movimenta��o do personagem na Interface do jogo.
		super(x, y, 32, 32); //largura e altura do player
	}
	public void tick() { //M�todo de controle do Player
		if(right && World.isFree(x+spd, y)) {
			x+=spd;
		}else if(left&& World.isFree(x-spd, y)) {
			x-=spd;
		}
		
		if(up && World.isFree(x, y-spd)) {
			y-=spd;
		}else if(down && World.isFree(x, y+spd)) {
			y+=spd;
		}
		
	}
	
	public void render(Graphics g){
		//g.setColor(Color.blue);
		//g.fillRect(x, y, width, height);
		g.drawImage(Spritesheet.player_front, x, y, 32, 32, null);
	}

}
