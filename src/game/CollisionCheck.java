package game;

import entity.Entity;

public class CollisionCheck {

    DragonBall gp;

    public CollisionCheck(DragonBall gp) {
        this.gp = gp;
    }

    public void checkTile(Entity entity) {
        int entityLeftX = entity.x + entity.solidArea.x;
        int entityRightX = entity.x + entity.solidArea.x + entity.solidArea.width;
        int entityTopY = entity.y + entity.solidArea.y;
        int entityBottomY = entity.y + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftX / gp.tileSize;
        int entityRightCol = entityRightX / gp.tileSize;
        int entityTopRow = entityTopY / gp.tileSize;
        int entityBottomRow = entityBottomY / gp.tileSize;

        int tileNum1, tileNum2;

        switch (entity.direction) {
            case "up":
                tileNum1 = gp.tileManager.mapTileNum[entityTopRow][entityLeftCol];
                tileNum2 = gp.tileManager.mapTileNum[entityTopRow][entityRightCol];
                if (gp.tileManager.tile[tileNum1].collision || gp.tileManager.tile[tileNum2].collision) {
                    entity.y = (entityTopRow + 1) * gp.tileSize - entity.solidArea.y;
                }
                break;
            case "down":
                tileNum1 = gp.tileManager.mapTileNum[entityBottomRow][entityLeftCol];
                tileNum2 = gp.tileManager.mapTileNum[entityBottomRow][entityRightCol];
                if (gp.tileManager.tile[tileNum1].collision || gp.tileManager.tile[tileNum2].collision) {
                    entity.y = entityBottomRow * gp.tileSize - entity.solidArea.y - entity.solidArea.height - 1;
                }
                break;
            case "left":
                tileNum1 = gp.tileManager.mapTileNum[entityTopRow][entityLeftCol];
                tileNum2 = gp.tileManager.mapTileNum[entityBottomRow][entityLeftCol];
                if (gp.tileManager.tile[tileNum1].collision || gp.tileManager.tile[tileNum2].collision) {
                    entity.x = (entityLeftCol + 1) * gp.tileSize - entity.solidArea.x;
                }
                break;
            case "right":
                tileNum1 = gp.tileManager.mapTileNum[entityTopRow][entityRightCol];
                tileNum2 = gp.tileManager.mapTileNum[entityBottomRow][entityRightCol];
                if (gp.tileManager.tile[tileNum1].collision || gp.tileManager.tile[tileNum2].collision) {
                    entity.x = entityRightCol * gp.tileSize - entity.solidArea.x - entity.solidArea.width - 1;
                }
                break;
        }
    }

    public int checkItem(Entity entity, boolean player) {
        int index = 999;
        for (int i = 0; i < gp.item.length; i++) {
            if (gp.item[i] != null) {
                entity.solidArea.x = entity.x + entity.solidArea.x;
                entity.solidArea.y = entity.y + entity.solidArea.y;
                gp.item[i].solidArea.x = gp.item[i].x + gp.item[i].solidArea.x;
                gp.item[i].solidArea.y = gp.item[i].y + gp.item[i].solidArea.y;

                switch (entity.direction) {
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        if (entity.solidArea.intersects(gp.item[i].solidArea)) {
                            if (gp.item[i].collisionOn == true){
                                entity.collisionOn = true;
                            }
                            if (player == true){
                                index = i;
                            }
                        }
                        break;
                    case "down":
                        entity.solidArea.y += entity.speed;
                        if (entity.solidArea.intersects(gp.item[i].solidArea)) {
                            if (gp.item[i].collisionOn == true){
                                entity.collisionOn = true;
                            }
                            if (player == true){
                                index = i;
                            }
                        }
                        break;
                    case "left":
                        entity.solidArea.x -= entity.speed;
                        if (entity.solidArea.intersects(gp.item[i].solidArea)) {
                            if (gp.item[i].collisionOn == true){
                                entity.collisionOn = true;
                            }
                            if (player == true){
                                index = i;
                            }
                        }
                        break;
                    case "right":
                        entity.solidArea.x += entity.speed;
                        if (entity.solidArea.intersects(gp.item[i].solidArea)) {
                            if (gp.item[i].collisionOn == true){
                                entity.collisionOn = true;
                            }
                            if (player == true){
                                index = i;
                            }
                        }
                        break;
                }
            entity.solidArea.x = entity.solidDefaultX;
            entity.solidArea.y = entity.solidDefaultY;
            gp.item[i].solidArea.x = gp.item[i].solidDefaultX;
            gp.item[i].solidArea.y = gp.item[i].solidDefaultY;
            }
            
        }
        return index;
    }
}