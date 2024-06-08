package entity;

import java.awt.*;
import javax.swing.ImageIcon;

import game.GamePanel; 


public class Boss extends Entity{
    public int healthPower = 10;
    public Boss(GamePanel gp) {
        super(gp);
        setDefaultValues();
        name = "Boss";
        getImage();
    }
    
    void setDefaultValues() {
        x = 9*gp.tileSize;
        y = 1*gp.tileSize;
        solidArea = new Rectangle();
        solidArea.x = 0;
        solidArea.y = 0;
        solidDefaultX = solidArea.x;
        solidDefaultY = solidArea.y;
        solidArea.width = 96;
        solidArea.height = 96;
        getImage();
        collisionOn = true;
    }

    void getImage() {
        try {
            img = new ImageIcon("src/img/NPC/boss-demo.png");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g){
        g.drawImage(img.getImage(), x, y, gp.tileSize*2, gp.tileSize*2, null);
    }
}
