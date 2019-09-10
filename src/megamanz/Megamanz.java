package megamanz;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.plaf.SliderUI;


public class Megamanz implements KeyListener{

    JFrame frame = new JFrame();
    Panel pane = new Panel();
    
    long last_time = System.currentTimeMillis();
    long curr_time = last_time + 1000;
    
    public Megamanz()
    {
        frame.add(pane);
        frame.addKeyListener(this);
        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) 
    {
        new Megamanz();
    }

    @Override
    public void keyTyped(KeyEvent e) {
       
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        if(e.getKeyCode() == KeyEvent.VK_W)
        {
            pane.isup = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_D )
        {
            pane.isright = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_S)
        {
            pane.isdown = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_A)
        {
            pane.isleft = true;
        }
        
         
        if(e.getKeyCode() == KeyEvent.VK_0)
        {
            curr_time = System.currentTimeMillis();
            if((curr_time - last_time) > 200)
            {
                pane.isshoot = true;
                
                pane.animation_index = 99;
                pane.shot();
                
            }
            last_time = System.currentTimeMillis();
        }
        
        
        
    }

    @Override
    public void keyReleased(KeyEvent e) 
    {
        if(e.getKeyCode() == KeyEvent.VK_W)
        {
            pane.isup = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_D )
        {
            pane.isright = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_S)
        {
            pane.isdown = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_A)
        {
            pane.isleft = false;
        }
        
    }
}
