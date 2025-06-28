package src;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Tetris");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        // Add game screen here so that the screen actually launches at the center of
        // the screen
        GameScreen game = new GameScreen();
        frame.add(game);
        frame.pack(); // the size of gamescreen becomes the size of the window

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        game.launchGame();
    }
}
