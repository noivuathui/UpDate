import java.awt.image.BufferedImage;

/**
 * Created by Tdh4vnPC on 3/1/2016.
 */
public abstract class GameObject {
    public int dame;
    public int hpWidth = 40 ;
    public int hpHeight = 5;
    public int positionX;
    public int positionY;
    public BufferedImage sprite;

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

    public BufferedImage getSprite() {
        return sprite;
    }

    public void setSprite(BufferedImage sprite) {
        this.sprite = sprite;
    }

    public int getHpWidth() {
        return hpWidth;
    }

    public void setHpWidth(int hpWidth) {
        this.hpWidth = hpWidth;
    }

    public int getHpHeight() {
        return hpHeight;
    }

    public void setHpHeight(int hpHeight) {
        this.hpHeight = hpHeight;
    }

    public int getDame() {
        return dame;
    }

    public void setDame(int dame) {
        this.dame = dame;
    }
}