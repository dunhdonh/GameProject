package game;

import entity.Entity;

public class CollisionCheck{

    DragonBall gp;

    public CollisionCheck(DragonBall gp){
        this.gp = gp;
    }

    public void checkTile(Entity entity){
        int entityLeftX = entity.x + entity.solidArea.x;
        int entityRightX = entity.x + entity.solidArea.x + entity.solidArea.width;
        int entityTopY = entity.y + entity.solidArea.y;
        int entityBottomY = entity.y + entity.solidArea.y + entity.solidArea.height;
        
        int entityLeftCol = entityLeftX / gp.tileSize;
        int entityRightCol = entityRightX / gp.tileSize;
        int entityTopRow = entityTopY / gp.tileSize;
        int entityBottomRow = entityBottomY / gp.tileSize;

        int tileNum1, tileNum2;

        switch(entity.direction){
            case "up":
                tileNum1 = gp.tileManager.mapTileNum[entityTopRow][entityLeftCol];
                tileNum2 = gp.tileManager.mapTileNum[entityTopRow][entityRightCol];
                if(gp.tileManager.tile[tileNum1].collision || gp.tileManager.tile[tileNum2].collision){
                    entity.y = (entityTopRow + 1) * gp.tileSize - entity.solidArea.y;
                }
                break;
            case "down":
                tileNum1 = gp.tileManager.mapTileNum[entityBottomRow][entityLeftCol];
                tileNum2 = gp.tileManager.mapTileNum[entityBottomRow][entityRightCol];
                if(gp.tileManager.tile[tileNum1].collision || gp.tileManager.tile[tileNum2].collision){
                    entity.y = entityBottomRow * gp.tileSize - entity.solidArea.y - entity.solidArea.height - 1;
                }
                break;
            case "left":
                tileNum1 = gp.tileManager.mapTileNum[entityTopRow][entityLeftCol];
                tileNum2 = gp.tileManager.mapTileNum[entityBottomRow][entityLeftCol];
                if(gp.tileManager.tile[tileNum1].collision || gp.tileManager.tile[tileNum2].collision){
                    entity.x = (entityLeftCol + 1) * gp.tileSize - entity.solidArea.x;
                }
                break;
            case "right":
                tileNum1 = gp.tileManager.mapTileNum[entityTopRow][entityRightCol];
                tileNum2 = gp.tileManager.mapTileNum[entityBottomRow][entityRightCol];
                if(gp.tileManager.tile[tileNum1].collision || gp.tileManager.tile[tileNum2].collision){
                    entity.x = entityRightCol * gp.tileSize - entity.solidArea.x - entity.solidArea.width - 1;
                }
                break;
            }
    }
}