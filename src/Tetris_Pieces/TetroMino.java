package src.Tetris_Pieces;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public abstract class TetroMino {

    public Block[] b = new Block[4];
    protected Point[] offsets = new Point[4];

    // public Block[] tempB = new Block[4];

    public TetroMino() {
        for (int i = 0; i < 4; i++) {
            offsets[i] = new Point(0, 0);
        }
    }

    public void create(Color c) {
        for (int i = 0; i < 4; i++) {
            b[i] = new Block(c);
        }
    }

    public void setXY(int x, int y) {
        for (int i = 0; i < 4; i++) {
            b[i].x = x + offsets[i].x * Block.SIZE;
            b[i].y = y + offsets[i].y * Block.SIZE;
        }

    }

    public void updateXY(int direction) {

    }

    public void update() {

    }

    public void draw(Graphics2D g2) {
        int margin = 2;
        for (int i = 0; i < 4; i++) {
            g2.setColor(b[i].c);
            g2.fillRect(
                    b[i].x + margin,
                    b[i].y + margin,
                    Block.SIZE - (margin * 2),
                    Block.SIZE - (margin * 2));
        }
    }

    public abstract void rotateRight();

}
