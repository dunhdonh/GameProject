package item;

import javax.swing.*;

public class GaRan extends AbsItem {
    public GaRan() {
        name = "GaRan";
        try {
            image = new ImageIcon("src/img/item/GaRan.png");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
