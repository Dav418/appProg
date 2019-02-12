import java.awt.*;

public abstract class Shape

{
    public int posX;
    public int posY;

    public Shape(int posX, int posY)
    {
        this.posX=posX;
        this.posY=posY;
    }

    public abstract void draw(Graphics g);
}