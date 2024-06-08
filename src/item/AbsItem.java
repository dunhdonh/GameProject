package item;

import javax.swing.ImageIcon;

import game.GamePanel;

import java.awt.*;

public class AbsItem {
    public ImageIcon image;
    public String name;
    public boolean collision = false;
    public int x, y;

    public Rectangle solidArea = new Rectangle(0,0, 48, 48);
    public int solidDefaultX = 0, solidDefaultY = 0;


    public void draw(Graphics2D g, GamePanel gp) {
        g.drawImage(image.getImage(), x, y, gp.tileSize/2, gp.tileSize/2, null);
    }
}

