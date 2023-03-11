package Lab2.App3;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Window extends JFrame implements Observer {

    ArrayList<JPanel> squares=new ArrayList<JPanel>();
    int score;


    public Window() {
        setLayout(null);
        setSize(450,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        init(3);
        this.setVisible(true);
        score=0;

    }
    private void init(int n){
        for(int i=0 ;i<n; i++){
            JPanel square=new JPanel();
            square.setLocation((i+1)*100,0);
            square.setSize(50,50);
            square.setBackground(Color.BLUE);
            square.setVisible(true);
            this.add(square);
            this.squares.add(square);
        }
    }
    @Override
    public void update(Observable o, Object arg) {
        squares.get(((Square)o).getId()).setLocation(((Square)o).getX(),((Square)o).getY());
    }
}