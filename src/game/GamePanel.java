package game;

import javax.swing.JPanel;
import entity.Player;
import entity.NPC_Monster;
import entity.Boss;
import item.AbsItem;

import java.awt.*;

import Tile.TileManager;

public class GamePanel extends JPanel implements Runnable {

    // Screen Setting
    final int OriginalTileSize = 16; // 16px
    final int scale = 3;
    public final int tileSize = OriginalTileSize * scale; // 48x48px
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol; // 768px
    public final int screenHeight = tileSize * maxScreenRow;// 576px

    int FPS = 60;

    // KeyHandle
    KeyHandle keyHandle = new KeyHandle(this);

    // Game Object (Player, Tile, Item, CollisionCheck)
    public AssetSetter aSetter = new AssetSetter(this);
    public Player player = new Player(this, keyHandle);
    TileManager tileManager = new TileManager(this);
    public CollisionCheck collCheck = new CollisionCheck(this);
    public AbsItem item[] = new AbsItem[10];
    public NPC_Monster NPC[] = new NPC_Monster[10];
    public Boss[] boss = new Boss[1];

    // Game State
    public int state;
    public final int playStage = 1;
    public final int pause = 2;
    public final int gameOver = 3;
    public final int passRound = 4;

    // UI&Sound
    public UI ui = new UI(this);
    public Sound music = new Sound();
    public Sound SE = new Sound();

    Thread gameThread;
    // Set player default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 5;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandle);
        this.setFocusable(true);
    }

    public void setUpGame() {
        aSetter.setItem();
        aSetter.setNPC(0);
        aSetter.setBoss();
        playMusic(0);
        state = playStage;
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void update() {
        if (state == playStage) {

            //player 
            player.update();

            //npc
            for (int i = 0; i < NPC.length; i++ ) {
                if (NPC[i] != null) {
                    NPC[i].update();
                }
            }

        }


        if (state == pause) {
        }
        if (state == gameOver) {
        }

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Background
        tileManager.drawTile(g2);

        // Item
        for (int i = 0; i < item.length; i++) {
            if (item[i] != null) {
                item[i].draw(g2, this);
            }
        }

        // Boss
        if (boss[0] != null) {
            boss[0].draw(g2);
        }

        // Player
        player.draw(g2);

        // mons
        for (int i = 0; i < NPC.length; i++) {
            if (NPC[i] != null) {
                NPC[i].draw(g2);
            }
        }

        // UI
        ui.draw(g2);

        g2.dispose();
    }

    public void playMusic(int i) {
        music.setFile(0);
        music.play();
        music.loop();
    }

    public void stopMusic() {
        music.stop();
    }

    public void playSoundEffect(int i) {
        SE.setFile(i);
        SE.play();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000 / FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while (gameThread != null) {
            update();
            repaint();

            try {
                double waitTime = nextDrawTime - System.nanoTime();
                if (waitTime < 0)
                    waitTime = 0;
                Thread.sleep((long) (waitTime / 1000000));
                nextDrawTime += drawInterval;
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}
