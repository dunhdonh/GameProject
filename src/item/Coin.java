package item;
import javax.swing.*;

public class Coin extends AbsItem {

    public Coin() {
        name = "Coin";
        try {
            image = new ImageIcon("res/item/coin.png");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
