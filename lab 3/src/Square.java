import java.awt.*;

public class Square extends Shape {

    Integer sideLength;

    public Square(Integer posX, Integer posY, Integer sideLength) {

        // So here your would call super (constructor of the abstract class)
        super(posX, posY);
        // initialisation
        this.sideLength = sideLength;
    }
    // A method to calculate and return the calculated area of the square.
    // Used to get the area of the square and display in text field in GUI
    public Integer getArea() {

        return sideLength*sideLength;
    }
    // overridden method for drawing the square and filling it a particular colour,
    // see grey highlighted parts of the code referring to where this is called.

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect(this.posX, this.posY, this.sideLength, this.sideLength);
    }
}