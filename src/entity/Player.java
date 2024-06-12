package entity;

import game.GamePanel;
import game.KeyHandle;

import java.awt.Graphics2D;
import javax.swing.*;
import java.awt.Rectangle;

public class Player extends Entity {

    KeyHandle keyHandle;
    public int healthPower = 4;
    public int attackPower = 0;
    public int manaPower = 0;

    public boolean hasKey = false;

    public int getHealthPower() {
        return healthPower;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getManaPower() {
        return manaPower;
    }

    public Player(GamePanel gp, KeyHandle keyHandle) {
        super(gp);
        this.keyHandle = keyHandle;

        solidArea = new Rectangle();
        solidArea.x = 12;
        solidArea.y = 24;
        solidDefaultX = solidArea.x;
        solidDefaultY = solidArea.y;
        solidArea.width = 24;
        solidArea.height = 24;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        this.x = 24;
        this.y = 5 * 48;
        speed = 5;
        direction = "down";
    }

    public void getPlayerImage() {
        try {
            up1 = new ImageIcon("src/img/player/boy_up_1.png");
            up2 = new ImageIcon("src/img/player/boy_up_2.png");
            down1 = new ImageIcon("src/img/player/boy_down_1.png");
            down2 = new ImageIcon("src/img/player/boy_down_2.png");
            left1 = new ImageIcon("src/img/player/boy_left_1.png");
            left2 = new ImageIcon("src/img/player/boy_left_2.png");
            right1 = new ImageIcon("src/img/player/boy_right_1.png");
            right2 = new ImageIcon("src/img/player/boy_right_2.png");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update() {
        
        if (attackPower >= 10 && manaPower < 4 ) {
            manaPower++;
            attackPower -= 10;
        }

        if (healthPower <= 0) {
            gp.state = gp.gameOver;
        }


        if (keyHandle.up || keyHandle.down || keyHandle.left || keyHandle.right) {
            if (keyHandle.up) {
                direction = "up";
            }
            if (keyHandle.down) {
                direction = "down";
            }
            if (keyHandle.left) {
                direction = "left";
            }
            if (keyHandle.right) {
                direction = "right";
            }

            collisionOn = false;
            // check tile collision
            gp.collCheck.checkTile(this);

            // check NPC collision
            int NPCindex = gp.collCheck.checkEntity(this, gp.NPC);
            interactWithNPC(NPCindex);

            gp.collCheck.checkEntity(this, gp.boss);

            // check item collision
            int itemIndex = gp.collCheck.checkItem(this, true);
            pickUpItem(itemIndex);

            // collitionOn = false -> can move
            if (collisionOn == false) {
                switch (direction) {
                    case "up":
                        y -= speed;
                        y = Math.max(-24, y);
                        break;
                    case "down":
                        y += speed;
                        y = Math.min(gp.screenHeight - gp.tileSize, y);
                        break;
                    case "left":
                        x -= speed;
                        x = Math.max(0, x);
                        break;
                    case "right":
                        x += speed;
                        x = Math.max(0, x);
                        break;
                }
            }

            spriteCounter++;
            if (spriteCounter > 12) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }

        if (invincible == true) {
            invincibleCounter++;
            if (invincibleCounter > 60) {
                invincibleCounter = 0;
                invincible = false;
            }
        }
    }

    public void pickUpItem(int index) {
        if (index != 999) {
            String itemName = gp.item[index].name;

            switch (itemName) {
                case "Lucky":
                    gp.playSoundEffect(2);
                    gp.powerUpCounter--;
                    if (healthPower < 4) {
                        healthPower++;
                        System.out.println("Health Power: " + healthPower);
                    }
                        gp.aSetter.set.remove(gp.item[index].z);
                        gp.item[index] = null;

                    break;
                case "Coin":
                    gp.playSoundEffect(1);
                    gp.coinCounter--;
                    if (attackPower < 10) {
                        attackPower += 5;
                        System.out.println("Attack Power: " + attackPower);
                        gp.aSetter.set.remove(gp.item[index].z);
                        gp.item[index] = null;

                    }
                    break;
                case "Key":
                    gp.playSoundEffect(2);
                    hasKey = true;
                    gp.aSetter.set.remove(gp.item[index].z);
                    gp.item[index] = null;

                    break;

                case "Door":
                if (hasKey) {
                    gp.playSoundEffect(3);
                    gp.state = gp.passRound;
                }
                    break;
            }
        }
    }

    public void interactWithNPC(int index) {
        if (index != 999) {
            if (invincible == false) {

                healthPower --;
                gp.NPC[index].healthPower--;
                if (gp.NPC[index].healthPower <= 0) {
                    gp.NPC[index] = null;
                }
                System.out.println("Health Power: " + healthPower);
                invincible = true;
                invincibleCounter = 0;
            }

        }
    }

    boolean distanceToAttack() {
        if ((x <= gp.boss[0].x + 96 + gp.tileSize) && (x >= gp.boss[0].x - gp.tileSize)
                && (y <= gp.boss[0].y + gp.tileSize + 96)
                && y >= gp.boss[0].y - gp.tileSize) {
            return true;
        }
        return false;
    }

    public void attackBoss() {
        if (manaPower > 0 && distanceToAttack()) {
            gp.boss[0].healthPower--;
            manaPower--;
            System.out.println("Boss Health: " + gp.boss[0].healthPower);
            if (gp.boss[0].healthPower <= 0) {
                gp.boss[0] = null;
            }
        } else if (manaPower == 0)
            System.out.println("You don't have enough power to attack the boss!");
        else if (!distanceToAttack())
            System.out.println("You are not close enough to attack the boss!");

    }

    public void draw(Graphics2D g) {

        ImageIcon img = null;
        switch (direction) {
            case "up":
                if (spriteNum == 1) {
                    img = up1;
                } else {
                    img = up2;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    img = down1;
                } else {
                    img = down2;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    img = left1;
                } else {
                    img = left2;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    img = right1;
                } else {
                    img = right2;
                }
                break;
        }
        g.drawImage(img.getImage(), x, y, gp.tileSize, gp.tileSize, null);
    }

}
