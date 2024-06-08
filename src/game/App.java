package game;
import javax.swing.*;

public class App {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Dragon Ball");
        ImageIcon logo = new ImageIcon("src/img/player/boy_down_1.png");
        frame.setIconImage(logo.getImage());
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GamePanel dragonBall = new GamePanel();
        frame.add(dragonBall);
        frame.pack();

        frame.setVisible(true);
        dragonBall.setUpGame();
        dragonBall.startGameThread();
    }
}
