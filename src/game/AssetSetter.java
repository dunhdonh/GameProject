package game;

import java.util.Set;
import java.util.HashSet;
import entity.NPC_Monster;
import entity.Boss;
import item.Coin;
import item.GaRan;
import item.Key;
import item.Door;
import entity.Player;

public class AssetSetter {
    GamePanel gp;
    public Set<Integer> set = new HashSet<Integer>();

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    int k;

    public void setCoin(int i) {

        do {
            k = gp.tileManager.getRandomReachableIndex();
        } while (set.contains(k));
        set.add(k);

        gp.item[i] = new Coin();
        gp.item[i].x = k % 16 * gp.tileSize + gp.tileSize / 4;
        gp.item[i].y = k / 16 * gp.tileSize + gp.tileSize / 4;
        gp.item[i].z = k;

    }

    public void setPowerUp(int i) {
        do {
            k = gp.tileManager.getRandomReachableIndex();
        } while (set.contains(k));
        set.add(k);

        gp.item[i] = new GaRan();
        gp.item[i].x = k % 16 * gp.tileSize + gp.tileSize / 4;
        gp.item[i].y = k / 16 * gp.tileSize + gp.tileSize / 4;
        gp.item[i].z = k;
    }

    public void setNPC(int i, int round) {
        gp.NPC[i] = new NPC_Monster(gp, round);
        gp.NPC[i].healthPower = round;
        switch (round){
            case 1:
            gp.NPC[i].x = gp.boss[0].x + 24 + 96;
            gp.NPC[i].y = gp.boss[0].y + 48;
                break;
            case 2:
                gp.NPC[i].x = 6 * gp.tileSize;
                gp.NPC[i].y = 8 * gp.tileSize;
                break;
            case 3:
            gp.NPC[i].x = gp.boss[0].x + 24;
            gp.NPC[i].y = gp.boss[0].y + 96;
                break;
            case 4:
                gp.NPC[i].x = 7 * gp.tileSize;
                gp.NPC[i].y = 7 * gp.tileSize;
                break;
        }
    }

    public void setBoss(int round) {
        gp.boss[0] = new Boss(gp, round);
        gp.item[25] = new Key();
        gp.item[25].x = gp.boss[0].x + 30;
        gp.item[25].y = gp.boss[0].y + 30;
    }

    public void setDoor(int round) {
        gp.item[26] = new Door();
        switch (round){
            case 1:
                gp.item[26].x = 6 * gp.tileSize;
                gp.item[26].y = 11 * gp.tileSize;
                gp.item[26].z = 6 + 11 * 16;
                break;
            case 2:
                gp.item[26].x = 14 * gp.tileSize;
                gp.item[26].y = 1 * gp.tileSize;
                gp.item[26].z = 14 + 1 * 16;
                break;
            case 3:
                gp.item[26].x = 0 * gp.tileSize;
                gp.item[26].y = 8 * gp.tileSize;
                gp.item[26].z = 0 + 8 * 16;
                break;
            case 4:
                gp.item[26].x = 4 * gp.tileSize;
                gp.item[26].y = 4 * gp.tileSize;
                gp.item[26].z = 4 + 4 * 16;
                break;
        }
        
    }

    public void setPlayer(int round) {
        gp.player = new Player(gp, gp.keyHandle);
        gp.player.hasKey = true;
        switch (round) {
            case 1:
                gp.player.x = 12;
                gp.player.y = 4 * gp.tileSize - 24;
                break;
            case 2:
                gp.player.x = 6 * gp.tileSize;
                gp.player.y = 5 * gp.tileSize;
                break;
            case 3:
                gp.player.x = 1 * gp.tileSize;
                gp.player.y = 5 * gp.tileSize;
                break;
            case 4:
                gp.player.x = 12;
                gp.player.y = 6 * gp.tileSize - 24;
                break;
        }
    }

    public void setRound(int i) {
        for (int j = 0; j < 27; j++) {
            set.remove(j);
            gp.item[j] = null;}
        for (int j = 0; j < 16; j++) {
            gp.NPC[j] = null;}
        gp.round = i;
        gp.tileManager.setMap(i);
        setPlayer(i);
        setBoss(i);
        setNPC(0, i);
        setDoor(i);
    }

    public void update(){
        for (int i = 0; i < 16; i++) {
            if (gp.NPC[i] != null && gp.NPC[i].healthPower <= 0) {
                gp.NPC[i] = null;
        }
        }
    }
}
