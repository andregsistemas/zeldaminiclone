package zeldaminiclone;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable, KeyListener{
	
	public static int WIDTH = 480, HEIGHT = 480;
	public Player player; //Instancia a classe Player
	public World world; // Instancia a Classe World
	
	
	public Game() {
		this.addKeyListener(this); // adicionar eventos de teclado
		this.setPreferredSize(new Dimension( WIDTH, HEIGHT ));
		new Spritesheet(); // Inicia a sprite no jogo
		player = new Player(30,30);
		world = new World();		
	}
	
	public void tick() { //M�todo responsavel pela l�gica do jogo, movimenta��o, colis�es, etc.
		player.tick(); //invoca o metodo player.tick
	} 
	
	public void render() { // m�todo para realizar a renderiza��o do jogo.
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black); // M�todo para setar a cor
		g.fillRect(0, 0, WIDTH, HEIGHT); //metodo para exibir um ret�ngulo na tela
		
		player.render(g);
		world.render(g);
		
		bs.show(); //Exibe na interface o ret�ngulo
	} 
	//Metodo contrutor da interface grafica
	
	public static void main (String[] args) {
		Game game = new Game();
		JFrame frame = new JFrame();
		
		frame.add(game);
		frame.setTitle("Mini Zelda");
		
		frame.pack();
		
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		
		new Thread(game).start();
		
	} 
	
	@Override
	public void run() {
		
		while(true) {
			tick();
			render();
			try {
				Thread.sleep(1000/60); //rodar o jogo a 60fps
			} catch (InterruptedException e) {
				e.printStackTrace(); //rotina de erro
			}
			
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.right = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT){
			player.left = true;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			player.up = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.down = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.right = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT){
			player.left = false;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			player.up = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.down = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}