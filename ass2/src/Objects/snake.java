package Objects;


import Game.GameView;
import com.sun.xml.internal.ws.wsdl.writer.document.soap.Body;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class snake extends GameObjects {

    private boolean left = true;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false;
    private static int speed = GameView.getPixelSize();

    private List<Integer> sX = new ArrayList<>(bodyBits);
    private List<Integer> sY = new ArrayList<>(bodyBits);

    private List<Integer> sX2;
    private List<Integer> sY2;

    private static int bodyBits = 3;

    private int score = 0;

    public snake(int posX, int posY,int width,int height ){
        super(posX, posY,width,height);

        for (int i = 0; i < bodyBits;i++){
            sX.add(posX+(speed*i));
            sY.add(posY+(speed));  // initialize the snake body
            }
    }



    public void snakeMove(){

        if (up){posY -= speed;
        sY.add(0,posY);
                }
        else if (down){posY += speed;
            sY.add(0,posY);
               }
        else if (left){posX -= speed;
            sX.add(0,posX);

        }
        else if (right){posX += speed;
            sX.add(0,posX);
        }
        if(bodyBits > sX.size()){
            sX.add(bodyBits,sX.get(bodyBits-1));
            sY.add(bodyBits,sX.get(bodyBits-1));
        }
        int temp;

        //to do make the snake shit position correctly
        for(int i = bodyBits; i > 1; i--){
            temp = sX.get(i-1);
            sX.add(i,temp);

            temp = sY.get(i-1);
            sY.add(i,temp);

            System.out.println("x"+i + ":"+ sX.get(i));
            System.out.println("y"+i + ":"+ sY.get(i));
        }
        System.out.println("x1"+  ":"+ sX.get(0));
        System.out.println("y1"+  ":"+ sY.get(0));
        System.out.println();


}
    public int snakeX(int i){return sX.get(i);}
    public int snakeY(int i){return sY.get(i);}


    public void setDirLeft(){left = true;}
    public void setDirLeftStop(){left = false;}


    public void setDirRight(){right = true;}
    public void setDirRightStop(){right = false;}


    public void setDirUp(){up = true;}
    public void setDirUpStop(){up = false;}


    public void setDirDown(){down = true;}
    public void setDirDownStop(){down = false;}

    public void updateScore(){score += 1;}
    public int getScore(){return score;}

    public void updateSnakeBits(){ bodyBits++;}
    public int getSnakeBits(){return bodyBits;}
}
