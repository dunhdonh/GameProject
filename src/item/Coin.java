package item;
import javax.swing.*;

public class Coin extends AbsItem {

    public Coin() {
        name = "Coin";
        try {
            image = new ImageIcon("src/img/item/Coin.png");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
