package zeldaminiclone;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Spritesheet{

    public static BufferedImage spritesheet;
    public static BufferedImage[] player;
    public static BufferedImage[] inimigo;
    public static BufferedImage tilewall;
    
    //Metodo para carregar spritesheet (Imagem em Sprites) da pasta res( Resources ).
    public Spritesheet(){
        try {
            spritesheet = ImageIO.read(getClass().getResource("/spritesheet.png"));
        } catch (IOException e) {
            
            e.printStackTrace();
        }

        player = new BufferedImage[2];
        inimigo = new BufferedImage[2];
        
        player[0] = Spritesheet.getSprite(1, 11, 16, 16);
        player[1] = Spritesheet.getSprite(19, 11, 16, 16);

        inimigo[0] = Spritesheet.getSprite(127, 224, 16, 16);
        inimigo[1] = Spritesheet.getSprite(145, 224, 16, 16);

        tilewall = Spritesheet.getSprite(320, 185, 16, 16);
    }

    private static BufferedImage getSprite(int x, int y, int width, int height) {
        return spritesheet.getSubimage(x, y, width, height);
    }
}