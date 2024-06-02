package game;

import java.awt.*;

public class UI {
    DragonBall gp;
    Font arial_40;

    public UI(DragonBall gp) {
        this.gp = gp;
        arial_40 = new Font("Arial", Font.PLAIN, 20);
    }

    public void draw (Graphics2D g) {
        g.setColor(Color.WHITE);
        g.setFont(arial_40);
        g.drawString("HEALTH: " + gp.player.getHealthPower(), 10, 20);
        g.drawString("ATTACK: " + gp.player.getAttackPower(), 10, 40);
    }   
}
