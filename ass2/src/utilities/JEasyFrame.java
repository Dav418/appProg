package utilities;

// code copied from Simon Lucas
// code copied by Udo Kruschwitz


import Game.GameView;
import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class JEasyFrame extends JFrame {
    private Component comp;
    private static boolean game_going = true;
    public JEasyFrame(Component comp, String title) {


        super(title);
        this.comp = comp;
        getContentPane().add(BorderLayout.CENTER, comp);
        pack();
        this.setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        repaint();
        startTimer();


    }

    public void startTimer()
    {
        Timer timer = new Timer();
        TimerTask task = new TimerTask()
        {
            public void run()
            {
                if (isGameGoing())
                {
                    GameView.s.snakeMove();
                    repaint();
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 200);
    }
    public static void gameEnd(){
        game_going = false;

    }
    public static boolean isGameGoing(){return game_going;}

}
