package game;

import entity.NPC_Monster;
import entity.Boss;
import item.Coin;
import item.Lucky;

public class AssetSetter {
    GamePanel gp;
    
    public AssetSetter (GamePanel gp){
        this.gp = gp;
    }

    public void setItem(){
        gp.item[0] = new Coin();
        gp.item[0].x = 10 * gp.tileSize + gp.tileSize/4;
        gp.item[0].y = 5 * gp.tileSize + gp.tileSize/4;

        gp.item[1] = new Coin();
        gp.item[1].x = 10 * gp.tileSize + gp.tileSize/4;
        gp.item[1].y = 6 * gp.tileSize + gp.tileSize/4;

        gp.item[2] = new Coin();
        gp.item[2].x = 10 * gp.tileSize + gp.tileSize/4;
        gp.item[2].y = 7 * gp.tileSize + gp.tileSize/4;

        gp.item[3] = new Lucky();
        gp.item[3].x = 6 * gp.tileSize + gp.tileSize/4;
        gp.item[3].y = 6 * gp.tileSize + gp.tileSize/4;
    }

    public void setNPC(int i){
        gp.NPC[i] = new NPC_Monster(gp);
        gp.NPC[i].x = 72;
        gp.NPC[i].y = 96;
        gp.NPC[i].healthPower = 3;
    }

    public void setBoss(){
        gp.boss[0] = new Boss(gp);
    }
}
