package game;

import java.util.Set;
import java.util.HashSet;
import entity.NPC_Monster;
import entity.Boss;
import item.Coin;
import item.Lucky;

public class AssetSetter {
    GamePanel gp;
    public Set<Integer> set = new HashSet<Integer>();
    public AssetSetter (GamePanel gp){
        this.gp = gp;
    }
    int k;

    public void setCoin(int i){

        do{
            k = gp.tileManager.getRandomReachableIndex();
        }while(set.contains(k));
        set.add(k);

        gp.item[i] = new Coin();
        gp.item[i].x = k%16 * gp.tileSize + gp.tileSize/4;
        gp.item[i].y = k/16 * gp.tileSize + gp.tileSize/4;
        gp.item[i].z = k;

    }

    public void setPowerUp(int i){

        do{
            k = gp.tileManager.getRandomReachableIndex();
        }while(set.contains(k));
        set.add(k);

        gp.item[i] = new Lucky();
        gp.item[i].x = k%16 * gp.tileSize + gp.tileSize/4;
        gp.item[i].y = k/16 * gp.tileSize + gp.tileSize/4;
        gp.item[i].z = k;
    }

    public void setNPC(int i){
        gp.NPC[i] = new NPC_Monster(gp);
        gp.NPC[i].x = gp.boss[0].x + 24;
        gp.NPC[i].y = gp.boss[0].y + 84;
        gp.NPC[i].healthPower = 3;
    }

    public void setBoss(){
        gp.boss[0] = new Boss(gp);
    }
}
