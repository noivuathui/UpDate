import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by noivu on 3/9/2016.
 */
public class BulletYour extends GameObject {
    private int speed;

    private BulletYour(){
        positionX = 0;
        positionY = 0;
    }

    public BulletYour(int positionX, int positionY, int speed){
        this.positionX = positionX;
        this.positionY = positionY;
        this.speed = speed;

        try {
            this.sprite = ImageIO.read(new File("Resources/DAN.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void move(){
        this.positionY -= speed;
    }

    private boolean check = true;

    public void update(){
        this.move();
        if(check == true){
            for(PlaneEnemy planeEnemy : PlaneEnemyManager.getInstance().getVectorPlaneEnemy()) {
                if (((positionX >= (planeEnemy.getPositionX() + planeEnemy.getWidth()))
                        || ((positionX + 13) <= planeEnemy.getPositionX()))
                        && (((positionY) >= (planeEnemy.getPositionY() + planeEnemy.getHeight()))
                        || ((positionY + 33) >= planeEnemy.getHeight())))
                {

                }
                else {
                    PlaneEnemyManager.getInstance().getVectorPlaneEnemy().remove(PlaneEnemyManager.getInstance().getVectorPlaneEnemy().indexOf(planeEnemy));
                    this.sprite = null;
                    check = false;
                    break;
                }

            }
        }
    }

//    public void checkCollisitionEnemy(){
//        Rectangle rectBulletYour = new Rectangle(positionX, positionY, sprite.getWidth(),sprite.getHeight());
//
//         for(PlaneEnemy planeEnemy : PlaneEnemyManager.getInstance().getVectorPlaneEnemy()) {
//             Rectangle rectPlaneEnemy = new Rectangle(planeEnemy.getPositionX(), planeEnemy.getPositionY(), planeEnemy.getWidth(), planeEnemy.getHeight());
//             if( rectBulletYour.intersects(rectPlaneEnemy)) {
//                 PlaneEnemyManager.getInstance().getVectorPlaneEnemy().remove(PlaneEnemyManager.getInstance().getVectorPlaneEnemy().indexOf(planeEnemy));
//                 //check = false;
//                 break;
//             }
//
//         }
//    }

    public void draw(Graphics g) {
        g.drawImage(sprite,positionX,positionY,null);
    }

//    public boolean checkCollision(){
//        Rectangle rectBullet = new Rectangle(positionX,positionY,sprite.getWidth()
//                ,sprite.getHeight());
//
//        Rectangle rectPlaneEnemy = new Rectangle(PlaneEnemyManager.getInstance().getVectorPlaneEnemy());
//        return rectBullet.intersects(rectPlaneEnemy);
//    }
}
