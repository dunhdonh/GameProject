package game;
import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception {
        int boardWidth = 720;
        int boardHeight = 720;

        JFrame frame = new JFrame("Dragon Ball");
        frame.setSize(boardWidth, boardHeight);
        ImageIcon logo = new ImageIcon("src/img/char.png");
        frame.setIconImage(logo.getImage());
        // frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DragonBall dragonBall = new DragonBall();
        frame.add(dragonBall);
        frame.pack();
        dragonBall.requestFocus();
        frame.setVisible(true);

    }
}
