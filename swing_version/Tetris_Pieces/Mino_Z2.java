package swing_version.Tetris_Pieces;

import java.awt.Color;
import java.awt.Point;

public class Mino_Z2 extends TetroMino {
    public Mino_Z2() {
        create(Color.green);

        // Shape layout
        // b[0] is the rotation anchor

        // ...[1][2]
        // [3][0]

        offsets[0] = new Point(0, 0); // anchor
        offsets[1] = new Point(0, -1);
        offsets[2] = new Point(1, -1);
        offsets[3] = new Point(-1, 0);

        setXY(anchorX, anchorY); // apply new positions

    }

    @Override
    public void setDirection1() {
        // ...[1][2]
        // [3][0]

        offsets[0] = new Point(0, 0); // anchor
        offsets[1] = new Point(0, -1);
        offsets[2] = new Point(1, -1);
        offsets[3] = new Point(-1, 0);
        setXY(anchorX, anchorY); // apply new positions

    }

    @Override
    public void setDirection2() {

        // [3]
        // [0][1]
        // ...[2]

        offsets[0] = new Point(0, 0); // anchor
        offsets[1] = new Point(1, 0);
        offsets[2] = new Point(1, 1);
        offsets[3] = new Point(0, -1);
        setXY(anchorX, anchorY); // apply new positions

    }

    @Override
    public void setDirection3() {
        setDirection1();
    }

    @Override
    public void setDirection4() {
        setDirection2();
    }
}
