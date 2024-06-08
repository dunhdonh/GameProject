package entity;

import javax.swing.ImageIcon;
import java.awt.Rectangle;
import java.util.Random;

import game.GamePanel;

public class NPC_Monster extends Entity {
     public int healthPower;
    public NPC_Monster(GamePanel gp) {
        super(gp);
        setDefaultValues();
        name = "Monster";
    }

    public void setDefaultValues() {
        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 24;
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
            up1 = new ImageIcon("src/img/NPC/mon1.png");
            up2 = new ImageIcon("src/img/NPC/mon1.png");
            down1 = new ImageIcon("src/img/NPC/mon1.png");
            down2 = new ImageIcon("src/img/NPC/mon1.png");
            left1 = new ImageIcon("src/img/NPC/mon1.png");
            left2 = new ImageIcon("src/img/NPC/mon1.png");
            right1 = new ImageIcon("src/img/NPC/mon1.png");
            right2 = new ImageIcon("src/img/NPC/mon1.png");
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

}
