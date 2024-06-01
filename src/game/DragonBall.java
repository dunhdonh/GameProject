package game;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

import Tile.TileManager;

import java.util.Random;

public class DragonBall extends JPanel implements ActionListener, KeyListener {
    int boardWidth = 720;
    int boardHeight = 720;
    // image
    Image backgroundImg;
    Image characterImg;
    Image treeImage;
    Image fenceImg;
    // characterPosition
    int charX = 20;
    int charY = boardHeight / 2;
    int charWidth = 60;
    int charHeight = 60;

    class Character {
        int x = charX;
        int y = charY;
        int width = charWidth;
        int height = charHeight;
        Image img;

        Character(Image img) {
            this.img = img;
        }
    }

    // game logic
    Character character;
    int velocityY = 0;
    int velocityX = 0;
    Timer gameLoop;

    DragonBall() {
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        setFocusable(true);
        addKeyListener(this);
        // load images
        characterImg = new ImageIcon("src/img/char.png").getImage();
        treeImage = new ImageIcon("src/img/tree.png").getImage();
        fenceImg = new ImageIcon("src/img/fence.png").getImage();

        // character
        character = new Character(characterImg);

        // game timer
        gameLoop = new Timer(1000 / 60, this);
        gameLoop.start();
    }

    public void paintComponent(Graphics g) {
        TileManager tm = new TileManager(this);
        super.paintComponent(g);
        tm.drawTile(g);
        draw(g);
    }

    public void draw(Graphics g) {
        // character
        g.drawImage(character.img, character.x, character.y, character.width, character.height, null);

       
    }  

    public void move() {
            character.x += velocityX;
            character.x = Math.min(character.x, boardWidth - character.width);
            character.x = Math.max(character.x, 0);
            character.y += velocityY;
            character.y = Math.min(character.y, boardHeight - character.height);
            character.y = Math.max(character.y, 0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            velocityX = -6;
        }
        if (key == KeyEvent.VK_RIGHT) {
            velocityX = 6;
        }
        if (key == KeyEvent.VK_UP) {
            velocityY = -6;
        }
        if (key == KeyEvent.VK_DOWN) {
            velocityY = 6;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        velocityX = 0;
        velocityY = 0;
    }
}
