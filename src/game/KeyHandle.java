package game;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandle implements KeyListener{

    GamePanel gp;
    public boolean up, down, left, right;

    public KeyHandle(GamePanel gp){
        this.gp = gp;
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_UP) {
            up = true;
        }
        if(code == KeyEvent.VK_DOWN) {
            down = true;
        }
        if(code == KeyEvent.VK_LEFT) {
            left = true;
        }
        if(code == KeyEvent.VK_RIGHT) {
            right = true;
        }
        if(code == KeyEvent.VK_SPACE) {
            if (gp.state == gp.playStage) {
                gp.state = gp.pause;
            } else if (gp.state == gp.pause) {
                gp.state = gp.playStage;
            }
        }
        if(code == KeyEvent.VK_ENTER) {
            gp.player.attackBoss();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP) {
            up = false;
        }
        if(code == KeyEvent.VK_DOWN) {
            down = false;
        }
        if(code == KeyEvent.VK_LEFT) {
            left = false;
        }
        if(code == KeyEvent.VK_RIGHT) {
            right = false;
        }
    }
}
