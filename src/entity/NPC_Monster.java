package entity;

import javax.swing.ImageIcon;
import java.awt.Rectangle;
import java.util.Random;

import game.GamePanel;

public class NPC_Monster extends Entity {
    public NPC_Monster(GamePanel gp, int round) {
        super(gp);
        setDefaultValues(round);
        name = "Monster";
    }

    public void setDefaultValues(int round) {
        solidArea = new Rectangle();
        speed = 1;
        direction = "down";
        getImage(round);
        collisionOn = true;
    }

    public void getImage(int round) {
        try {
            switch (round) {
                case 1:
                    img = new ImageIcon("src/img/NPC/mon1.png");
                    solidArea.x = 6;
                    solidArea.y = 12;
                    solidDefaultX = solidArea.x;
                    solidDefaultY = solidArea.y;
                    solidArea.width = 32;
                    solidArea.height = 24;
                    break;
                case 2:
                    img = new ImageIcon("src/img/NPC/mon2.png");
                    solidArea.x = 4;
                    solidArea.y = 8;
                    solidDefaultX = solidArea.x;
                    solidDefaultY = solidArea.y;
                    solidArea.width = 40;
                    solidArea.height = 40;
                    break;
                case 3:
                    img = new ImageIcon("src/img/NPC/mon3.png");
                    solidArea.x = 4;
                    solidArea.y = 7;
                    solidDefaultX = solidArea.x;
                    solidDefaultY = solidArea.y;
                    solidArea.width = 44;
                    solidArea.height = 40;
                    break;
                case 4:
                    img = new ImageIcon("src/img/NPC/mon4.png");
                    solidArea.x = 0;
                    solidArea.y = 12;
                    solidDefaultX = solidArea.x;
                    solidDefaultY = solidArea.y;
                    solidArea.width = 48;
                    solidArea.height = 32;
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setAction() {

        actionLockCounter++;

        if (actionLockCounter == 120 || collisionOn == true) {
            Random random = new Random();
            int i = random.nextInt(100 + 1);
            if (i < 25) {
                direction = "up";
            } else if (i < 50) {
                direction = "down";
            } else if (i < 75) {
                direction = "left";
            } else {
                direction = "right";
            }
            actionLockCounter = 0;
        }

    }

    public void update() {
        setAction();
        collisionOn = false;
        gp.collCheck.checkTile(this);
        boolean contactPlayer = gp.collCheck.checkPlayer(this);
        gp.collCheck.checkEntity(this, gp.boss);
        // gp.collCheck.checkEntity(this, gp.NPC);

        if (contactPlayer == true && gp.player.invincible == false) { // nếu monster chạm vào player thì có thể tấn công
            gp.player.healthPower -= 1;
            healthPower -= 1;
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

}
