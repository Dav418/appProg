package Objects;

public abstract class GameObjects {
    public int posX;
    public int posY;
    public int width;
    public int height;
    public GameObjects(int posX, int posY,int width,int height){
        this.posX=posX;
        this.posY=posY;
        this.width=width;
        this.height=height;
    }

    protected GameObjects() {
    }
}
