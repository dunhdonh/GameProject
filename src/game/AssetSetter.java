package game;

import item.Coin;
import item.Lucky;

public class AssetSetter {
    DragonBall gp;
    
    public AssetSetter (DragonBall gp){
        this.gp = gp;
    }

    public void setItem(){
        gp.item[0] = new Coin();
        gp.item[0].x = 10 * gp.tileSize + gp.tileSize/4;
        gp.item[0].y = 5 * gp.tileSize + gp.tileSize/4;

        gp.item[1] = new Coin();
        gp.item[1].x = 10 * gp.tileSize + gp.tileSize/4;
        gp.item[1].y = 6 * gp.tileSize + gp.tileSize/4;

        gp.item[2] = new Lucky();
        gp.item[2].x = 6 * gp.tileSize + gp.tileSize/4;
        gp.item[2].y = 6 * gp.tileSize + gp.tileSize/4;
    }
}
