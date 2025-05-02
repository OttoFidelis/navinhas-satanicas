package game.model;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Player {
    private int x,y;
    private int dx,dy;
    private Image sprite;
    private int height,width;
    private List<PlayerShot> playerShots;
    private Set<Integer> pressedKeys = new HashSet<>();
    private int shotCounter = 0;
    private static final int SHOT_DELAY = 6;
    private static final int SPEED = 4;
    private static final int FOCUS_SPEED = 2;
    private int lastDx = 0;
    private static final int SCREEN_WIDTH = 1024;
    private static final int SCREEN_HEIGHT = 728;


    public Player(){
        this.x = 1024/2;
        this.y = 720/2;

        playerShots = new ArrayList<PlayerShot>();
    }

    public void load(){
        ImageIcon reference = new ImageIcon();
        if (dx==0) {
            reference = new ImageIcon("resources\\Player ship\\player002.png");
        }
        if (dx<0){
            reference = new ImageIcon("resources\\Player ship\\player001.png");
        }
        if (dx>0){
            reference = new ImageIcon("resources\\Player ship\\player003.png");
        }
        sprite = reference.getImage();
        this.height = sprite.getHeight(null);
        this.width  = sprite.getWidth(null);
    }

    public void update(){
        dx=0;dy=0;
        
        if (shotCounter > 0) {
            shotCounter--;
        }
        if(pressedKeys.contains(KeyEvent.VK_SPACE)&& shotCounter==0){
            shotCounter=SHOT_DELAY;
            simpleShot();
        }

        if(pressedKeys.contains(KeyEvent.VK_W)){
            dy=pressedKeys.contains(KeyEvent.VK_SHIFT) ? -FOCUS_SPEED:-SPEED;
        }
        if(pressedKeys.contains(KeyEvent.VK_S)){
            dy=pressedKeys.contains(KeyEvent.VK_SHIFT) ? FOCUS_SPEED:SPEED;
        }
        if(pressedKeys.contains(KeyEvent.VK_A)){
            dx=pressedKeys.contains(KeyEvent.VK_SHIFT) ? -FOCUS_SPEED:-SPEED;
        }
        if(pressedKeys.contains(KeyEvent.VK_D)){
            dx=pressedKeys.contains(KeyEvent.VK_SHIFT) ? FOCUS_SPEED:SPEED;
        }

        if(x>SCREEN_WIDTH) x=-width*3;
        if(x<(-width*3))x=SCREEN_WIDTH;

        x+=dx;
        y+=dy;

        if(dx !=lastDx){
            load();
            lastDx=dx;
        }
    }

    public void simpleShot(){
        this.playerShots.add(new PlayerShot(x+width, y+(height/2)));
    }

    public void keyPressed(KeyEvent key){
        pressedKeys.add(key.getKeyCode());
    }

    public void keyReleased(KeyEvent key){
        pressedKeys.remove(key.getKeyCode());
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

    public Image getSprite() {
        return sprite;
    }

    public void setSprite(Image sprite) {
        this.sprite = sprite;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public List<PlayerShot> getPlayerShots() {
        return playerShots;
    }

    public void setPlayerShots(List<PlayerShot> playerShots) {
        this.playerShots = playerShots;
    }
    
}
