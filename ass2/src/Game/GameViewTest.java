package Game;

// code copied from Simon Lucas
// code copied by Udo Kruschwitz
// code updated by Ian Daly


import utilities.JEasyFrame;
import java.util.Random;


public class GameViewTest
{
    public static void main(String[] args)
    {

        int w = 20;
        int h = 20;
        int[][] board = new int[w][h];

        GameView tv = new GameView(board);
        new JEasyFrame(tv, "SSSSNAKE BIIIIITCH");
    }
}