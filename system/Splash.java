package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable{
    Thread thread;
    
    Splash(){
//        setSize(1200, 600);
//        setLocation(200, 100);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/splash1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1200, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        
        setVisible(true);
        thread = new Thread(this);
        thread.start();
    }
    
    public void run(){
        try{
            Thread.sleep(6000);
            //new Login();
            setVisible(false);
            new Login();
        } catch (Exception e){
        
        }
    }

    public static void main(String args[]) {
        Splash frame = new Splash();
        
        int X = 1;
        for(int i=1; i<=500; X+=7, i+=6){
            frame.setLocation(750 - i, 400-(i/2));
            frame.setSize(X+i, i);            
            try{
                Thread.sleep(40);
            } catch(Exception e) {}
        }
    }
}