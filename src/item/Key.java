package item;
import javax.swing.*;

public class Key extends AbsItem{
    public Key(){
        name = "Key";
        try {
            image = new ImageIcon("src/img/item/Key.png");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
