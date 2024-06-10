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

    public Entity(GamePanel gp) {
        this.gp = gp;
    }

    public void setAction() {

    }

    public void update() {
        setAction();
        collisionOn = false;
        gp.collCheck.checkTile(this);
        boolean contactPlayer = gp.collCheck.checkPlayer(this);
        gp.collCheck.checkEntity(this, gp.boss);
        gp.collCheck.checkEntity(this, gp.NPC);

        if (contactPlayer == true && invincible == false ) { // nếu monster chạm vào player thì có thể tấn công
            gp.player.healthPower -= 1;
            System.out.println("Health Power: " + gp.player.healthPower);
            gp.player.invincible = true;
            gp.player.invincibleCounter = 0;
        }
        // collitionOn = false -> can move
        if (collisionOn == false) {
            switch (direction) {
                case "up":
                    y -= speed;
                    y = Math.max(-24, y);
                    break;
                case "down":
                    y += speed;
                    y = Math.min(gp.screenHeight - gp.tileSize, y);
                    break;
                case "left":
                    x -= speed;
                    x = Math.max(0, x);
                    break;
                case "right":
                    x += speed;
                    x = Math.max(0, x);
                    break;
            }
        }
        spriteCounter++;
        if (spriteCounter > 12) {
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
    }

    public void draw(Graphics2D g) {
        ImageIcon img = null;
        switch (direction) {
            case "up":
                if (spriteNum == 1) {
                    img = up1;
                } else {
                    img = up2;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    img = down1;
                } else {
                    img = down2;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    img = left1;
                } else {
                    img = left2;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    img = right1;
                } else {
                    img = right2;
                }
                break;
        }
        g.drawImage(img.getImage(), x, y, gp.tileSize, gp.tileSize, null);
    }

}
