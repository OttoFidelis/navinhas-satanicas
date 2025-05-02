package game;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import game.model.Stage;

public class Container extends JFrame {
    public Container(){
        add(new Stage());
        setTitle("Navinhas satânicas");
        setSize(1024, 728);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setResizable(false);
        setVisible(true);
        ImageIcon ref = new ImageIcon("resources\\Player ship\\player002.png");
        setIconImage(ref.getImage());
    }

    public static void main(String[] args){
        new Container();
    }
}
