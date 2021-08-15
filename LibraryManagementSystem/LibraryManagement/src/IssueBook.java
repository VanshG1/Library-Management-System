import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.*;

public class IssueBook extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JDateChooser dateChooser;
    private JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15;
    private JButton b1,b2,b3,b4;

    public static void main(String[] args) {
	new IssueBook().setVisible(true);
			
    }

    public IssueBook() {
        setBounds(300, 200, 890, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Color myColor = new Color(9, 19, 35); //blue
        Color textColors = new Color(213, 219, 219); //white
        Color borderColor = new Color(237,93,0); //orange
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(myColor);
        contentPane.setLayout(null);

        JLabel l1 = new JLabel("Book ID");
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        l1.setForeground(new Color(255, 34, 178));
        l1.setBounds(57, 63, 100, 23);
        contentPane.add(l1);

        JLabel l2 = new JLabel("Name");
        l2.setForeground(borderColor);
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        l2.setBounds(57, 97, 100, 23);
        contentPane.add(l2);

        JLabel l3 = new JLabel("ISBN");
        l3.setForeground(borderColor);
        l3.setFont(new Font("Tahoma", Font.BOLD, 14));
        l3.setBounds(57, 134, 100, 23);
        contentPane.add(l3);

        JLabel l4 = new JLabel("Author");
        l4.setForeground(borderColor);
        l4.setFont(new Font("Tahoma", Font.BOLD, 14));
        l4.setBounds(57, 165, 100, 23);
        contentPane.add(l4);

        JLabel l5 = new JLabel("Edition");
        l5.setForeground(borderColor);
        l5.setFont(new Font("Tahoma", Font.BOLD, 14));
        l5.setBounds(57, 199, 100, 23);
        contentPane.add(l5);

        JLabel l6 = new JLabel("Genre");
        l6.setForeground(borderColor);
        l6.setFont(new Font("Tahoma", Font.BOLD, 14));
        l6.setBounds(57, 233, 100, 23);
        contentPane.add(l6);

        JLabel l7 = new JLabel("Pages");
        l7.setForeground(borderColor);
        l7.setFont(new Font("Tahoma", Font.BOLD, 14));
        l7.setBounds(57, 267, 100, 23);
        contentPane.add(l7);

        t1 = new JTextField();
        t1.setForeground(new Color(47, 79, 79));
        t1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t1.setBounds(156, 66, 86, 20);
        contentPane.add(t1);
        
        b1 = new JButton("Search");
        b1.addActionListener(this);
        b1.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
        b1.setBackground(borderColor);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        b1.setBounds(264, 59, 100, 30);
            
        contentPane.add(b1);

        t2 = new JTextField();
        t2.setEditable(false);
        t2.setForeground(new Color(47, 79, 79));
        t2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t2.setBounds(156, 100, 208, 20);
        contentPane.add(t2);
        t2.setColumns(10);

        t3 = new JTextField();
        t3.setEditable(false);
        t3.setForeground(new Color(47, 79, 79));
        t3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t3.setColumns(10);
        t3.setBounds(156, 131, 208, 20);
        contentPane.add(t3);

        t4 = new JTextField();
        t4.setEditable(false);
        t4.setForeground(new Color(47, 79, 79));
        t4.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t4.setColumns(10);
        t4.setBounds(156, 168, 208, 20);
        contentPane.add(t4);

        t5 = new JTextField();
        t5.setEditable(false);
        t5.setForeground(new Color(47, 79, 79));
        t5.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t5.setColumns(10);
        t5.setBounds(156, 202, 208, 20);
        contentPane.add(t5);

        t6 = new JTextField();
        t6.setEditable(false);
        t6.setForeground(new Color(47, 79, 79));
        t6.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t6.setColumns(10);
        t6.setBounds(156, 236, 208, 20);
        contentPane.add(t6);

        t7 = new JTextField();
        t7.setEditable(false);
        t7.setForeground(new Color(47, 79, 79));
        t7.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t7.setColumns(10);
        t7.setBounds(156, 270, 208, 20);
        contentPane.add(t7);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(237,93,0), 2, true), "Issue-Book",
        TitledBorder.LEADING, TitledBorder.TOP, null, new Color(47, 185, 62)));
        panel.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.setBounds(40, 38, 350, 285);
        panel.setBackground(myColor);
        contentPane.add(panel);

        JLabel l8 = new JLabel("Student ID");
        l8.setForeground(new Color(255, 34, 178));
        l8.setFont(new Font("Tahoma", Font.BOLD, 14));
        l8.setBounds(440, 63, 100, 23);
        contentPane.add(l8);

        JLabel l9 = new JLabel("Name");
        l9.setForeground(new Color(47, 185, 62));
        l9.setFont(new Font("Tahoma", Font.BOLD, 14));
        l9.setBounds(440, 103, 100, 23);
        contentPane.add(l9);

        JLabel l10 = new JLabel("Father's Name");
        l10.setForeground(new Color(47, 185, 62));
        l10.setFont(new Font("Tahoma", Font.BOLD, 14));
        l10.setBounds(440, 147, 110, 23);
        contentPane.add(l10);

        JLabel l11 = new JLabel("Course");
        l11.setForeground(new Color(47, 185, 62));
        l11.setFont(new Font("Tahoma", Font.BOLD, 14));
        l11.setBounds(440, 187, 100, 23);
        contentPane.add(l11);

        JLabel l12 = new JLabel("Branch");
        l12.setForeground(new Color(47, 185, 62));
        l12.setFont(new Font("Tahoma", Font.BOLD, 14));
        l12.setBounds(440, 233, 100, 23);
        contentPane.add(l12);

        JLabel l13 = new JLabel("Year");
        l13.setForeground(new Color(47, 185, 62));
        l13.setFont(new Font("Tahoma", Font.BOLD, 14));
        l13.setBounds(440, 284, 100, 23);
        contentPane.add(l13);

        JLabel l14 = new JLabel("Semester");
        l14.setForeground(new Color(47, 185, 62));
        l14.setFont(new Font("Tahoma", Font.BOLD, 14));
        l14.setBounds(440, 336, 100, 23);
        contentPane.add(l14);

        t8 = new JTextField();
        t8.setForeground(new Color(47, 79, 79));
        t8.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t8.setColumns(10);
        t8.setBounds(592, 66, 86, 20);
        contentPane.add(t8);

        b2 = new JButton("Search");
        b2.addActionListener(this);
        b2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        b2.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
        b2.setBounds(700, 59, 100, 30);
        b2.setBackground(borderColor);
        b2.setForeground(Color.white);
        contentPane.add(b2);

        t9 = new JTextField();
        t9.setForeground(new Color(47, 79, 79));
        t9.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t9.setEditable(false);
        t9.setColumns(10);
        t9.setBounds(592, 106, 208, 20);
        contentPane.add(t9);

        t10 = new JTextField();
        t10.setForeground(new Color(47, 79, 79));
        t10.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t10.setEditable(false);
        t10.setColumns(10);
        t10.setBounds(592, 150, 208, 20);
        contentPane.add(t10);

        t11 = new JTextField();
        t11.setForeground(new Color(47, 79, 79));
        t11.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t11.setEditable(false);
        t11.setColumns(10);
        t11.setBounds(592, 190, 208, 20);
        contentPane.add(t11);

        t12 = new JTextField();
        t12.setForeground(new Color(47, 79, 79));
        t12.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t12.setEditable(false);
        t12.setColumns(10);
        t12.setBounds(592, 236, 208, 20);
        contentPane.add(t12);

        t13 = new JTextField();
        t13.setForeground(new Color(47, 79, 79));
        t13.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t13.setEditable(false);
        t13.setColumns(10);
        t13.setBounds(592, 286, 208, 20);
        contentPane.add(t13);

        t14 = new JTextField();
        t14.setForeground(new Color(47, 79, 79));
        t14.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t14.setEditable(false);
        t14.setColumns(10);
        t14.setBounds(592, 338, 208, 20);
        contentPane.add(t14);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 175, 238), 2, true), "Student-Details",
        TitledBorder.LEADING, TitledBorder.TOP, null, new Color(237,93,0)));
        panel_1.setForeground(new Color(0, 100, 0));
        panel_1.setBounds(420, 38, 415, 372);
        panel_1.setBackground(myColor);
        contentPane.add(panel_1);
            
        JLabel l15 = new JLabel(" Date of Issue ");
        l15.setForeground(textColors);
        l15.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        l15.setBounds(40, 340, 118, 26);
        contentPane.add(l15);

        t15 = new JTextField();
        t15.setBounds(182, 337, 200, 29);

        dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("yyyy-MM-dd");
        dateChooser.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        dateChooser.setForeground(new Color(105, 105, 105));
        dateChooser.setBounds(182, 337, 200, 29);
        contentPane.add(dateChooser);

        b3 = new JButton("Issue");
        b3.addActionListener(this);
        b3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        b3.setBorder(new LineBorder(new Color(47, 185, 62), 1, true));
        b3.setBounds(280, 382, 100, 33);
        b3.setBackground(new Color(47, 185, 62));
        b3.setForeground(Color.WHITE);
        contentPane.add(b3);

        b4 = new JButton("Back");
        b4.addActionListener(this);
        b4.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        b4.setBorder(new LineBorder(new Color(0, 175, 238), 1, true));
        b4.setBounds(47, 382, 100, 33);
        b4.setBackground(new Color(9, 159, 255));
        b4.setForeground(Color.WHITE);
        contentPane.add(b4);

        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?characterEncoding=latin1", "root", "vansh123");
                if(ae.getSource() == b1){
                    String str = "select * from book where book_id = ?";
                    PreparedStatement ps = con.prepareStatement(str);
		            ps.setString(1, t1.getText());
		            ResultSet rs = ps.executeQuery();
		
                    while (rs.next()) {
                        t2.setText(rs.getString("name"));
                        t3.setText(rs.getString("isbn"));
                        t4.setText(rs.getString("publisher"));
                        t5.setText(rs.getString("edition"));
                        t6.setText(rs.getString("genre"));
                        t7.setText(rs.getString("price"));
                    }
                    ps.close();
                    rs.close();
		
                }

                if(ae.getSource() == b2){
                   
                    String str = "select * from student where student_id = ?";
                    PreparedStatement ps = con.prepareStatement(str);
                    ps.setString(1, t8.getText());
                    ResultSet rs = ps.executeQuery();
            
                    while (rs.next()) {
                        t9.setText(rs.getString("name"));
                        t10.setText(rs.getString("father"));
                        t11.setText(rs.getString("course"));
                        t12.setText(rs.getString("branch"));
                        t13.setText(rs.getString("year"));
                        t14.setText(rs.getString("semester"));
                    }

                    ps.close();
                    rs.close();
            
                }

                if(ae.getSource() == b3){
                    try
                    {
                        String sql = "insert into issueBook(book_id, student_id, bname, sname, course, branch, dateOfIssue) values(?, ?, ?, ?, ?, ?, ?)";
                        PreparedStatement st = con.prepareStatement(sql);
                        st.setString(1, t1.getText());
                        st.setString(2, t8.getText());
                        st.setString(3, t2.getText());
                        st.setString(4, t9.getText());
                        st.setString(5, t11.getText());
                        st.setString(6, t12.getText());
                        st.setString(7, ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText());
                        int i = st.executeUpdate();
                        //st.setString(7, t15.getText());
                        if (i > 0)
                            JOptionPane.showMessageDialog(null, "Successfully Book Issued..!");
                        else
                            JOptionPane.showMessageDialog(null, "Invalid Book ID or Student ID");
                        
                        String def = "";
                        
                    }

                    catch(Exception e){
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Invalid Book ID or Student ID");
                    }
                }

            if(ae.getSource() == b4){
                this.setVisible(false);
                new admin_menu().setVisible(true);
            }
                    
            con.close();
        }
        catch(Exception e){
            
        }
    }
}
