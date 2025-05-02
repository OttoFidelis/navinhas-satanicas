package game.model;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Stage extends JPanel implements ActionListener{
    private Image background;
    private Player player;
    private Timer timer;

    public Stage(){
        setFocusable(true);
        setDoubleBuffered(true);
        ImageIcon reference = new ImageIcon("resources\\Space_BG (2 frames) (64 x 64).png");
        background = reference.getImage();
        player = new Player();
        player.load();
        addKeyListener(new InputAdapter());
        timer = new Timer(5, this);
        timer.start();
    }

    public void paint(Graphics g){
        Graphics2D graphics = (Graphics2D) g;
        graphics.drawImage(background, 0, 0, getWidth(), getHeight(), null);
        graphics.drawImage(player.getSprite(), player.getX(),player.getY(), player.getWidth()*3, player.getHeight()*3, this);

        List<PlayerShot> playerShots = player.getPlayerShots();
        for(PlayerShot shot : playerShots){

            PlayerShot m = shot;

            m.load();
            graphics.drawImage(m.getSprite(), m.getX(), m.getY(), this);
        }
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        player.update();
        List<PlayerShot> playerShots = player.getPlayerShots();
        List<PlayerShot> toRemove = new ArrayList<>();
        for(PlayerShot shot : playerShots){

            PlayerShot m = shot;

            if(m.isVisible()) m.update(); 
            else toRemove.add(shot);
        }
        playerShots.removeAll(toRemove);
        repaint();
    }

    private class InputAdapter extends KeyAdapter{

        @Override
        public void keyPressed(KeyEvent e){
            player.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e){
            player.keyReleased(e);
        }
    } 
}
