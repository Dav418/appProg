package Game;

// code copied from Simon Lucas
// code copied by Udo Kruschwitz


import Objects.food;
import Objects.snake;
import utilities.JEasyFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class GameView extends JComponent
{

    int[][] board;
    int w, h;
    static int size = 20;
    public static food f = new food(size,size);

    public static snake s = new snake(200,200,size,size);

    public GameView(int[][] board)
    {
        setFocusable(true);
        requestFocusInWindow();
        this.board = board;
        w = board.length;
        h = board[0].length;
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            public void keyPressed(KeyEvent e) {

                if (e.getKeyChar() == 'w'){

                    s.setDirLeftStop();
                    s.setDirDownStop();
                    s.setDirRightStop();
                    s.setDirUp();
                }
                else if (e.getKeyChar() == 's'){

                    s.setDirLeftStop();
                    s.setDirRightStop();
                    s.setDirUpStop();
                    s.setDirDown();
                }
                else if (e.getKeyChar() == 'a'){

                    s.setDirRightStop();
                    s.setDirUpStop();
                    s.setDirDownStop();
                    s.setDirLeft();
                }
                else if (e.getKeyChar() == 'd'){

                    s.setDirUpStop();
                    s.setDirDownStop();
                    s.setDirLeftStop();
                    s.setDirRight();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }


public void paintComponent(Graphics g) {

      //  g.setColor(Color.BLACK);
      //  g.fillRect(s.snakeX(), s.snakeY(), size, size); //makes the snake
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (f.getFoodX() == i && f.getFoodY() == j) {
                    g.setColor(Color.GREEN);
                    g.fillRect(f.getFoodX() * GameView.getPixelSize(), f.getFoodY() * GameView.getPixelSize(), size, size); // prints the food object onto the board
                }
            if (s.snakeX(0) == i*GameView.getPixelSize() && s.snakeY(0)==j*GameView.getPixelSize()) {
                g.setColor(Color.BLACK);
                g.fillRect(s.snakeX(0), s.snakeY(0), size, size);
                for (int x = 1; x <= s.getSnakeBits(); x++) {
                    g.fillRect(s.snakeX(x),s.snakeY(x),size,size);
                }
            }
            }
        }


        if ((s.snakeY(0) == (f.getFoodY() * GameView.getPixelSize())) && (s.snakeX(0) == (f.getFoodX() * GameView.getPixelSize()))) { //checks if food has been eaten and if it has make a new food object
            f = new food(size, size);
            s.updateScore();
        }

        if (s.snakeY(0) == 400 || s.snakeX(0) == 400 || s.snakeX(0) == 0 || s.snakeY(0) == 0) { //checks for the snake going out of bounds
            JEasyFrame.gameEnd();
        }
//to do falling text
    if(!JEasyFrame.isGameGoing()){
        g.setColor(Color.WHITE);
        g.fillRect(0,0,420,420);
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        g.drawString("Game Over. Score: " + s.getScore(), 90,200);}
}

    public Dimension getPreferredSize() {
        return new Dimension((w*size)+10, (h*size)+10);
    }

    public static int getPixelSize(){return size;}
    }

