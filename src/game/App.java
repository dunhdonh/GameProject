package game;
import javax.swing.*;

public class App {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Dragon Ball");
        ImageIcon logo = new ImageIcon("res/player/boy_down_1.png");
        frame.setIconImage(logo.getImage());
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DragonBall dragonBall = new DragonBall();
        frame.add(dragonBall);
        frame.pack();

        frame.setVisible(true);
        dragonBall.setUpGame();
        dragonBall.startGameThread();
    }
}
