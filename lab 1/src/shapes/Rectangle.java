package shapes;

public class Rectangle extends Shape

{
    protected int X;
    protected int Y;
    protected int rect_w;
    protected int rect_h;

    public Rectangle(){
        this.name="rectangle";
        this.X=X;
        this.Y=Y;
        this.rect_w=rect_w;
        this.rect_h=rect_h;
    }

    public Rectangle(int X,int Y,int rect_w,int rect_h)

    {
        this.name="rectangle";
        this.X=X;
        this.Y=Y;
        this.rect_w=rect_w;
        this.rect_h=rect_h;
}

    public void draw()

    {
        System.out.println("This is a rectangle with a start point of " + X + ","+Y+", a width of "+ rect_w
        +" and a height of "+rect_h);
    }
}