package zeldaminiclone;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Player extends Rectangle{
	
	public int spd = 4; //spd = speed de velocidade de movimentacao do Player pelo mapa
	public boolean right, up, down, left; //Variaveis de controle do Player
	public int curAnimation = 0;
	public int curFrames = 0, targetFrames = 15; // targetFrames = velocidade de atualizacao entre as Frames. 60 = 1 seg.
	public static List<Bullet> bullets = new ArrayList<Bullet>();
	public boolean shoot = false;
	public int dir = 1; //Variavel que armazenara a direcao do tiro.
	
	public Player(int x, int y) { //Metodo para movimentacao do personagem na Interface do jogo.
		super(x, y, 32, 32); //largura e altura do player
	}
	public void tick() { //Metodo de controle do Player

		boolean moved = false; //Variavel de controle se o player estiver parado não efetuar a animação.

		if(right && World.isFree(x+spd, y)) {
			x+=spd;
			moved = true;
			dir = 1;
		}else if(left&& World.isFree(x-spd, y)) {
			x-=spd;
			moved = true;
			dir = -1;
		}
		
		if(up && World.isFree(x, y-spd)) {
			y-=spd;
			moved = true;

		}else if(down && World.isFree(x, y+spd)) {
			y+=spd;
			moved = true;
		}

		if(moved){
				curFrames++;
			if (curFrames == targetFrames){
				curFrames = 0;
				curAnimation++;
				if(curAnimation == Spritesheet.player.length){
				curAnimation = 0;
				}
			}

		}
		if (shoot){
			shoot = false;
			bullets.add (new Bullet(x, y, dir));

		}
		
		for(int i = 0; i < bullets.size(); i++){
			bullets.get(i).tick();
		}
	}
	
	public void render(Graphics g){

		g.drawImage(Spritesheet.player[curAnimation], x, y, 32, 32, null);
		for(int i = 0; i < bullets.size(); i++){
			bullets.get(i).render(g);
		}

	}

}