package src;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;

public class GameScreen {

    public GameScreen() {

        JFrame frame = new JFrame("FrameDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600, 800));

        frame.getContentPane().setBackground(Color.BLUE);

        frame.setBackground(Color.blue);

        frame.pack();
        frame.setVisible(true);

        // System.out.print("test the game screen");

    }

}