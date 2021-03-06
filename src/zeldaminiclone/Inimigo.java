package zeldaminiclone;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Inimigo extends Rectangle{
	
	public int spd = 2; //spd = speed de velocidade de movimentacao do Player pelo mapa
	public int right = 1, up = 0, down = 0, left = 1; //Variaveis de controle do Inimigo
	public int curAnimation = 0;
	public int curFrames = 0, targetFrames = 15; // targetFrames = velocidade de atualizacao entre as Frames. 60 = 1 seg.
	public static List<Bullet> bullets = new ArrayList<Bullet>();
	public boolean shoot = false;
	public int dir = 1; //Variavel que armazenara a direcao do tiro.
	
	public Inimigo (int x, int y) { //Metodo para movimentacao do personagem na Interface do jogo.
		super(x, y, 32, 32); //largura e altura do Inimigo
	}
    public void perseguirPlayer(){

        Player p = Game.player;
    
            if( x < p.x && World.isFree(x + spd, y)){
                if(new Random().nextInt(100) < 50)
                x += spd;
    
            }else if( x > p.x && World.isFree(x -spd, y)){
                if(new Random().nextInt(100) < 50)
                x -= spd;
    
            }
    
            if(y < p.y && World.isFree(x, y + spd)){
    
                y += spd;
    
            }else if( y > p.y && World.isFree(x, y - spd)){
    
                y -= spd;
    
            }
    
        }

	public void tick() { //Metodo de controle do Inimigo

		boolean moved = true; //Variavel de controle se o player estiver parado não efetuar a animação.
        
        perseguirPlayer();

            
		if(moved){

			curFrames++;

		if (curFrames == targetFrames){
            
			curFrames = 0;
			curAnimation++;

			if(curAnimation == Spritesheet.inimigo.length){

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

		g.drawImage(Spritesheet.inimigo[curAnimation], x, y, 32, 32, null);
		for(int i = 0; i < bullets.size(); i++){
			bullets.get(i).render(g);
		}

	}

}