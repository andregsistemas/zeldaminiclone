package zeldaminiclone;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Spritesheet{

    public static BufferedImage spritesheet;

    public static BufferedImage player_front;
    
    //Carregar spritesheet (Imagem em Sprites)
    public Spritesheet(){
        try {
            spritesheet = ImageIO.read(getClass().getResource("/spritesheet.png"));
        } catch (IOException e) {
            
            e.printStackTrace();
        }

        player_front = Spritesheet.getSprite(1, 11, 16, 15);

    }

    private static BufferedImage getSprite(int x, int y, int width, int height) {
        return spritesheet.getSubimage(x, y, width, height);
    }
}