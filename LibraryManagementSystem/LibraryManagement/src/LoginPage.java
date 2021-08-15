import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.*;
import java.sql.*;
public class LoginPage extends JFrame implements ActionListener
{
    JPanel c;
    JLabel user_id, password, message;
    JTextField tuser_id;
    JPasswordField tpassword;
    JButton submit,b2,b3;
    JCheckBox showPassword;
    LoginPage()
    {
        setTitle("Please Login Here!");
        setBounds(300, 90, 650, 452);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Color textColors = new Color(212,212,212);
        c = new JPanel();
        c.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(c);
        c.setLayout(null);
    
        JLabel l = new JLabel();
        l.setIcon(new ImageIcon("LibraryManagement\\src\\icons\\LibraryManagementSystem.jpg"));
        l.setBounds(0,0,650,430);

        user_id=new JLabel("Username");
        user_id.setFont(new Font("Candara", Font.BOLD, 22));
        user_id.setBounds(125,200,375,30);
        user_id.setForeground(textColors);
        l.add(user_id);

        tuser_id=new JTextField();
        tuser_id.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
        tuser_id.setBounds(305, 200, 220, 23);
        l.add(tuser_id);
        
        password=new JLabel("Password");
        password.setFont(new Font("Candara", Font.BOLD, 22));
        password.setBounds(125,255,375,30);
        password.setForeground(textColors);
        l.add(password);
        
        tpassword=new JPasswordField();
        tpassword.setBounds(305, 255, 220, 23);
        tpassword.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
        l.add(tpassword);
        
        showPassword = new JCheckBox("Show Password");
        showPassword.setBounds(420,280,150, 30);
        showPassword.addActionListener(this);
        showPassword.setOpaque(false);
        showPassword.setForeground(textColors);
        l.add(showPassword);

        submit=new JButton("SIGN IN");
        submit.setFont(new Font("Arial", Font.BOLD, 12));
        submit.setBounds(300,325,100,30);
        submit.addActionListener(this);
        submit.setBackground(new java.awt.Color(47, 185, 62));
        submit.setForeground(Color.white);
        submit.setBorderPainted(true);
        l.add(submit);

        b2=new JButton("SIGN UP");
        b2.setFont(new Font("Arial", Font.BOLD, 12));
        b2.setBounds(430,325,100,30);
        b2.setBackground(new java.awt.Color(237,93,0));
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        l.add(b2);

        b3=new JButton("Forgot Password");
        b3.setFont(new Font("Arial", Font.BOLD, 13));
        b3.setBounds(360,370,140,30);
        b3.setBackground(new Color(0, 175, 238));
        b3.setForeground(Color.white);
        b3.addActionListener(this);
        l.add(b3);

        JLabel t = new JLabel("Trouble in Login?");
        t.setFont(new Font("Candara", Font.BOLD, 18));
        t.setBounds(210,373,140,30);
        t.setForeground(new Color(255, 46, 160));
        l.add(t);

        c.add(l);

        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args)
    {
        new LoginPage().setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == submit)
        {
            String Username = tuser_id.getText();
            String passcode = tpassword.getText();
            try 
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?characterEncoding=latin1", "root", "vansh123");
                String str = "select * from account where username = ? and passcode = ?";
                PreparedStatement ps = con.prepareStatement(str);

                ps.setString(1, Username);
                ps.setString(2, passcode);

                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    this.setVisible(false);
                    new admin_menu().setVisible(true);
                } 
                else
                {
                    JOptionPane.showMessageDialog(submit, "Invalid Username or Password");
                }
                
                con.close();
                    
            } 
                
            catch (Exception e2) 
            {
                e2.printStackTrace();
            }
        }

        if(ae.getSource() == b2){
            setVisible(false);
            Signup su = new Signup();
            su.setVisible(true);
        }   

        if(ae.getSource() == b3){
            setVisible(false);
            Forgot forgot = new Forgot();
            forgot.setVisible(true);
        }

        if(ae.getSource() == showPassword)
        {
            if (showPassword.isSelected()) {
                tpassword.setEchoChar((char) 0);
            } else {
                tpassword.setEchoChar('*');
            }
        }
        
    }
    
}