package game;
import javax.swing.*;

public class App {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Game");
        ImageIcon logo = new ImageIcon("src/img/player/boy_down_1.png");
        frame.setIconImage(logo.getImage());
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GamePanel gp = new GamePanel();
        frame.add(gp);
        frame.pack();

        frame.setVisible(true);
        gp.setUpGame();
        gp.startGameThread();
    }
}
