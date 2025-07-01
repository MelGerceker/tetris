package src;

import java.util.ArrayList;
import src.Tetris_Pieces.Block;

public class LineClearer {

    // public int lineCount;

    public static int clearFullLines(ArrayList<Block> staticBlocks, int leftX, int rightX, int topY, int bottomY) {
        // int x = leftX;
        int y = topY;
        // int blockCount = 0;
        int linesCleared = 0;

        while (y < bottomY) {
            int blockCount = 0;

            // Count how many blocks are in this row
            for (Block block : staticBlocks) {
                if (block.y == y) {
                    blockCount++;
                }
            }

            // Check if the row is full
            if (blockCount == (rightX - leftX) / Block.SIZE) {
                // Remove the blocks in the full line
                for (int i = staticBlocks.size() - 1; i >= 0; i--) {
                    if (staticBlocks.get(i).y == y) {
                        staticBlocks.remove(i);
                    }
                }

                // Slide down all blocks above
                for (Block block : staticBlocks) {
                    if (block.y < y) {
                        block.y += Block.SIZE;
                    }
                }

                linesCleared++;

                // Re-check the same y level, because lines above just moved down
                continue;
            }

            // Move to the next row
            y += Block.SIZE;
        }

        return linesCleared;

    }
}
