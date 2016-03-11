import com.sun.deploy.net.proxy.RemoveCommentReader;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by Tdh4vnPC on 3/1/2016.
 */
public class Bullet extends GameObject{

    private int speed;

    private Bullet() {
        positionX = 0;
        positionY = 0;
    }

    public Bullet(int positionX, int positionY, int speed,int dame) {//Alt + Inseart
        this.positionX = positionX;
        this.positionY = positionY;
        this.speed = speed;
        this.dame = dame;
        try {
            this.sprite = ImageIO.read(new File("Resources/DAN2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void move() {
        this.positionY -= this.speed;
    }

    private boolean check = true;

    public void update(){
        this.move();
        if(check == true) {
            if (checkCollisionKey()) {
                PlaneManager.getInstance().getPlaneMoveByKey().setHpWidth(PlaneManager.getInstance().getPlaneMoveByKey().getHpWidth() - 5);
                this.sprite = null;
                check = false;
            }
        }
        if(check) {
            if (checkCollisionMouse()) {
                PlaneManager.getInstance().getPlaneMoveByMouse().setHpWidth(PlaneManager.getInstance().getPlaneMoveByMouse().getHpWidth() - 5);
                check = false;
                this.sprite = null;
            }
        }
//        if (checkCollision()){
//
//                PlaneManager.getInstance().getPlaneMoveByKey().setHpWidth(PlaneManager.getInstance().getPlaneMoveByKey().getHpWidth()-getDame());
//                PlaneManager.getInstance().getPlaneMoveByMouse().setHpWidth(PlaneManager.getInstance().getPlaneMoveByMouse().getHpWidth()-getDame());
//                check = false;
//            }
            //viet ham va cham........
//            if(((positionX >= (PlaneManager.getInstance().getPlaneMoveByKey().getPositionX()+ PlaneManager.getInstance().getPlaneMoveByKey().getWidth()))
//                    || ((positionX + 13) <= PlaneManager.getInstance().getPlaneMoveByKey().getPositionX()))
//                    &&(((positionY ) >= (PlaneManager.getInstance().getPlaneMoveByKey().getPositionY()+PlaneManager.getInstance().getPlaneMoveByKey().getHeight()))
//                    || ((positionY + 33 ) >= PlaneManager.getInstance().getPlaneMoveByKey().getHeight())))
//            {
   //         }
//                if(PlaneManager.getInstance().getPlaneMoveByKey().getHpWidth() == 0){
//                    PlaneManager.getInstance().getPlaneMoveByKey();
//            }

    }
    public boolean checkCollisionKey() {
        Rectangle rectBullet = new Rectangle(positionX, positionY, sprite.getWidth(),sprite.getHeight());

        Rectangle rectPlaneKey =
                new Rectangle(PlaneManager.getInstance().getPlaneMoveByKey().getPositionX()
                        , PlaneManager.getInstance().getPlaneMoveByKey().getPositionY()
                        , PlaneManager.getInstance().getPlaneMoveByKey().getWidth()
                        , PlaneManager.getInstance().getPlaneMoveByKey().getHeight());
        return rectBullet.intersects(rectPlaneKey);

    }
    public boolean checkCollisionMouse(){
        Rectangle rectBullet = new Rectangle(positionX,positionY,sprite.getWidth(),sprite.getHeight());

        Rectangle rectPlaneMouse =
                new Rectangle(PlaneManager.getInstance().getPlaneMoveByMouse().getPositionX()
                            ,PlaneManager.getInstance().getPlaneMoveByMouse().getPositionY()
                            ,PlaneManager.getInstance().getPlaneMoveByMouse().getWidth()
                            ,PlaneManager.getInstance().getPlaneMoveByMouse().getHeight());
        return rectBullet.intersects(rectPlaneMouse);
    }
    //Lay toa do cua 2 may bay
    //PlaneManager.getInstance()....

    public void draw(Graphics g){
        g.drawImage(sprite,positionX,positionY,null);
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setdame(int dame) {
        this.dame = dame;
    }

    public int getDame(){
        return dame;
    }
}
