package swing_version;

public class GameScore {

    private int level = 1;
    private int lines;
    private int score;

    private int dropInterval = 60;

    public void updateAfterLineClear(int linesCleared) {
        if (linesCleared <= 0) {
            return;
        }
        lines += linesCleared;

        // Scoring logic

        switch (linesCleared) {
            case 1:
                score += 40 * level;
                break;
            case 2:
                score += 100 * level;
                break;
            case 3:
                score += 300 * level;
                break;
            case 4:
                score += 1200 * level;
                break;

            default:
                score += 300 * linesCleared * level;
                break;
        }

        // Level increases every 10 lines
        level = 1 + (lines / 10);

        // Drop interval decreases as level increases
        dropInterval = Math.max(10, 60 - (level - 1) * 5);
    }

    public int getLevel() {
        return level;
    }

    public int getLines() {
        return lines;
    }

    public int getScore() {
        return score;
    }

    public int getDropInterval() {
        return dropInterval;
    }
}
