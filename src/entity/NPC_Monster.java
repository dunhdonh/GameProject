package entity;

import javax.swing.ImageIcon;
import java.awt.Rectangle;
import java.util.Random;

import game.GamePanel;

public class NPC_Monster extends Entity {
    public NPC_Monster(GamePanel gp) {
        super(gp);
        setDefaultValues();
        name = "Monster";
    }

    public void setDefaultValues() {
        solidArea = new Rectangle();
        solidArea.x = 6;
        solidArea.y = 12;
        solidDefaultX = solidArea.x;
        solidDefaultY = solidArea.y;
        solidArea.width = 32;
        solidArea.height = 24;
        speed = 1;
        direction = "down";
        getImage();
        collisionOn = true;
    }

    public void getImage() {
        try {
            up1 = new ImageIcon("src/img/NPC/Mini-boss-02.png");
            up2 = new ImageIcon("src/img/NPC/Mini-boss-02.png");
            down1 = new ImageIcon("src/img/NPC/Mini-boss-02.png");
            down2 = new ImageIcon("src/img/NPC/Mini-boss-02.png");
            left1 = new ImageIcon("src/img/NPC/Mini-boss-02.png");
            left2 = new ImageIcon("src/img/NPC/Mini-boss-02.png");
            right1 = new ImageIcon("src/img/NPC/Mini-boss-02.png");
            right2 = new ImageIcon("src/img/NPC/Mini-boss-02.png");
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
        //gp.collCheck.checkEntity(this, gp.NPC);

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

}
