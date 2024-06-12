package entity;

import java.awt.*;
import javax.swing.ImageIcon;

import game.GamePanel; 


public class Boss extends Entity{
    public int healthPower = 1;
    public Boss(GamePanel gp, String fileName) {
        super(gp);
        setDefaultValues(fileName);
        name = "Boss";
    }
    
    void setDefaultValues(String fileName) {
        x = 9*gp.tileSize;
        y = 1*gp.tileSize;
        solidArea = new Rectangle();
        solidArea.x = 0;
        solidArea.y = 0;
        solidDefaultX = solidArea.x;
        solidDefaultY = solidArea.y;
        solidArea.width = 96;
        solidArea.height = 96;
        getImage(fileName);
        collisionOn = true;
    }

    void getImage(String fileName) {
        try {
            img = new ImageIcon(fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g){
        g.drawImage(img.getImage(), x, y, gp.tileSize*2, gp.tileSize*2, null);
    }

    int child = 2;
    public void update(){
        actionLockCounter++;
        if (actionLockCounter > 700) {
            for (int i = 0; i <= 15; i++)
            if (gp.NPC[i]==null){
                gp.aSetter.setNPC(i);
                child++;
                System.out.println("Set NPC: " + i);
                actionLockCounter = 0;
                break;
            }
        }
    }
}
