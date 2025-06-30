package src.Tetris_Pieces;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

import src.KeyHandler;
import src.PlayAreaManager;

public abstract class TetroMino {

    public Block[] b = new Block[4];
    protected Point[] offsets = new Point[4];

    public int anchorX;
    public int anchorY;

    public int autoDropCounter = 0;

    public int direction = 1; // 4 directions

    public boolean leftCollision;
    boolean rightCollision;
    boolean bottomCollision;

    public TetroMino() {

        // Logic of offset = Point (x,y)
        // x = horizontal, postive = right
        // y = vertical, positive = down

    }

    public void create(Color c) {
        for (int i = 0; i < 4; i++) {
            b[i] = new Block(c);
        }
    }

    public void setXY(int x, int y) {
        anchorX = x;
        anchorY = y;
        for (int i = 0; i < 4; i++) {
            b[i].x = x + offsets[i].x * Block.SIZE;
            b[i].y = y + offsets[i].y * Block.SIZE;
        }

    }

    public void rotateRight() {
        // Backup current block positions
        // Used for if collision is detected and rotation can not be done.
        Point[] originalOffsets = new Point[4];
        for (int i = 0; i < 4; i++) {
            originalOffsets[i] = new Point(offsets[i]);
        }

        int previousDirection = direction;

        direction++;
        if (direction > 4) {
            direction = 1;
        }

        applyRotation(direction);

        // TODO: check for collision
    
    }

    private void applyRotation(int dir) {
        switch (dir) {
            case 1:
                setDirection1();
                break;
            case 2:
                setDirection2();
                break;
            case 3:
                setDirection3();
                break;
            case 4:
                setDirection4();
                break;
            default:
                break;
        }
    }

    protected abstract void setDirection1();

    protected abstract void setDirection2();

    protected abstract void setDirection3();

    protected abstract void setDirection4();

    public void updateAutoDrop() {
        autoDropCounter++;
        if (autoDropCounter >= PlayAreaManager.dropInterval) {
            for (Block block : b) {
                block.y += Block.SIZE;
            }
            autoDropCounter = 0;
        }
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

}
