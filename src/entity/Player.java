package entity;

import game.DragonBall;
import game.KeyHandle;

import java.awt.Graphics2D;
import javax.swing.*;
import java.awt.Rectangle;

public class Player extends Entity {

    DragonBall gp;
    KeyHandle keyHandle;

    int healthPower = 5;
    int attackPower = 0;

    public int getHealthPower() {
        return healthPower;
    }
    public int getAttackPower() {
        return attackPower;
    }
    public Player(DragonBall gp, KeyHandle keyHandle) {
        this.gp = gp;
        this.keyHandle = keyHandle;

        solidArea = new Rectangle();
        solidArea.x = 12;
        solidArea.y = 24;
        solidDefaultX = solidArea.x;
        solidDefaultY = solidArea.y;
        solidArea.width = 24;
        solidArea.height = 24;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        this.x = 24;
        this.y = 5*48;
        speed = 5;
        direction = "down";
    }

    public void getPlayerImage() {
        try {
            up1 = new ImageIcon("src/img/player/boy_up_1.png");
            up2 = new ImageIcon("src/img/player/boy_up_2.png");
            down1 = new ImageIcon("src/img/player/boy_down_1.png");
            down2 = new ImageIcon("src/img/player/boy_down_2.png");
            left1 = new ImageIcon("src/img/player/boy_left_1.png");
            left2 = new ImageIcon("src/img/player/boy_left_2.png");
            right1 = new ImageIcon("src/img/player/boy_right_1.png");
            right2 = new ImageIcon("src/img/player/boy_right_2.png");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (keyHandle.up || keyHandle.down || keyHandle.left || keyHandle.right) {
            if (keyHandle.up) {
                direction = "up";
            }
            if (keyHandle.down) {
                direction = "down";
            }
            if (keyHandle.left) {
                direction = "left";
            }
            if (keyHandle.right) {
                direction = "right";
            }

            // check tile collision
            collisionOn = false;
            gp.collCheck.checkTile(this);

            // check item collision
            int itemIndex = gp.collCheck.checkItem(this, true); 
            pickUpItem(itemIndex);

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
                        x = Math.min(gp.screenWidth - gp.tileSize, x);
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
    }

    public void pickUpItem(int index) {
        if (index != 999)  {
            String itemName = gp.item[index].name;

            switch(itemName) {
                case "Lucky":
                gp.playSoundEffect(2);
                if(healthPower < 5) {
                    healthPower++;
                    System.out.println("Health Power: " + healthPower);
                }
                    break;
                case "Coin":
                gp.playSoundEffect(1);
                if (attackPower < 10) {
                    attackPower++;
                    System.out.println("Attack Power: " + attackPower);
                }
                    break;
            }
            gp.item[index] = null;
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
