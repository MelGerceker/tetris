package src;

import java.util.ArrayList;
import src.Tetris_Pieces.Block;

public class LineClearer {

    public static void clearFullLines(ArrayList<Block> staticBlocks, int leftX, int rightX, int topY, int bottomY) {
        int x = leftX;
        int y = topY;
        int blockCount = 0;

        while (x < rightX && y < bottomY) {
            for (int i = 0; i < staticBlocks.size(); i++) {
                if (staticBlocks.get(i).x == x && staticBlocks.get(i).y == y) {
                    blockCount++;
                }
            }

            x += Block.SIZE;

            if (x == rightX) {
                if (blockCount == (rightX - leftX) / Block.SIZE) {
                    for (int i = staticBlocks.size() - 1; i >= 0; i--) {
                        // delete lines
                        if (staticBlocks.get(i).y == y) {
                            staticBlocks.remove(i);
                        }
                    }

                    // slide down blocks above
                    for (Block block : staticBlocks) {
                        if (block.y < y) {
                            block.y += Block.SIZE;
                        }
                    }
                }

                blockCount = 0;
                x = leftX;
                y += Block.SIZE;
            }
        }
    }
}
