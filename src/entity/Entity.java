package entity;

import javax.swing.ImageIcon;
import java.awt.*;
public class Entity {
    public int x, y;
    public int speed;

    public ImageIcon up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;

    public Rectangle solidArea;

    public int solidDefaultX, solidDefaultY;
    public boolean collisionOn = false;
}