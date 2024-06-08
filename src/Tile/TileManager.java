package Tile;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

import javax.swing.*;

import game.GamePanel;

public class TileManager {
    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][];

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[5];
        mapTileNum = new int[13][17];
        getTileImage();
        loadMap("map.txt");
    }

    public void getTileImage() {
        tile[0] = new Tile();
        tile[0].img = new ImageIcon("src/img/tile/grass1.png").getImage();
        tile[0].collision = true;

        tile[1] = new Tile();
        tile[1].img = new ImageIcon("src/img/tile/road1.png").getImage();

        tile[2] = new Tile();
        tile[2].img = new ImageIcon("src/img/tile/water.png").getImage();
        tile[2].collision = true;
    }

    public void loadMap(String filepath) {
        try {
            InputStream in = getClass().getResourceAsStream(filepath);
            BufferedReader bR = new BufferedReader(new InputStreamReader(in));
    
            int col = 0;
            int row = 0;
            String line;
            while ((line = bR.readLine()) != null && row < 12) {
                String numbers[] = line.split(" ");
                for (col = 0; col < 16; col++) {
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[row][col] = num;
                }
                row++;
            }
    
            bR.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void drawTile(Graphics2D g) {
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;
        while (col < 16 && row < 12) {
            int num = mapTileNum[row][col];
            g.drawImage(tile[num].img, x, y, 48, 48, null);
            x += 48;
            col++;
            if (col == 16) {
                col = 0;
                row++;
                x = 0;
                y += 48;
            }
        }
    }
}


