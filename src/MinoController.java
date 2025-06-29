package src;

import src.Tetris_Pieces.Block;
import src.Tetris_Pieces.TetroMino;

public class MinoController {

    public static void handleInput(TetroMino currentMino) {
        // Rotate
        if (KeyHandler.upPressed) {
            currentMino.anchorX = currentMino.b[0].x;
            currentMino.anchorY = currentMino.b[0].y;
            currentMino.rotateRight();
            KeyHandler.upPressed = false;
        }

        // Move Down
        if (KeyHandler.downPressed) {
            for (Block block : currentMino.b) {
                block.y += Block.SIZE;
            }
            currentMino.autoDropCounter = 0;
            KeyHandler.downPressed = false;
        }

        // Move Left
        if (KeyHandler.leftPressed) {
            for (Block block : currentMino.b) {
                block.x -= Block.SIZE;
            }
            KeyHandler.leftPressed = false;
        }

        // Move Right
        if (KeyHandler.rightPressed) {
            for (Block block : currentMino.b) {
                block.x += Block.SIZE;
            }
            KeyHandler.rightPressed = false;
        }
    }
}
