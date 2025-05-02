package game.model;

import java.awt.Image;

import javax.swing.ImageIcon;

public class PlayerShot {
    private Image sprite;
    private int x,y;
    private int width, height;
    private boolean isVisible;
    private static final int HEIGHT = 928;
    private static final int SPEED = 7;
    private int shotCounter;
    
    public PlayerShot(int x, int y){
        this.x = x;
        this.y = y;
        isVisible = true;
    }

    public void load(){
        ImageIcon reference = new ImageIcon("resources\\Projectiles\\player_squareshot001.png");
        sprite = reference.getImage();
        this.width = sprite.getWidth(null);
        this.height = sprite.getHeight(null);
    }

    public void update(){
        this.y -= SPEED;
        if(this.y > HEIGHT){
            isVisible = false;
        }
    }

    public Image getSprite() {
        return sprite;
    }

    public void setSprite(Image sprite) {
        this.sprite = sprite;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    public static int getSpeed() {
        return SPEED;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    
}
