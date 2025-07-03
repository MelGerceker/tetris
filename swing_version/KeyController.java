package swing_version;

import swing_version.Tetris_Pieces.Block;
import swing_version.Tetris_Pieces.TetroMino;

public class KeyController {

    public static void handleInput(TetroMino currentMino) {

        Collision collision = new Collision();
        CollisionResult result = collision.checkMovementCollision(currentMino);

        // Rotate
        if (KeyHandler.upPressed) {
            currentMino.anchorX = currentMino.b[0].x;
            currentMino.anchorY = currentMino.b[0].y;
            currentMino.rotateRight();

            KeyHandler.upPressed = false;
        }

        // Move Down
        if (KeyHandler.downPressed && !result.bottom) {
            for (Block block : currentMino.b) {
                block.y += Block.SIZE;
            }
            currentMino.autoDropCounter = 0;

            KeyHandler.downPressed = false;
        }

        // Move Left
        if (KeyHandler.leftPressed && !result.left) {
            for (Block block : currentMino.b) {
                block.x -= Block.SIZE;
            }

            KeyHandler.leftPressed = false;
        }

        // Move Right
        if (KeyHandler.rightPressed && !result.right) {
            for (Block block : currentMino.b) {
                block.x += Block.SIZE;
            }
            //currentMino.deactivateCounter = 0; // Cancel lock delay

            KeyHandler.rightPressed = false;
        }
    }
}
