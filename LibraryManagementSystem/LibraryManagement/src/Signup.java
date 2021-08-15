import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Signup extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JButton b1, b2;
    private JComboBox comboBox;


    public static void main(String[] args) {
        new Signup().setVisible(true);
    }

    public Signup() {
        setBounds(600, 250, 626, 436);
        setTitle("SignUp here");
        Color myColor = new Color(9, 19, 35); 
        //Color textColors = new Color(237,93,0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(myColor);
        contentPane.setLayout(null);

        JLabel bg = new JLabel();
        bg.setIcon(new ImageIcon("LibraryManagement\\src\\icons\\SignUp.png"));
        bg.setBounds(0,0,626,436);

        JLabel title = new JLabel("Sign Up Form");
        title.setForeground(new Color(255,103,0));//new Color(255, 34, 178)
        title.setFont(new Font("Candara", Font.BOLD, 25));
        title.setBounds(230, 50, 192, 26);
        bg.add(title);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setForeground(Color.white);
        lblUsername.setFont(new Font("Candara", Font.BOLD, 18));
        lblUsername.setBounds(99, 120, 92, 26);
        bg.add(lblUsername);

        JLabel lblName = new JLabel("Name");
        lblName.setForeground(Color.white);
        lblName.setFont(new Font("Candara", Font.BOLD, 18));
        lblName.setBounds(99, 160, 92, 26);
        bg.add(lblName);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(Color.white);
        lblPassword.setFont(new Font("Candara", Font.BOLD, 18));
        lblPassword.setBounds(99, 200, 92, 26);
        bg.add(lblPassword);

        JLabel lblAnswer = new JLabel("Answer");
        lblAnswer.setForeground(Color.white);
        lblAnswer.setFont(new Font("Candara", Font.BOLD, 18));
        lblAnswer.setBounds(99, 280, 92, 26);
        bg.add(lblAnswer);

        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] { "Your NickName?", "Your Lucky Number?", "Your child SuperHero?", "Your childhood Name ?" }));
        comboBox.setBounds(320, 240, 190, 24);
        bg.add(comboBox);

        JLabel lblSecurityQuestion = new JLabel("Security Question");
        lblSecurityQuestion.setForeground(Color.white);
        lblSecurityQuestion.setFont(new Font("Candara", Font.BOLD, 18));
        lblSecurityQuestion.setBounds(99, 240, 170, 26);
        bg.add(lblSecurityQuestion);

        textField = new JTextField();
        textField.setBounds(320, 120, 190, 23);
        textField.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        textField.setColumns(10);
        bg.add(textField);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        textField_1.setBounds(320, 160, 190, 23);
        bg.add(textField_1);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        textField_2.setBounds(320, 200, 190, 23);
        bg.add(textField_2);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        textField_3.setBounds(320, 280, 190, 23);
        bg.add(textField_3);

        b1 = new JButton("Create");
        b1.addActionListener(this);
        b1.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        b1.setBounds(412, 335, 100, 30);
        b1.setBackground(new Color(0, 209, 23));
        b1.setForeground(Color.WHITE);
        bg.add(b1);

        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        b2.setBounds(99, 335, 100, 30);
        b2.setBackground(new Color(0, 175, 238));
        b2.setForeground(Color.WHITE);
        bg.add(b2);
        contentPane.add(bg);
        setResizable(false);
        setLocationRelativeTo(null);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?characterEncoding=latin1", "root", "vansh123");
            
            if(ae.getSource() == b1){
                String sql = "insert into account(Username, name, passcode, sec_q, sec_ans) values(?, ?, ?, ?, ?)";
                PreparedStatement st = con.prepareStatement(sql);

                st.setString(1, textField.getText());
                st.setString(2, textField_1.getText());
                st.setString(3, textField_2.getText());
                st.setString(4, (String) comboBox.getSelectedItem());
                st.setString(5, textField_3.getText());

                int i = st.executeUpdate();
                if (i > 0){
                    JOptionPane.showMessageDialog(null, "Successfully Created");
                }

                textField.setText("");
                textField_1.setText("");
                textField_2.setText("");
                textField_3.setText("");
            }
            if(ae.getSource() == b2){
                this.setVisible(false);
                new LoginPage().setVisible(true);
            
            }
            con.close();
        }

        catch(Exception e){
        
        }
    }
}
