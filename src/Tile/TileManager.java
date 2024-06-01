package Tile;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

import javax.swing.*;

import game.DragonBall;

public class TileManager {
    DragonBall gp;
    Tile[] tile;
    int mapTileNum[][];

    public TileManager(DragonBall gp) {
        this.gp = gp;
        tile = new Tile[5];
        mapTileNum = new int[12][12];
        getTileImage();
        loadMap("map.txt");
    }

    public void getTileImage() {
        tile[0] = new Tile();
        tile[0].img = new ImageIcon("src/img/grass1.png").getImage();
        tile[0].collision = true;

        tile[1] = new Tile();
        tile[1].img = new ImageIcon("src/img/road1.png").getImage();

        tile[2] = new Tile();
        tile[2].img = new ImageIcon("src/img/water.png").getImage();
        tile[2].collision = true;
    }

    public void loadMap(String filepath) {
        try {
            InputStream in = getClass().getResourceAsStream(filepath);
            BufferedReader bR = new BufferedReader(new InputStreamReader(in));

            int col = 0;
            int row = 0;
            while (col < 12 && row < 12) {
                String line = bR.readLine();
                while (col < 12) {
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[row][col] = num;
                    col++;
                }
                if (col == 12) {
                    col = 0;
                    row++;
                }
            }
        } catch (Exception e) {

        }
    }

    public void drawTile(Graphics g) {
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;
        while (col < 12 && row < 12) {
            int num = mapTileNum[row][col];
            g.drawImage(tile[num].img, x, y, gp);
            x += 60;
            col++;
            if (col == 12) {
                col = 0;
                row++;
                x = 0;
                y += 60;
            }
        }
    }
}