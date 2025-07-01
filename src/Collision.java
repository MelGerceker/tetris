package src;

import src.Tetris_Pieces.TetroMino;

import java.awt.Point;

import src.Tetris_Pieces.Block;

public class Collision {

    private TetroMino mino;
    // private PlayAreaManager manager;

    public Collision(TetroMino mino) {
        this.mino = mino;
    }

    public CollisionResult checkMovementCollision(TetroMino mino) {

        CollisionResult result = new CollisionResult();

        checkStaticBlockCollision(mino, result);

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

    public boolean checkRotationalCollision(Point[] testPositions) {

        CollisionResult result = new CollisionResult();

        checkStaticBlockCollision(mino, result);
        for (Point p : testPositions) {

            // checkStaticBlockCollision();

            if (p.x < PlayAreaManager.left_x
                    || p.x + Block.SIZE > PlayAreaManager.right_x
                    || p.y + Block.SIZE > PlayAreaManager.bottom_y) {
                return true;
            }
        }
        return false;

    }

    private void checkStaticBlockCollision(TetroMino mino, CollisionResult result) {

        for (int i = 0; i < PlayAreaManager.staticBlocks.size(); i++) {

            int targetX = PlayAreaManager.staticBlocks.get(i).x;
            int targetY = PlayAreaManager.staticBlocks.get(i).y;

            /*
             * // check down
             * for (int j = 0; j < mino.b.length; j++) {
             * System.out.println("DEBUG: b[j] is " + mino.b[j]);
             * 
             * if (mino.b[j].y + Block.SIZE == targetY && mino.b[j].x == targetX) {
             * result.bottom = true;
             * }
             * }
             * 
             * // check left
             * for (int j = 0; j < mino.b.length; j++) {
             * if (mino.b[j].x - Block.SIZE == targetX && mino.b[j].y == targetY) {
             * result.left = true;
             * }
             * }
             * 
             * // check right
             * for (int j = 0; j < mino.b.length; j++) {
             * if (mino.b[j].x + Block.SIZE == targetX && mino.b[j].y == targetY) {
             * result.right = true;
             * }
             * }
             */

            if (mino == null || mino.b == null) {
                System.out.println("ERROR: mino or mino.b is null in checkStaticBlockCollision!");
                return;
            }

            for (Block b : mino.b) {

                // check down
                if (b.y + Block.SIZE == targetY && b.x == targetX) {
                    result.bottom = true;
                }
                // check left
                if (b.x - Block.SIZE == targetX && b.y == targetY) {
                    result.left = true;
                }
                // check right
                if (b.x + Block.SIZE == targetX && b.y == targetY) {
                    result.right = true;
                }

            }
        }

    }
}
