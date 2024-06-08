package game;

import java.awt.*;
import java.awt.FontMetrics; // Import the FontMetrics class

public class UI {
    GamePanel gp;
    Font arial_40;

    Graphics2D g;

    public UI(GamePanel gp) {
        this.gp = gp;
        arial_40 = new Font("Arial", Font.PLAIN, 20);
    }

    public void draw (Graphics2D g) {
        this.g = g; 
        g.setColor(Color.WHITE);
        g.setFont(arial_40);
        g.drawString("HEALTH: " + gp.player.getHealthPower(), 10, 20);
        g.drawString("ATTACK: " + gp.player.getAttackPower(), 10, 40);
        if (gp.boss[0] != null)
            g.drawString("BOSS: " + gp.boss[0].healthPower, 10, 60);
        if (gp.state == gp.pause) {
            drawPause();
        }
        if (gp.state == gp.gameOver) {
            drawGameOver();
        }
    }   
    public void drawPause() {
        int y = gp.screenHeight / 2;
        int x = getXCentered("PAUSE", arial_40);
        g.drawString("PAUSE", x, y);
    }

    public void drawGameOver() {
        int y = gp.screenHeight / 2;
        int x = getXCentered("YOU LOSE", arial_40);
        g.drawString("YOU LOSE", x, y);

    }
    public int getXCentered(String str, Font font) {
        FontMetrics fm = g.getFontMetrics(font);
        int length = (int)fm.getStringBounds(str, g).getWidth();
        return gp.screenWidth / 2 - length / 2;
    }
}
