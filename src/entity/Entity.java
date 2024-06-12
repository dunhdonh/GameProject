package entity;

import javax.swing.ImageIcon;

import game.GamePanel;

import java.awt.*;


public class Entity {
    GamePanel gp;
    public int x, y;
    public int speed;
    public String name;
    public ImageIcon img = new ImageIcon();
    public ImageIcon up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;
    public int healthPower;


    public int spriteCounter = 0;
    public int spriteNum = 1;
    public boolean invincible = false;
    public int invincibleCounter = 0;

    public Rectangle solidArea;

    public int solidDefaultX, solidDefaultY;
    public boolean collisionOn = false;
    public int actionLockCounter = 0;

    Font arial_40;


    public Entity(GamePanel gp) {
        this.gp = gp;
        arial_40 = new Font("Arial", Font.PLAIN, 18);
        

    }

    public void setAction() {

    }

    public void draw(Graphics2D g) {
        g.setFont(arial_40);
        g.setColor(Color.WHITE);
        g.drawImage(img.getImage(), x, y, gp.tileSize, gp.tileSize, null);
        g.drawString(healthPower + "", x+20, y+8);
    }

}
