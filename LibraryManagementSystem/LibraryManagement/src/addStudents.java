import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
//import java.util.*;

public class addStudents extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField t1,t2,t3;
    private JComboBox comboBox, comboBox_1, comboBox_2, comboBox_3;
    JButton b1,b2, btn, btn1, btn2;

    public static void main(String[] args) {
        new addStudents().setVisible(true);
    }

    public addStudents() 
    {
        super("Add Student");
        setBounds(600, 100, 950, 660);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        Color myColor = new Color(9, 19, 35);
        Color textColor = new Color(237,93,0); 

        JLabel title = new JLabel("Add Student");
        title.setForeground(new Color(255,0,108));
        title.setFont(new Font("Candara", Font.BOLD, 30));
        title.setBounds(500, 40, 300, 50);
        contentPane.add(title);

        JLabel l1 = new JLabel("Student ID");
        l1.setForeground(textColor);
        l1.setFont(new Font("Candara", Font.BOLD, 20));
        l1.setBounds(380, 120, 100, 22);
        contentPane.add(l1);

        JLabel l2 = new JLabel("Name");
        l2.setForeground(textColor);
        l2.setFont(new Font("Candara", Font.BOLD, 20));
        l2.setBounds(380, 180, 90, 22);
        contentPane.add(l2);

        JLabel l3 = new JLabel("Father's Name");
        l3.setForeground(textColor);
        l3.setFont(new Font("Candara", Font.BOLD, 20));
        l3.setBounds(380, 240, 140, 22);
        contentPane.add(l3);

        JLabel l4 = new JLabel("Branch");
        l4.setForeground(textColor);
        l4.setFont(new Font("Candara", Font.BOLD, 20));
        l4.setBounds(380, 300, 120, 22);
        contentPane.add(l4);

        JLabel l5 = new JLabel("Year");
        l5.setForeground(textColor);
        l5.setFont(new Font("Candara", Font.BOLD, 20));
        l5.setBounds(380, 420, 90, 22);
        contentPane.add(l5);

        JLabel l6 = new JLabel("Semester");
        l6.setForeground(textColor);
        l6.setFont(new Font("Candara", Font.BOLD, 20));
        l6.setBounds(380, 480, 90, 25);
        contentPane.add(l6);

        t1 = new JTextField();
        //t1.setEditable(false);
        t1.setForeground(new Color(47, 79, 79));
        t1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t1.setBounds(580, 117, 198, 23);
        contentPane.add(t1);
        t1.setColumns(10);

        t2 = new JTextField();
        t2.setForeground(new Color(47, 79, 79));
        t2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t2.setColumns(10);
        t2.setBounds(580, 177, 198, 23);
        contentPane.add(t2);

        t3 = new JTextField();
        t3.setForeground(new Color(47, 79, 79));
        t3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t3.setColumns(10);
        t3.setBounds(580, 237, 198, 23);
        contentPane.add(t3);

        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] { "Mechanical", "CSE", "IT", "Civil", "Automobile", "EEE", "Other" }));
        comboBox.setForeground(new Color(47, 79, 79));
        comboBox.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        comboBox.setBounds(580, 297, 198, 23);
        contentPane.add(comboBox);

        comboBox_1 = new JComboBox();
        comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "First", "Second", "Third", "Four" }));
        comboBox_1.setForeground(new Color(47, 79, 79));
        comboBox_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        comboBox_1.setBounds(580, 417, 198, 23);
        contentPane.add(comboBox_1);

        comboBox_2 = new JComboBox();
        comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th" }));
        comboBox_2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        comboBox_2.setForeground(new Color(47, 79, 79));
        comboBox_2.setBounds(580, 477, 198, 23);
        contentPane.add(comboBox_2);

        b1 = new JButton("ADD");
        b1.addActionListener(this);
        b1.setFont(new Font("Segoe UI", Font.BOLD, 15));
        b1.setBounds(670, 550, 100, 33);
        b1.setBackground(new Color(0, 209, 23));
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);

        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setFont(new Font("Segoe UI", Font.BOLD, 16));
        b2.setBounds(380, 550, 100, 33);
        b2.setBackground(new Color(9, 159, 255));
        b2.setForeground(Color.WHITE);
        contentPane.add(b2);

        JLabel l7 = new JLabel("Course");
        l7.setForeground(textColor);
        l7.setFont(new Font("Candara", Font.BOLD, 20));
        l7.setBounds(380, 360, 90, 22);
        contentPane.add(l7);

        comboBox_3 = new JComboBox();
        comboBox_3.setModel(new DefaultComboBoxModel(
        new String[] { "B.E", "B.Tech", "M.Tech", "MBA", "BBA", "BCA", "B.Sc", "M.Sc", "B.Com", "M.Com" }));
        comboBox_3.setForeground(new Color(47, 79, 79));
        comboBox_3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        comboBox_3.setBounds(580, 357, 194, 23);
        contentPane.add(comboBox_3);

        JPanel panel1 = new JPanel();
        panel1.setBounds(20,40,300,545);
        panel1.setBackground(Color.lightGray);
        JLabel bg = new JLabel();
        bg.setIcon(new ImageIcon("LibraryManagement\\src\\icons\\bg1.png"));
        bg.setBounds(20,34,300,545);
        btn = new JButton("View Book",new ImageIcon("LibraryManagement\\src\\icons\\ViewBook3.png"));
        btn.setHorizontalTextPosition(SwingConstants.CENTER);
        btn.setVerticalTextPosition(SwingConstants.BOTTOM);
        btn.setFont(new Font("Candara", Font.BOLD, 16));
        btn.setForeground(Color.white);
        btn.setOpaque(false);
        btn.setBorder(null);
        btn.addActionListener(this);
        btn.setBounds(85,190,135,160);
        btn.setBackground(Color.white);

        btn1 = new JButton("Add Book",new ImageIcon("LibraryManagement\\src\\icons\\addBooks7.png"));
        btn1.setHorizontalTextPosition(SwingConstants.CENTER);
        btn1.setVerticalTextPosition(SwingConstants.BOTTOM);
        btn1.setFont(new Font("Candara", Font.BOLD, 16));
        btn1.setForeground(Color.white);
        btn1.setOpaque(false);
        btn1.setBorder(null);
        btn1.addActionListener(this);
        btn1.setBounds(85,30,135,150);
        btn1.setBackground(Color.white);

        btn2 = new JButton("Return Book",new ImageIcon("LibraryManagement\\src\\icons\\returnbooks.png"));
        btn2.setHorizontalTextPosition(SwingConstants.CENTER);
        btn2.setVerticalTextPosition(SwingConstants.BOTTOM);
        btn2.setFont(new Font("Candara", Font.BOLD, 16));
        btn2.setForeground(Color.white);
        btn2.setOpaque(false);
        btn2.setBorder(null);
        btn2.addActionListener(this);
        btn2.setBounds(85,360,135,145);
        btn2.setBackground(Color.white);

        bg.add(btn2);
        bg.add(btn1);
        bg.add(btn);
        
        panel1.setBounds(20,40,300,545);
        panel1.add(bg);
        contentPane.add(panel1);

        JPanel panel = new JPanel();
        panel.setBounds(235, 0, 700, 650);
        panel.setBackground(myColor);
        contentPane.add(panel);
        contentPane.setBackground(Color.WHITE);
        setResizable(false);
        setLocationRelativeTo(null);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            
            if(ae.getSource() == b1){
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?characterEncoding=latin1", "root", "vansh123");
                    String sql = "insert into student(student_id, name, father, course, branch, year, semester) values(?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement st = con.prepareStatement(sql);
                    st.setString(1, t1.getText());
                    st.setString(2, t2.getText());
                    st.setString(3, t3.getText());
                    st.setString(4, (String) comboBox_3.getSelectedItem());
                    st.setString(5, (String) comboBox.getSelectedItem());
                    st.setString(6, (String) comboBox_1.getSelectedItem());
                    st.setString(7, (String) comboBox_2.getSelectedItem());

                    int i = st.executeUpdate();
                    if (i > 0){
                        JOptionPane.showMessageDialog(null, "Successfully Added");
                        this.setVisible(false);
                        new admin_menu().setVisible(true);
                    }
                    else
                        JOptionPane.showMessageDialog(null, "error");
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
            
            if(ae.getSource() == b2){
                this.setVisible(false);
		        new admin_menu().setVisible(true);		
            }
        }
        catch(Exception e){
            
        }
    }
}