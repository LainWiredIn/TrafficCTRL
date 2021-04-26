package trafficctrlv3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Lain()
 */
public class CTRLv3 extends JFrame implements ActionListener
{
    JLabel l1;
    JButton b1,b2,b3,b4,b5,b6,b7;
    Graphics g;
    public boolean bb1,bb2,bb3,bb4;
    public int lastx1 = -27,lastx2=1290,lasty1=0,lasty2=690;
    public int x1=-25,x2=1300,y1=-20,y2=700;
    public int x5 = -25,y5 = 330,x6 = 1290,y6 = 440;
    public int lastx5 = -27,lasty5 = 335,lastx6 = 1290,lasty6 = 355;
    public int wmotor1 = 30,hmotor1 = 15,wmotor2 = 30,hmotor2 = 15;
    
    public CTRLv3()
    {
        // SETTING THE FRAME PROPERTIES
        
        super("TRAFFIC CONTROLLER");
        setLayout(null);
        setSize(1290,750);
        setLocation(0,0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // CREATING MAP USING JLABEL
        
        l1 = new JLabel();
        l1.setBounds(0,0,1280,730);
        l1.setLayout(null);
        l1.setOpaque(true);
        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("trafficctrlv3/icons/crossroads.jpg"));
        Image i1 = ic1.getImage().getScaledInstance(1280, 720, Image.SCALE_DEFAULT);
        ImageIcon ic2 = new ImageIcon(i1);
        l1.setIcon(ic2);
        add(l1);
    
        //ADDING THE TRAFFIC LIGHTS AS BUTTONS
        
        b1 = new JButton();
        b1.setBackground(Color.RED);
        b1.setBounds(520,300,32,32);
        l1.add(b1);

        bb1 = false;
        
        b2 = new JButton();
        b2.setBackground(Color.RED);
        b2.setBounds(725,370,32,32);
        l1.add(b2);
        
        bb2 = false;
        
        b3 = new JButton();
        b3.setBackground(Color.RED);
        b3.setBounds(660,240,32,32);
        l1.add(b3);
        
        bb3 = false;
        
        b4 = new JButton();
        b4.setBackground(Color.RED);
        b4.setBounds(580,440,32,32);
        l1.add(b4);
        
        bb4 = false;
        
        //BUTTONS FOR ADDITIONAL FUNCTIONALITY
        
        b5 = new JButton("RESET");
        b5.setBounds(100, 500, 100, 30);
        l1.add(b5);
        
        b6 = new JButton("EXIT");
        b6.setBounds(250, 500, 100, 30);
        l1.add(b6);
        
        b7 = new JButton("START");
        b7.setBounds(175, 550, 100, 30);
        l1.add(b7);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        
        setVisible(true);
    }
    
    @Override
    public void paint(Graphics g) //FOR PAINTING THE VEHICLES
    {
        Graphics2D g1 = (Graphics2D) g;
        super.paint(g1);
        
        int w1 = 1250;
        int h1 = 660;
        
        int wmotor = 30;
        int hmotor = 15;
        int speed = 2;
        
        //////////////////////////////// CAR 1

        if(!(bb1==false&&x1>470&&x1<520))
            x1 = lastx1 + speed;
            
        if(x1 > w1 + wmotor)
        {
            x1 = -wmotor;
        }
        
        g1.setColor(Color.PINK);
        g1.fillRoundRect(x1,350,wmotor,hmotor,10,10);
            
        if(!(bb1==false&&x1>470&&x1<520))
            lastx1 = x1;
        
        //////////////////////////////// CAR 2

        if(!(bb2==false&&x2>730&&x2<770))
            x2 = lastx2 - speed;
            
        if(x2 < -wmotor)
        {
            x2 = w1 + wmotor;
        }
        
        g1.setColor(Color.BLUE);
        g1.fillRoundRect(x2,415,wmotor,hmotor,10,10);
            
        if(!(bb2==false&&x2>730&&x2<770))
            lastx2 = x2;
        
        //////////////////////////////////////CAR 3

        if(!(bb3==false&&y1>230&&y1<270))
            y1 = lasty1 + speed;
    
        if(y1 > h1 + wmotor)
        {
            y1 = -wmotor;
        }
        
        g1.setColor(Color.CYAN);
        g1.fillRoundRect(667,y1,hmotor,wmotor,10,10);
                
        if(!(bb3==false&&y1>230&&y1<270))
            lasty1 = y1;
        
        ///////////////////////////////////// CAR 4
            
        if(!(bb4==false&&y2<530&&y2>490))
            y2 = lasty2 - speed;

        if(y2 < -wmotor)
        {
            y2 = h1 + wmotor;
        }
        
        g1.setColor(Color.MAGENTA);
        g1.fillRoundRect(600,y2,hmotor,wmotor,10,10); 
                
        if(!(bb4==false&&y2<530&&y2>490))
            lasty2 = y2;
        
        ///////////////////////////////////// CAR 5
        
        if(!(bb1==false&&x5>470&&x5<520)&&x5<570)
            x5 = lastx5 + speed;

        if(y5<330)//!(bb4==false&&y5<530&&y5>490)&&
            y5 = lasty5 - speed;
            
        if(x5 > 525 + wmotor2 && x5<580)
        {
            x5 = 582;
            y5 = 320;
            wmotor2 = 15;
            hmotor2 = 30;
        }
            
        if(y5 < -wmotor2)
        {
            x5 = 0;
            y5 = 331;
            wmotor2 = 30;
            hmotor2 = 15;
        }

        g1.setColor(Color.ORANGE);
        g1.fillRoundRect(x5, y5,wmotor2,hmotor2,10,10);
            
        if(!(bb1==false&&x5>470&&x5<520)&&x5<570)
            lastx5 = x5;
        if(y5<330)
            lasty5 = y5;
        
        ////////////////////////////////////// CAR 6
            
        if(!(bb2==false&&x6>730&&x6<770)&&x6>690)
            x6 = lastx6 - speed;
            
        if(y6>450)
            y6 = lasty6 + speed;
            
        if(x6 < 695 && x6>690)
        {
            x6 = 685;
            y6 = 455;
            wmotor1 = 15;
            hmotor1 = 30;
        }
            
        if(y6 > 660 + hmotor1)
        {
            x6 = 1280;
            y6 = 440;
            wmotor1 = 30;
            hmotor1 = 15;
        }

        g1.setColor(Color.YELLOW);
        g1.fillRoundRect(x6, y6,wmotor1,hmotor1,10,10);
            
        if(!(bb2==false&&x6>730&&x6<770)&&x6>690)
            lastx6 = x6;
        if(y6>450)
            lasty6 = y6;
        
        ////////////////////
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        //CREATING THREAD FOR MOVING THE CARS
        Thread animationcar = new Thread(new Runnable() {
            @Override
            public void run() 
            {
                while (true)
                {
                    repaint();
                    try 
                    {
                        Thread.sleep(10);
                    } 
                    catch (Exception ex) 
                    {
                        System.out.println("ErrorDetected:"+ex);
                    }
                }
            }
        });
        
        //ADDING FUNCTIONALITY TO BUTTONS
        
        if(ae.getSource()==b7)
        {
            try
            {
                bb1 = bb2 = bb3 = bb4 =  true;
                
                b1.setBackground(Color.GREEN);
                b2.setBackground(Color.GREEN);
                b3.setBackground(Color.GREEN);
                b4.setBackground(Color.GREEN);
                
                animationcar.start(); //starts moving the cars
            }
            catch(Exception e)
            {
                System.out.println("ErrorDetected:"+e);
            }
        }
        
        else if(ae.getSource()==b1)
        {
            try
            {
                if(bb1==false)
                {
                    bb1 = true;
                    b1.setBackground(Color.GREEN); //INTERESTING FACT ABOUT THE COLOR NAMING SCHEME
                }
                else
                {
                    bb1 = false;
                    b1.setBackground(Color.RED);
                }
            }
            catch(Exception e)
            {
                System.out.println("ErrorDetected:"+e);
            }
        }
        
        else if(ae.getSource()==b2)
        {
           try
            {
                if(bb2==false)
                {
                    bb2 = true;
                    b2.setBackground(Color.GREEN);
                }
                else
                {
                    bb2 = false;
                    b2.setBackground(Color.RED);
                }
            }
            catch(Exception e)
            {
                System.out.println("ErrorDetected:"+e);
            } 
        }
        else if(ae.getSource()==b3)
        {
            try
            {
                if(bb3==false)
                {
                    bb3 = true;
                    b3.setBackground(Color.GREEN);
                }
                else
                {
                    bb3 = false;
                    b3.setBackground(Color.RED);
                }
            }
            catch(Exception e)
            {
                System.out.println("ErrorDetected:"+e);
            }
        }
        else if(ae.getSource()==b4)
        {
            try
            {
                if(bb4==false)
                {
                    bb4 = true;
                    b4.setBackground(Color.GREEN);
                }
                else
                {
                    bb4 = false;
                    b4.setBackground(Color.RED);
                }
            }
            catch(Exception e)
            {
                System.out.println("ErrorDetected:"+e);
            }
        }
        else if(ae.getSource()==b5)
        {
            try
            {
                bb1 = bb2 = bb3 = bb4 = false;
                b1.setBackground(Color.RED);
                b2.setBackground(Color.RED);
                b3.setBackground(Color.RED);
                b4.setBackground(Color.RED);
            }
            catch(Exception e)
            {
                System.out.println("ErrorDetected:"+e);
            }
        }
        else if(ae.getSource()==b6)
        {
            try
            {
                System.exit(0);
            }
            catch(Exception e)
            {
                System.out.println("ErrorDetected:"+e);
            }
        }  
    }
    
    public static void main(String[] args) 
    {
        //CREATING OBJECT OF CLASS CTRLv3
        CTRLv3 ctrlv3;
        ctrlv3 = new CTRLv3();
    }
}
