package src.Tetris_Pieces;

import java.awt.Color;
import java.awt.Point;

public class Mino_L1 extends TetroMino {

    public Mino_L1() {
        create(Color.orange);

        // Shape layout
        // b[0] (!) is the rotation anchor

        // o
        // o !
        // o o

        offsets[0] = new Point(0, 0); // anchor
        offsets[1] = new Point(0, -1); // above
        offsets[2] = new Point(0, 1); // below
        offsets[3] = new Point(1, 1); // bottom-right
    }

    @Override
    public void rotateRight() {
        // for (var p : offsets) {
        // int temp = p.x;
        // p.x = -p.y;
        // p.y = temp;
        // }
    }
}
