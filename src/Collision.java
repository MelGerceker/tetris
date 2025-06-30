package src;

import src.Tetris_Pieces.TetroMino;
import src.Tetris_Pieces.Block;

public class Collision {

    private TetroMino mino;
    // private PlayAreaManager manager;

    public Collision(TetroMino mino) {
        this.mino = mino;
    }

    /*
     * public void checkMovementCollision() {
     * 
     * // Check frame collisions
     * // Left wall
     * for (int i = 0; i < b.length; i++) {
     * if (b[i].x == PlayAreaManager.left_x) {
     * leftCollision = true;
     * }
     * }
     */

    public CollisionResult checkMovementCollision(TetroMino mino) {
        CollisionResult result = new CollisionResult();
        for (Block block : mino.b) {
            
            // Edges are used to account for blocks where the anchor is not in the edges.
            int leftEdge = block.x - Block.SIZE;
            int rightEdge = block.x + Block.SIZE;
            int bottomEdge = block.y + Block.SIZE;

            if (leftEdge < PlayAreaManager.left_x) {
                result.left = true;
            }
            if (rightEdge >= PlayAreaManager.right_x) {
                result.right = true;
            }
            if (bottomEdge >= PlayAreaManager.bottom_y) {
                result.bottom = true;
            }
        }

        return result;
    }

    public void checkRotationalCollision() {

    }

}
