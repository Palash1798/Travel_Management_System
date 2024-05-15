
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton login, signup, forgotPassword;
    JTextField tfUsername, tfPassword;
    Login(){
        setSize(900, 400);
        setLocation(350, 200);
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131, 193, 233));
        p1.setBounds(0, 0, 400, 400);
        p1.setLayout(null);
        add(p1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT );
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100, 120, 200, 200);
        p1.add(image);
        
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400, 30, 450, 300);
        add(p2);
        
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(60,20,100,25);
        lblUsername.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        p2.add(lblUsername);
        
        tfUsername = new JTextField();
        tfUsername.setBounds(60,60,300,30);
        tfUsername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfUsername);
        
        JLabel lblPassword = new JLabel("Password");
        lblPassword .setBounds(60,110,100,25);
        lblPassword .setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        p2.add(lblPassword );
        
        tfPassword = new JTextField();
        tfPassword.setBounds(60,150,300,30);
        tfPassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfPassword );
        
        login = new JButton("Login");
        login.setBounds(60,200,130,30);
        login.setBackground(new Color(133,193,233));
        login.setForeground(Color.WHITE);
        login.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
        login.setBorder(new LineBorder(new Color(131,193,233)));
        login.addActionListener(this);
        p2.add(login);
        
        signup = new JButton("Signup");
        signup.setBounds(230,200,130,30);
        signup.setBackground(new Color(133,193,233));
        signup.setForeground(Color.WHITE);
        signup.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
        signup.setBorder(new LineBorder(new Color(131,193,233)));
        signup.addActionListener(this);
        p2.add(signup);
        
        forgotPassword = new JButton("Forget Password");
        forgotPassword.setBounds(130,250,150,30);
        forgotPassword.setBackground(new Color(133,193,233));
        forgotPassword.setForeground(Color.WHITE);
        forgotPassword.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
        forgotPassword.setBorder(new LineBorder(new Color(131,193,233)));
        forgotPassword.addActionListener(this);
        p2.add(forgotPassword);

        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == login){
            try{
                String username = tfUsername.getText();
                String pass = tfPassword.getText();
                
                String query = "select * from Account where Username = '"+username+"' AND Password = '"+pass+"'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Loading(username);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Incorrect Username OR Password");
                }
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == signup){
            new Signup();
        }
        else{
            setVisible(false);
            new ForgetPassword();
        }
    } 
            
            
    public static void main(String[] args){
        Login l = new Login();
    }
    
}
