package game;

import java.awt.*;
import javax.swing.ImageIcon;

public class UI {
    GamePanel gp;
    Font arial_40;

    Graphics2D g;

    ImageIcon hp1, hp2, hp3, hp4, hp0;
    ImageIcon mp1, mp2, mp3, mp4, mp0;
        
    
    public UI(GamePanel gp) {
        this.gp = gp;
        arial_40 = new Font("Arial", Font.PLAIN, 20);
        try {
            hp1 = new ImageIcon("src/img/PowerBar/HP1.png");
            hp2 = new ImageIcon("src/img/PowerBar/HP2.png");
            hp3 = new ImageIcon("src/img/PowerBar/HP3.png");
            hp4 = new ImageIcon("src/img/PowerBar/HP4.png");
            hp0 = new ImageIcon("src/img/PowerBar/HP0.png");
            mp1 = new ImageIcon("src/img/PowerBar/MP1.png");
            mp2 = new ImageIcon("src/img/PowerBar/MP2.png");
            mp3 = new ImageIcon("src/img/PowerBar/MP3.png");
            mp4 = new ImageIcon("src/img/PowerBar/MP4.png");
            mp0 = new ImageIcon("src/img/PowerBar/MP0.png");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g) {
        this.g = g;
        g.setColor(Color.WHITE);
        g.setFont(arial_40);

        if (gp.state == gp.startStage) {
            drawStart();
        } else {
            drawHP();
            drawMP();

            if (gp.state == gp.pauseStage) {
                drawPause();
            }
            if (gp.state == gp.gameOver) {
                drawGameOver();
            }
            if (gp.state == gp.passRound) {
                drawPassRound();
            }
        }
    }

    public void drawStart() {

        
        int y = gp.screenHeight * 2 / 3;
        int x = getXCentered("Press Enter to Start", arial_40);
        g.drawString("Press Enter to Start", x, y);
        x = getXCentered("Press Q to Quit", arial_40);
        g.drawString("Press Q to Quit", x, (y + 40));
    }

    // pause screen
    public void drawPause() {
        int y = gp.screenHeight / 2;
        int x = getXCentered("PAUSE", arial_40);
        g.drawString("PAUSE", x, y);
    }

    // game over screen
    public void drawGameOver() {
        int y = gp.screenHeight / 2;
        int x = getXCentered("YOU LOSE", arial_40);
        g.drawString("YOU LOSE", x, y);
    }

    public void drawPassRound(){
        int y = gp.screenHeight / 2;
        int x = getXCentered("NEXT ROUND", arial_40);
        g.drawString("NEXT ROUND", x, y);
    }
    public int getXCentered(String str, Font font) {
        FontMetrics fm = g.getFontMetrics(font);
        int length = (int) fm.getStringBounds(str, g).getWidth();
        return gp.screenWidth / 2 - length / 2;
    }

    public void drawHP(){
        if(gp.player.getHealthPower() == 4){
            g.drawImage(hp4.getImage(), 10, 10, 160, 29, null);
        }
        else if(gp.player.getHealthPower() == 3){
            g.drawImage(hp3.getImage(), 10, 10, 160, 29, null);
        }
        else if(gp.player.getHealthPower() == 2){
            g.drawImage(hp2.getImage(), 10, 10, 160, 29, null);
        }
        else if(gp.player.getHealthPower() == 1){
            g.drawImage(hp1.getImage(), 10, 10, 160, 29, null);
        }
        else if(gp.player.getHealthPower() == 0){
            g.drawImage(hp0.getImage(), 10, 10, 160, 29, null);
        }
    }

    public void drawMP(){
        if(gp.player.getManaPower() == 4){
            g.drawImage(mp4.getImage(), 10, 40,  160, 29, null);
        }
        else if(gp.player.getManaPower() == 3){
            g.drawImage(mp3.getImage(), 10, 40, 160, 29, null);
        }
        else if(gp.player.getManaPower() == 2){
            g.drawImage(mp2.getImage(), 10, 40, 160, 29, null);
        }
        else if(gp.player.getManaPower() == 1){
            g.drawImage(mp1.getImage(), 10, 40, 160, 29, null);
        }
        else if(gp.player.getManaPower() == 0){
            g.drawImage(mp0.getImage(), 10, 40, 160, 29,null);
        }
    }
}
