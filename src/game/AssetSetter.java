package game;

import java.util.Set;
import java.util.HashSet;
import entity.NPC_Monster;
import entity.Boss;
import item.Coin;
import item.Lucky;
import item.Key;
import item.Door;

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

    public void setBoss(String fileName){
        gp.boss[0] = new Boss(gp, fileName);

        gp.item[25] = new Key();
        gp.item[25].x = 9 * gp.tileSize + gp.tileSize/4;
        gp.item[25].y = 1 * gp.tileSize + gp.tileSize/4;
        gp.item[25].z = 9 + 1 * 16;
    }

    public void setDoor(){
        gp.item[26] = new Door();
        gp.item[26].x = 3 * gp.tileSize;
        gp.item[26].y = 0;
        gp.item[26].z = 3 + 0 * 16;
    }
}
