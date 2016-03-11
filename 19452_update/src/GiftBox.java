import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by noivu on 3/9/2016.
 */
public class GiftBox extends GameObject{
//    public GiftBox(){
//        this.positionX = positionX;
//        this.positionY = positionY;
//    }



    public GiftBox(int positionX, int positionY){
        this.positionX = positionX;
        this.positionY = positionY;
        try {
            this.sprite = ImageIO.read(new File("Resources/gift.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void move(){

    }

    private boolean check = true;

    public void update(){
        this.move();
        if(check == true){
            if(checkCollision()) {
                PlaneEnemyManager.getInstance().getVectorPlaneEnemy().clear();
                check = false;
                this.sprite = null;
            }
        }

            //this.sprite = null;
}
    public boolean checkCollision(){
        Rectangle rectGift = new Rectangle(positionX,positionY,sprite.getWidth()
                ,sprite.getHeight());
        Rectangle rectPlaneKey =
                new Rectangle(PlaneManager.getInstance().getPlaneMoveByKey().getPositionX()
                        ,PlaneManager.getInstance().getPlaneMoveByKey().getPositionY()
                        ,PlaneManager.getInstance().getPlaneMoveByKey().getWidth()
                        ,PlaneManager.getInstance().getPlaneMoveByKey().getHeight());
        return rectGift.intersects(rectPlaneKey);
    }

    public void draw(Graphics g){
        g.drawImage(sprite,positionX,positionY,null);
        //if(check == 1){
          //  draw(null);
            //g.drawImage(null,0,0,null);
       // }
    }
}
