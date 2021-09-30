package zeldaminiclone;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable, KeyListener{
	
	public static int WIDTH = 640, HEIGHT = 480; //Tamanho da janela ao iniciar o jogo
	public static int SCALE = 3; //Redimensiona a janela
	public static Player player; //Instancia a classe Player
	public List<Inimigo> inimigos = new ArrayList<Inimigo>();
	public World world; // Instancia a Classe World
	
	
	public Game() {
		this.addKeyListener(this); // adicionar eventos de teclado
		this.setPreferredSize(new Dimension( WIDTH, HEIGHT ));
		new Spritesheet(); // Inicia a sprite no jogo
		player = new Player(30,30);
		world = new World();
		inimigos.add(new Inimigo(32,32));
		inimigos.add(new Inimigo(32,64));
	}
	
	public void tick() { //Verifica colisão com o player e remove o bloco que foi colocado aleatorio
		player.tick(); //invoca o metodo player.tick

		for(int i = 0; i < inimigos.size(); i++){
			inimigos.get(i).tick();
		}
	} 
	
	public void render() { // metodo para realizar a renderizacao do jogo.
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(new Color(0, 135, 13)); // Metodo para preencher o backgroud com cor
		g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE); //metodo para exibir o backgroud na interface da tela.
		
		player.render(g); // renderiza o player
		player.render(g);
		for(int i = 0; i < inimigos.size(); i++){ //renderiza os inimigos
			inimigos.get(i).render(g);
		}
		world.render(g); //renderizao mapa
		
		bs.show(); //Exibe o conteudo do jogo dentro da interface grafica
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
		if(e.getKeyCode() == KeyEvent.VK_A){
			player.shoot = true;
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