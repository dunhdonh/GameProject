package item;

import javax.swing.ImageIcon;
import game.GamePanel;
import java.awt.Graphics2D;

public class Door extends AbsItem{

    public Door(){
        name = "Door";

        collision = true;
        try {
            image = new ImageIcon("src/img/item/Door.png");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g, GamePanel gp) {
        g.drawImage(image.getImage(), x, y, gp.tileSize, gp.tileSize, null);
    }
}
