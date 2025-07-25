package swing_version;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.Random;

import swing_version.Tetris_Pieces.Block;
import swing_version.Tetris_Pieces.Mino_Bar;
import swing_version.Tetris_Pieces.Mino_L1;
import swing_version.Tetris_Pieces.Mino_L2;
import swing_version.Tetris_Pieces.Mino_Square;
import swing_version.Tetris_Pieces.Mino_T;
import swing_version.Tetris_Pieces.Mino_Z1;
import swing_version.Tetris_Pieces.Mino_Z2;
import swing_version.Tetris_Pieces.TetroMino;

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
    TetroMino nextMino;
    final int NEXTMINO_X;
    final int NEXTMINO_Y;
    public static ArrayList<Block> staticBlocks = new ArrayList<>();

    // public static int dropInterval = 60;
    boolean gameOver;

    GameScore gameScore = new GameScore();

    public PlayAreaManager() {

        // Main Play Area Frame
        left_x = (GameScreen.WIDTH / 2) - (WIDTH / 2);
        right_x = left_x + WIDTH;
        top_y = 50;
        bottom_y = top_y + HEIGHT;

        MINO_START_X = left_x + (WIDTH / 2) - Block.SIZE;
        MINO_START_Y = top_y + Block.SIZE;

        NEXTMINO_X = right_x + 175;
        NEXTMINO_Y = top_y + 500;

        // Set the starting Mino
        currentMino = pickRandom();
        currentMino.setXY(MINO_START_X, MINO_START_Y);
        nextMino = pickRandom();
        nextMino.setXY(NEXTMINO_X, NEXTMINO_Y);
    }

    private TetroMino pickRandom() {

        TetroMino mino = null;
        int i = new Random().nextInt(6);

        // set to 6 for now since L2 does not work fully yet.

        switch (i) {
            case 0:
                mino = new Mino_L1();
                break;
            case 1:
                mino = new Mino_Square();
                break;
            case 2:
                mino = new Mino_Z1();
                break;
            case 3:
                mino = new Mino_Z2();
                break;
            case 4:
                mino = new Mino_Bar();
                break;
            case 5:
                mino = new Mino_T();
                break;
            // case 6: mino = new Mino_L2(); break;
            default:
                break;

        }
        return mino;
    }

    public void update() {

        if (!currentMino.active) {
            staticBlocks.add(currentMino.b[0]);
            staticBlocks.add(currentMino.b[1]);
            staticBlocks.add(currentMino.b[2]);
            staticBlocks.add(currentMino.b[3]);

            // check if the game is over
            if (currentMino.b[0].x == MINO_START_X && currentMino.b[0].y == MINO_START_Y) {
                gameOver = true;
            }

            int linesCleared = LineClearer.clearFullLines(staticBlocks, left_x, right_x, top_y, bottom_y);
            gameScore.updateAfterLineClear(linesCleared);

            currentMino = nextMino;
            currentMino.setXY(MINO_START_X, MINO_START_Y);
            nextMino = pickRandom();
            nextMino.setXY(NEXTMINO_X, NEXTMINO_Y);

        } else {

            KeyController.handleInput(currentMino);
            currentMino.updateAutoDrop(gameScore.getDropInterval());
            currentMino.updateLockDelay();

            //LineClearer.clearFullLines(staticBlocks, left_x, right_x, top_y, bottom_y);
        }
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

        // Draw Score Frame
        g2.drawRect(x, top_y, 250, 300);
        x += 40;
        y = top_y + 90;
        g2.drawString("LEVEL: " + gameScore.getLevel(), x, y);
        y += 70;
        g2.drawString("LINES: " + gameScore.getLines(), x, y);
        y += 70;
        g2.drawString("SCORE: " + gameScore.getScore(), x, y);

        // Draw the currentMino
        if (currentMino != null) {
            currentMino.draw(g2);
        }

        // Draw the nextMino
        nextMino.draw(g2);

        // Draw Static Blocks
        for (int i = 0; i < staticBlocks.size(); i++) {
            staticBlocks.get(i).draw(g2);
        }

        g2.setColor(Color.WHITE);
        g2.setFont(g2.getFont().deriveFont(50f));
        // Draw Game over
        if (gameOver) {
            x = left_x + 70;
            y = top_y + 320;
            g2.drawString("Game Over", x, y);

        } else if (KeyHandler.pausePressed) {
            // Draw Pause
            x = left_x + 70;
            y = top_y + 320;
            g2.drawString("Paused", x, y);
        }

    }
}
