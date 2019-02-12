import java.awt.*;
import java.lang.Math.*;

public class Circle extends Shape{

    Integer r;

    public Circle(Integer posX, Integer posY,Integer r){
        super(posX, posY);
        this.r = r;}

    public double getArea() {

        return Math.PI * this.r * this.r;
    }
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillOval(posX, posY, 2*r, 2*r);
    }
}
