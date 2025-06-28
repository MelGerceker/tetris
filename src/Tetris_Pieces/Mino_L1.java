package src.Tetris_Pieces;

import java.awt.Color;

public class Mino_L1 extends TetroMino {

    public Mino_L1() {
        create(Color.orange);

        // Shape layout
        // b[0] (!) is the rotation anchor

        // o
        // o !
        // o o

        offsets[0].x = 0;
        offsets[0].y = 0; // center
        offsets[1].x = 0;
        offsets[1].y = -1; // above
        offsets[2].x = 0;
        offsets[2].y = 1; // below
        offsets[3].x = 1;
        offsets[3].y = 1; // bottom-right
    }

    @Override
    public void rotateRight() {
        //for (var p : offsets) {
          //  int temp = p.x;
            //p.x = -p.y;
           // p.y = temp;
        //}
    }
}
