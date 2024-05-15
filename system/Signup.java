
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Signup extends JFrame implements ActionListener{
    JButton create, back;
    JTextField tfuserName, tfName, tfPassword, tfAnswer;
    Choice security;

    Signup(){
        setBounds(350, 200, 900, 360);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(133,193,233));
        p1.setBounds(0,0,500,400);
        p1.setLayout(null);
        add(p1);
        
        JLabel lbluserName = new JLabel("Username :");
        lbluserName.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbluserName.setBounds(50,20,125,25);
        p1.add(lbluserName);
        
        tfuserName = new JTextField();
        tfuserName.setBounds(190, 20,180,25);
        tfuserName.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfuserName);
        
        JLabel lblName = new JLabel("Name :");
        lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblName.setBounds(50,60,125,25);
        p1.add(lblName);
        
        tfName = new JTextField();
        tfName.setBounds(190, 60,180,25);
        tfName.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfName);
        
        JLabel lblPassword = new JLabel("Passward :");
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblPassword.setBounds(50,100,125,25);
        p1.add(lblPassword);
        
        tfPassword = new JTextField();
        tfPassword.setBounds(190, 100,180,25);
        tfPassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfPassword);
        
        JLabel lblSecurity = new JLabel("Security Question :");
        lblSecurity.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblSecurity.setBounds(50,140,140,25);
        p1.add(lblSecurity);
        
        security = new Choice();
        security.add("Fav Character From The Boys");
        security.add("Fav Marvel Superhero");
        security.add("Your Lucky Number");
        security.add("Your Childhood Superhero");
        security.setBounds(190,140,180,25);
        p1.add(security);
        
        JLabel lblAnswer = new JLabel("Answer :");
        lblAnswer.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblAnswer.setBounds(50,180,125,25);
        p1.add(lblAnswer);
        
        tfAnswer = new JTextField();
        tfAnswer.setBounds(190, 180,180,25);
        tfAnswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfAnswer );
        
        create = new JButton("Create");
        create.setBounds(80,250,100,30);
        create.setBackground(Color.WHITE);
        create.setForeground(new Color(133,193,233));
        create.setFont(new Font("Tahoma", Font.BOLD, 14));
        create.setBorder(BorderFactory.createEmptyBorder());
        create.addActionListener(this);
        p1.add(create);
        
        back = new JButton("Back");
        back.setBounds(250,250,100,30);
        back.setBackground(Color.WHITE);
        back.setForeground(new Color(133,193,233));
        back.setFont(new Font("Tahoma", Font.BOLD, 14));
        back.setBorder(BorderFactory.createEmptyBorder());
        back.addActionListener(this);
        p1.add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT );
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580, 50, 250, 250);
        add(image);

        setVisible(true);  
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == create){
            String userName = tfuserName.getText();
            String name = tfName.getText();
            String password = tfPassword.getText();
            String question = security.getSelectedItem();
            String answer = tfAnswer.getText();
            
            String query = "insert into Account values('"+userName+"', '"+name+"', '"+password+"', '"+question+"', '"+answer+"')";
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Account Created Successfully");
                
                setVisible(false);
                new Login();
                
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == back){
            setVisible(false);
            new Login();
        }
    }
    
    public static void main(String args[]) {
        new Signup();
    }
}
