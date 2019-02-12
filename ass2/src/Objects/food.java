package Objects;


import Game.GameView;

import java.util.Random;

public class food extends GameObjects{
    Random r = new Random();
    public food(int width,int height ){
        this.posX =(r.nextInt(GameView.getPixelSize())) ;
        this.posY =(r.nextInt(GameView.getPixelSize())) ;
        this.width= width;
        this.height=height;
}

  public int getFoodX(){

        return posX;}

  public int getFoodY(){

        return posY;}


}
