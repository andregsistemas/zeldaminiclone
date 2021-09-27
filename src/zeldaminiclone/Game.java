package zeldaminiclone;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{
	
	public static int WIDTH = 480, HEIGHT = 480;
	
	public Game() {
		this.setPreferredSize(new Dimension( WIDTH, HEIGHT ));
		
	}
	
	public void tick() { //Método responsável pela lógica do jogo, movimentação, colisões, etc.
		
	} 
	
	public void render() { // método para realizar a renderização do jogo.
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black); // Método para setar a cor
		g.fillRect(0, 0, WIDTH, HEIGHT); //metodo para exibir um retângulo na tela
		
		g.setColor(Color.red);
		g.fillRect(0, 0, 50, 50);
		
		bs.show(); //Exibe na interface o retângulo
	} 
	
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

}
