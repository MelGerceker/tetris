package src;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import src.Tetris_Pieces.Block;
import src.Tetris_Pieces.Mino_Bar;
import src.Tetris_Pieces.Mino_L1;
import src.Tetris_Pieces.Mino_L2;
import src.Tetris_Pieces.Mino_Square;
import src.Tetris_Pieces.Mino_T;
import src.Tetris_Pieces.Mino_Z1;
import src.Tetris_Pieces.Mino_Z2;
import src.Tetris_Pieces.TetroMino;

public class PlayAreaManager {

    // Main Play Area
    final int WIDTH = 360;
    final int HEIGHT = 600;
    public static int left_x;
    public static int right_x;
    public static int top_y;
    public static int bottom_y;

    // Mino
    TetroMino currentMino;
    final int MINO_START_X;
    final int MINO_START_Y;

    public static int dropInterval = 60;

    public PlayAreaManager() {

        // Main Play Area Frame
        left_x = (GameScreen.WIDTH / 2) - (WIDTH / 2);
        right_x = left_x + WIDTH;
        top_y = 50;
        bottom_y = top_y + HEIGHT;

        MINO_START_X = left_x + (WIDTH / 2) - Block.SIZE;
        MINO_START_Y = top_y + Block.SIZE;

        // Set the starting Mino
        currentMino = new Mino_L1();
        currentMino.setXY(MINO_START_X, MINO_START_Y);
    }

    public void update() {
        MinoController.handleInput(currentMino);
        currentMino.updateAutoDrop(); // NEW
    }

    public void draw(Graphics2D g2) {

        // Draw Play Area Frame
        g2.setColor(Color.white);
        g2.setStroke(new BasicStroke(4f));
        g2.drawRect(left_x - 4, top_y - 4, WIDTH + 8, HEIGHT + 8);
        // The -4 and +8 are added to compansate for the width of the stroke

        // Draw Next Piece Frame
        int x = right_x + 100;
        int y = bottom_y - 200;
        g2.drawRect(x, y, 200, 200);
        g2.setFont(new Font("Arial", Font.PLAIN, 30));
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.drawString("NEXT", x + 60, y + 60);

        // Draw the currentMino
        if (currentMino != null) {
            currentMino.draw(g2);
        }

    }
}
