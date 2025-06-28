package src.Tetris_Pieces;

import java.awt.Color;
import java.awt.Point;

public class Mino_Square extends TetroMino{

        public Mino_Square() {
        create(Color.yellow);

        // Shape layout
        // b[0] is the rotation anchor

        //[1][2]
        //[0][3]

        offsets[0] = new Point(0, 0); // anchor
        offsets[1] = new Point(0, -1); 
        offsets[2] = new Point(1, -1); 
        offsets[3] = new Point(1, 0); 
    }

    @Override
    public void rotateRight() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'rotateRight'");
    }
}
