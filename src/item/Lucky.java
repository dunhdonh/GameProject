package item;
import javax.swing.*;
public class Lucky extends AbsItem{
    public Lucky() {
        name = "Lucky";
        try {
            image = new ImageIcon("res/item/lucky.png");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
