package megamanz;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

class Sprite
{
    public int sx1,sx2,sy1,sy2;
    public Sprite( int sx1, int sy1 , int sx2, int sy2 )
    {
        this.sx1 = sx1;
        this.sx2 = sx2;
        this.sy1 = sy1;
        this.sy2 = sy2;
    }
}

public class Panel extends JPanel
{
    Point Z = new Point(100, 100);
    int bgx = 0;
    int slash_point = 0;
    
    Vector<Point> shoot = new Vector<Point>();
    Vector<Sprite> slash = new Vector<Sprite>();
    
    boolean isup,isdown,isleft,isright,isshoot,isslash;
    
    int animation_index;
    
    Thread thread = new Thread()
    {
        @Override
        public void run() {
            
            while(true)
            {
                repaint();
                try
                {
                    Thread.sleep(20);
                }
                catch(Exception e)
                {
                    
                }
            }
        }
    };
            
    public Panel()
    {
        thread.start();
    }
    
    public void paint(Graphics g)
    {
        
        int imagex1,imagey1,imagex2,imagey2;
        imagex1 = imagex2 = imagey1 = imagey2 = 0;
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(new ImageIcon("images/bg2.jpg").getImage(), bgx, 0, this);
        g2d.drawImage(new ImageIcon("images/bg2.jpg").getImage(), bgx+1000,0,this);
        bgx-=3;
        if(bgx <= -1000)
            bgx=0;
        
        if(!isshoot)
        {
            imagex1 = 799;
            imagey1 = 292;
            imagex2 = 865;
            imagey2 = 344;
        }
        if(isup)
        {
            imagex1 = 186;
            imagey1 = 0;
            imagex2 = 242 ;
            imagey2 = 64;
            
            if(Z.y >=0)
                Z.y -= 3;
        }
        if(isdown)
        {
            imagex1 = 436;
            imagey1 = 66;
            imagex2 = 485;
            imagey2 = 154;
            
            if(Z.y < 420d )
                Z.y+=3;
        }
        if(isleft)
        {
            imagex1 = 656;
            imagey1 = 356;
            imagex2 = 727;
            imagey2 = 412;
            
            if(Z.x >0 )
                Z.x -=3 ;
        }
        if(isright)
        {
            imagex1 = 99;
            imagey1 = 505;
            imagex2 = 202;
            imagey2 = 565;
            
            if(Z.x < 500)
                Z.x +=3;
            bgx-=20;
        }
        /*if(isslash)
        {
            imagex1 = 238;
            imagey1 = 280;
            imagex2 = 334;
            imagey2 = 344;
        }*/
        if(isshoot)
        {
           
            slash.add(new Sprite(238, 280, 334, 344));
             slash.add(new Sprite(48, 288, 100, 348));
            
            imagex1 = slash.get(animation_index/50).sx1;
            imagey1 = slash.get(animation_index/50).sy1;
            imagex2 = slash.get(animation_index/50).sx2;
            imagey2 = slash.get(animation_index/50).sy2;
            
            slash.removeAllElements();
            /*
            imagex1 = 48;
            imagey1 = 288;
            imagex2 = 100;
            imagey2 = 348;
            */
        }
        
        g2d.drawImage(new ImageIcon("images/sprite.png").getImage(), Z.x, Z.y, Z.x + 150, Z.y+150, imagex1, imagey1, imagex2, imagey2, this);
        
        if(animation_index > 0)
        {
            animation_index -=8;
        }
        else
        {
            isshoot = false;
        }
        //g2d.drawImage(new ImageIcon("images/shoot.png").getImage() , Z.x+50, Z.y, Z.x + 125, Z.y+75, 263, 178, 525, 323, this);
        
        for(int i = 0 ; i < shoot.size() ; i++)
        {
            g2d.drawImage(new ImageIcon("images/sprite.png").getImage() , shoot.get(i).x, shoot.get(i).y, shoot.get(i).x + 125, shoot.get(i).y+75, 295, 415, 353, 494, this);
            shoot.get(i).x += 6;
            
            if(shoot.get(i).x > 600 )
            {
                shoot.removeElementAt(i);
            }
            /*
            if(slash_point <= 600)
            {
                slash_point += 40;
            }
            else
            {
                isslash = false;
                slash_point = 0;
            }
           */
        }
       
    }
    
    public void shot()
    {
        shoot.add(new Point(Z.x+80,Z.y+40));
    }
    
}
