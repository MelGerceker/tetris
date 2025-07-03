package swing_version.Tetris_Pieces;

import java.awt.Color;
import java.awt.Point;

public class Mino_T extends TetroMino {

    public Mino_T() {
        create(Color.magenta);

        // Shape layout
        // b[0] is the rotation anchor

        // ...[1]
        // [2][0][3]

        offsets[0] = new Point(0, 0); // anchor
        offsets[1] = new Point(0, -1);
        offsets[2] = new Point(-1, 0);
        offsets[3] = new Point(1, 0);
        setXY(anchorX, anchorY); // apply new positions

    }

    @Override
    protected void setDirection1() {

        // ...[1]
        // [2][0][3]

        offsets[0] = new Point(0, 0); // anchor
        offsets[1] = new Point(0, -1);
        offsets[2] = new Point(-1, 0);
        offsets[3] = new Point(1, 0);
        setXY(anchorX, anchorY); // apply new positions

    }

    @Override
    protected void setDirection2() {

        // [2]
        // [0][1]
        // [3]

        offsets[0] = new Point(0, 0);
        offsets[1] = new Point(1, 0);
        offsets[2] = new Point(0, -1);
        offsets[3] = new Point(0, 1);
        setXY(anchorX, anchorY); // apply new positions
    }

    @Override
    protected void setDirection3() {

        // [3][0][2]
        // ...[1]

        offsets[0] = new Point(0, 0);
        offsets[1] = new Point(0, 1);
        offsets[2] = new Point(1, 0);
        offsets[3] = new Point(-1, 0);
        setXY(anchorX, anchorY); // apply new positions
    }

    @Override
    protected void setDirection4() {

        // [2]
        // [1][0]
        // [3]

        offsets[0] = new Point(0, 0);
        offsets[1] = new Point(-1, 0);
        offsets[2] = new Point(0, -1);
        offsets[3] = new Point(0, 1);
        setXY(anchorX, anchorY); // apply new positions
    }
}
