package entity;

import java.awt.*;
import javax.swing.ImageIcon;

import game.GamePanel;

public class Boss extends Entity {
    public int healthPower;

    public Boss(GamePanel gp, int round) {
        super(gp);
        setDefaultValues(round);
        name = "Boss";
    }

    void setDefaultValues(int round) {
        healthPower = round * 3;
        solidArea = new Rectangle();
        switch (round) {
            case 1:
                x = 1 * gp.tileSize;
                y = 7 * gp.tileSize;
                getImage("src/img/NPC/boss1.png");
                solidArea.x = 0;
                solidArea.y = 0;
                solidDefaultX = solidArea.x;
                solidDefaultY = solidArea.y;
                solidArea.width = 96;
                solidArea.height = 96;
                break;

            case 2:
                x = 7 * gp.tileSize;
                y = 9 * gp.tileSize;
                getImage("src/img/NPC/boss2.png");
                solidArea.x = 0;
                solidArea.y = 24;
                solidDefaultX = solidArea.x;
                solidDefaultY = solidArea.y;
                solidArea.width = 96;
                solidArea.height = 60;
                break;

            case 3:
                x = 9 * gp.tileSize;
                y = 1 * gp.tileSize;
                getImage("src/img/NPC/boss3.png");
                solidArea.x = 0;
                solidArea.y = 20;
                solidDefaultX = solidArea.x;
                solidDefaultY = solidArea.y;
                solidArea.width = 96;
                solidArea.height = 76;
                break;

            case 4:
                x = 7 * gp.tileSize;
                y = 5 * gp.tileSize;
                getImage("src/img/NPC/boss4.png");
                solidArea.x = 0;
                    solidArea.y = 24;
                    solidDefaultX = solidArea.x;
                    solidDefaultY = solidArea.y;
                    solidArea.width = 96;
                    solidArea.height = 68;
                break;
        }

        collisionOn = true;
    }

    void getImage(String fileName) {
        try {
            img = new ImageIcon(fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g) {
        g.setFont(arial_40);
        g.setColor(Color.WHITE);
        g.drawImage(img.getImage(), x, y, gp.tileSize * 2, gp.tileSize * 2, null);
        g.drawString(healthPower + "", x + 43, y + 8);
    }

    int child = 2;

    public void update() {
        actionLockCounter++;
        if (actionLockCounter > 400) {
            for (int i = 0; i <= 15; i++)
                if (gp.NPC[i] == null) {
                    gp.aSetter.setNPC(i, gp.round);
                    child++;
                    System.out.println("Set NPC: " + i);
                    actionLockCounter = 0;
                    break;
                }
        }
    }
}
