package Lab2.App4;
        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.KeyEvent;
        import java.awt.event.KeyListener;
        import java.util.ArrayList;
        import java.util.Observable;
        import java.util.Observer;

public class Window extends JFrame implements Observer {

    ArrayList<JPanel> squares=new ArrayList<JPanel>();
    JLabel score;
    JLabel lives;
    JPanel player;


    int speed = 2;
    public Window() {
        setLayout(null);
        setSize(450,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        init(3);
        this.setVisible(true);
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
        score=new JLabel();
        score.setText("Score: "+ 0);
        score.setBounds(360,0,50,50);
        score.setVisible(true);
        this.add(score);

        lives=new JLabel();
        lives.setText("Lives: "+ 3);
        lives.setBounds(360,15,50,50);
        lives.setVisible(true);
        this.add(lives);

        player = new JPanel();
        player.setLocation(5,330);
        player.setSize(10,30);
        player.setBackground(Color.BLACK);
        player.setVisible(true);
        this.addKeyListener(new CustomeKeyListener());
        this.add(player);
    }

    public boolean collision(int firstX,int firstY, int firstWidth, int firstHeight, int secondX,int secondY, int secondWidth, int secondHeight){
        if(firstX>=secondX && firstX<=secondX+secondWidth && firstY>=secondY && firstY<=secondY+secondHeight)
            return true;
        if(firstX+firstWidth>=secondX && firstX+firstWidth<=secondX+secondWidth && firstY>=secondY && firstY<=secondY+secondHeight)
            return true;
        if(firstX>=secondX && firstX<=secondX+secondWidth && firstY+firstHeight>=secondY && firstY+firstHeight<=secondY+secondHeight)
            return true;
        if(firstX+firstWidth>=secondX && firstX+firstWidth<=secondX+secondWidth && firstY+firstHeight>=secondY && firstY+firstHeight<=secondY+secondHeight)
            return true;
        return false;
    }

    @Override
    public void update(Observable o, Object arg) {
        squares.get(((Lab2.App4.Square)o).getId()).setLocation(((Lab2.App4.Square)o).getX(),((Lab2.App4.Square)o).getY());
        boolean hit=false;
        for(int i=0;i<3;i++){
            JPanel square = squares.get(i);
            if(collision(player.getX(), player.getY(), player.getWidth(), player.getHeight(), square.getX(), square.getY(), square.getWidth(), square.getHeight())) {
                player.setLocation(5, 330);
                int oldLives = Integer.parseInt(lives.getText().split(" ")[1]);
                if(oldLives>0) {
                    lives.setText("Lives: " + (oldLives - 1));
                }
                else{
                    ((Lab2.App4.Square)o).stop();
                    this.remove(player);
                }
            }
        }
    }


    class CustomeKeyListener implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                player.setLocation(player.getX()+speed, player.getY());
                if(player.getX() >= 450){
                    player.setLocation(5,330);
                    String oldScore = score.getText().split(" ")[1];
                    score.setText("Score: "+ (Integer.parseInt(oldScore)+1));
                }

            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}
