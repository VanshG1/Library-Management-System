import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;
import java.awt.event.*;

public class Forgot extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField t1,t2,t3,t4,t5;
    private JButton b1,b2,b3;

    public static void main(String[] args) {
	    new Forgot().setVisible(true);
    }

    public Forgot() {
        setBounds(600, 250, 626, 436);
        setTitle("Forgot Panel");

        Color myColor = new Color(9, 19, 35); 
        Color textColors = new Color(237,93,0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(myColor);
        contentPane.setLayout(null);

        JLabel title = new JLabel("Forgot Panel");
        title.setForeground(new Color(255, 34, 178));
        title.setFont(new Font("Candara", Font.BOLD, 25));
        title.setBounds(230, 50, 192, 26);
        contentPane.add(title);

        JLabel l1 = new JLabel("Username");
        l1.setForeground(textColors);
        l1.setFont(new Font("Candara", Font.BOLD, 18));
        l1.setBounds(99, 120, 92, 26);
        contentPane.add(l1);

        JLabel l2 = new JLabel("Name");
        l2.setForeground(textColors);
        l2.setFont(new Font("Candara", Font.BOLD, 18));
        l2.setBounds(99, 160, 92, 26);
        contentPane.add(l2);

        JLabel l3 = new JLabel("Security Question");
        l3.setForeground(textColors);
        l3.setFont(new Font("Candara", Font.BOLD, 18));
        l3.setBounds(99, 200, 170, 26);
        contentPane.add(l3);

        JLabel l4 = new JLabel("Answer");
        l4.setForeground(textColors);
        l4.setFont(new Font("Candara", Font.BOLD, 18));
        l4.setBounds(99, 240, 92, 26);
        contentPane.add(l4);

        JLabel l5 = new JLabel("Password");
        l5.setForeground(textColors);
        l5.setFont(new Font("Candara", Font.BOLD, 18));
        l5.setBounds(99, 280, 92, 26);
        contentPane.add(l5);

        t1 = new JTextField();
        t1.setBounds(320, 120, 115, 23);
        t1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t1.setColumns(10);
        contentPane.add(t1);

        t2 = new JTextField();
        t2.setEditable(false);
        t2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t2.setForeground(new Color(165, 42, 42));
        t2.setColumns(10);
        t2.setBounds(320, 160, 190, 23);
        contentPane.add(t2);

        t3 = new JTextField();
        t3.setEditable(false);
        t3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t3.setForeground(new Color(72, 61, 139));
        t3.setColumns(10);
        t3.setBounds(320, 200, 190, 23);
        contentPane.add(t3);

        t4 = new JTextField();
        t4.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t4.setForeground(new Color(205, 92, 92));
        t4.setColumns(10);
        t4.setBounds(320, 240, 190, 24);
        contentPane.add(t4);

        t5 = new JTextField();
        t5.setEditable(false);
        t5.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t5.setForeground(new Color(50, 205, 50));
        t5.setColumns(10);
        t5.setBounds(320, 280, 190, 23);
        contentPane.add(t5);

        b1 = new JButton("Search");
        b1.addActionListener(this);
        b1.setFont(new Font("Tahoma", Font.BOLD, 12));
        b1.setBounds(450, 117, 88, 29);
        b1.setBackground(textColors);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);

        b2 = new JButton("Retrieve");
        b2.addActionListener(this);
        b2.setFont(new Font("Tahoma", Font.BOLD, 12));
        b2.setBounds(412, 335, 100, 30);
        b2.setBackground(new Color(47, 185, 62));
        b2.setForeground(Color.WHITE);
        contentPane.add(b2);

        b3 = new JButton("Back");
        b3.addActionListener(this);
        b3.setFont(new Font("Tahoma", Font.BOLD, 13));
        b3.setBounds(99, 335, 100, 30);
        b3.setBackground(new Color(0, 175, 238));
        b3.setForeground(Color.WHITE);
        contentPane.add(b3);

        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

    }
    
    public void actionPerformed(ActionEvent ae){
        try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?characterEncoding=latin1", "root", "vansh123");
                if(ae.getSource() == b1){
                    String sql = "select * from account where Username=?";
		            PreparedStatement st = con.prepareStatement(sql);

		            st.setString(1, t1.getText());
		            ResultSet rs = st.executeQuery();

		            while (rs.next()) {
                        t2.setText(rs.getString("name"));
                        t3.setText(rs.getString("sec_q"));
		            }

                }

                if(ae.getSource() == b2){
                    String sql = "select * from account where sec_ans=?";
                    PreparedStatement st = con.prepareStatement(sql);

                    st.setString(1, t4.getText());
                    ResultSet rs = st.executeQuery();

                    while (rs.next()) {
                        t5.setText(rs.getString("passcode"));
                    }
                }

                if(ae.getSource() == b3){
                    this.setVisible(false);
		            new LoginPage().setVisible(true);
			
                }
        }
        catch(Exception e){
            
        }
    }

}
