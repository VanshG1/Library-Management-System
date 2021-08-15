import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.*;

public class returnBook extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JButton b1,b2,b3;
    private JDateChooser dateChooser;

    public static void main(String[] args) {
	    new returnBook().setVisible(true);
    }

    public void delete() {
        try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?characterEncoding=latin1", "root", "vansh123");
                String sql = "delete from issueBook where book_id=?";
                PreparedStatement st = con.prepareStatement(sql);
                st.setString(1, textField.getText());
                int i = st.executeUpdate();
                if (i > 0)
                    JOptionPane.showMessageDialog(null, "Book Returned");
                else
                    JOptionPane.showMessageDialog(null, "Error in Returning");
            } 

        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
	    }
    }

    
    public returnBook() 
    {
        setBounds(450, 300, 820, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
	    contentPane.setLayout(null);

        Color myColor = new Color(9, 19, 35);
        Color textColor = new Color(237,93,0); 

        JLabel title = new JLabel("Return Book");
        title.setForeground(new Color(255, 34, 178));
        title.setFont(new Font("Candara", Font.BOLD, 25));
        title.setBounds(440, 50, 192, 26);
        contentPane.add(title);

        JPanel panel1 = new JPanel();
        panel1.setBounds(20,38,240,385);
        JLabel bg = new JLabel();
        bg.setIcon(new ImageIcon("LibraryManagement\\src\\icons\\returnBook2.png"));
        bg.setBounds(20,32,240,385);

        JLabel lblNewLabel = new JLabel("Book ID");
        lblNewLabel.setForeground(new Color(0, 209, 23));
        lblNewLabel.setFont(new Font("Candara", Font.BOLD, 20));
        lblNewLabel.setBounds(320, 115, 87, 24);
        contentPane.add(lblNewLabel);

        JLabel lblStudentid = new JLabel("Student ID");
        lblStudentid.setForeground(new Color(244, 246, 246));
        lblStudentid.setFont(new Font("Candara", Font.BOLD, 18));
        lblStudentid.setBounds(95, 90, 87, 24);
        contentPane.add(lblStudentid);

        JLabel lblBook = new JLabel("Book");
        lblBook.setForeground(textColor);
        lblBook.setFont(new Font("Candara", Font.BOLD, 20));
        lblBook.setBounds(320, 170, 71, 24);
        contentPane.add(lblBook);

        JLabel lblName = new JLabel("Name");
        lblName.setForeground(new Color(244, 246, 246));
        lblName.setFont(new Font("Candara", Font.BOLD, 18));
        lblName.setBounds(35, 170, 71, 24);
        bg.add(lblName);

        JLabel lblCourse = new JLabel("Course");
        lblCourse.setForeground(textColor);
        lblCourse.setFont(new Font("Candara", Font.BOLD, 19));
        lblCourse.setBounds(320, 225, 87, 24);
        contentPane.add(lblCourse);

        JLabel lblBranch = new JLabel("Branch");
        lblBranch.setForeground(new Color(244, 246, 246));
        lblBranch.setFont(new Font("Candara", Font.BOLD, 18));
        lblBranch.setBounds(35, 280, 68, 24);
        bg.add(lblBranch);

        JLabel lblDateOfIssue = new JLabel("Date of Issue");
        lblDateOfIssue.setForeground(textColor);
        lblDateOfIssue.setFont(new Font("Candara", Font.BOLD, 19));
        lblDateOfIssue.setBounds(320, 280, 125, 29);
        contentPane.add(lblDateOfIssue);

        JLabel lblDateOfReturn = new JLabel("Date of Return");
        lblDateOfReturn.setForeground(textColor);
        lblDateOfReturn.setFont(new Font("Candara", Font.BOLD, 18));
        lblDateOfReturn.setBounds(320, 340, 118, 29);
        contentPane.add(lblDateOfReturn);

        textField = new JTextField();
        textField.setForeground(new Color(105, 105, 105));
        textField.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        textField.setBounds(500, 110, 105, 23);
        contentPane.add(textField);

        textField_1 = new JTextField();
        textField_1.setForeground(new Color(105, 105, 105));
        textField_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        textField_1.setBounds(70, 90, 145, 23);
        bg.add(textField_1);

        b1 = new JButton("Search");
        b1.addActionListener(this);
        b1.setBounds(620, 108, 105, 29);
        b1.setFont(new Font("Candara", Font.BOLD, 16));
        b1.setBackground(textColor);
        b1.setForeground(Color.WHITE);
        b1.setHorizontalAlignment(SwingConstants.CENTER);
	    contentPane.add(b1);

        textField_2 = new JTextField();
        textField_2.setEditable(false);
        textField_2.setForeground(new Color(0, 100, 0));
        textField_2.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
        textField_2.setBounds(500, 165, 225, 23);
        textField_2.setColumns(10);
        contentPane.add(textField_2);

        textField_3 = new JTextField();
        textField_3.setEditable(false);
        textField_3.setForeground(new Color(0, 100, 0));
        textField_3.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
        textField_3.setColumns(10);
        textField_3.setBounds(70, 215, 140, 23);
        bg.add(textField_3);

        textField_4 = new JTextField();
        textField_4.setEditable(false);
        textField_4.setForeground(new Color(0, 100, 0));
        textField_4.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
        textField_4.setColumns(10);
        textField_4.setBounds(500, 220, 225, 23);
        contentPane.add(textField_4);

        textField_5 = new JTextField();
        textField_5.setForeground(new Color(0, 100, 0));
        textField_5.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
        textField_5.setEditable(false);
        textField_5.setColumns(10);
        textField_5.setBounds(70, 325, 140, 23);
        bg.add(textField_5);

        textField_6 = new JTextField();
        textField_6.setForeground(new Color(0, 100, 0));
        textField_6.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
        textField_6.setEditable(false);
        textField_6.setColumns(10);
        textField_6.setBounds(500, 280, 225, 23);
        contentPane.add(textField_6);

        dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("yyyy-MM-dd");
        dateChooser.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
        dateChooser.setBounds(500, 340, 225, 25);
        contentPane.add(dateChooser);

        b2 = new JButton("Return");
        b2.addActionListener(this);
        b2.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        b2.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
        b2.setBounds(615, 390, 110, 30);
        b2.setBackground(new Color(0, 209, 23));
        b2.setForeground(Color.WHITE);
        contentPane.add(b2);

        b3 = new JButton("Back");
        b3.addActionListener(this);
        b3.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        b3.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
        b3.setBounds(320, 390, 100, 30);
        b3.setBackground(new Color(0, 175, 238));
        b3.setForeground(Color.WHITE);
	    contentPane.add(b3);

        panel1.add(bg);
        contentPane.add(panel1);

        JPanel panel = new JPanel();
        panel.setBounds(210, 0, 600, 510);
        panel.setBackground(myColor);
        contentPane.add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?characterEncoding=latin1", "root", "vansh123");
            if(ae.getSource() == b1){
                String sql = "select * from issueBook where student_id = ? and book_id =?";
                PreparedStatement st = con.prepareStatement(sql);
                st.setString(1, textField_1.getText());
                st.setString(2, textField.getText());
                ResultSet rs = st.executeQuery();
		
                while (rs.next()) {
                    textField_2.setText(rs.getString("bname"));
                    textField_3.setText(rs.getString("sname"));
                    textField_4.setText(rs.getString("course"));
                    textField_5.setText(rs.getString("branch"));
                    textField_6.setText(rs.getString("dateOfIssue"));
		        }
                
                st.close();
                rs.close();
            }

            if(ae.getSource() == b2){
                String sql = "insert into returnBook(book_id, student_id, bname, sname,course, branch, dateOfIssue, dateOfReturn) values(?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement st = con.prepareStatement(sql);
                st.setString(1, textField.getText());
                st.setString(2, textField_1.getText());
                st.setString(3, textField_2.getText());
                st.setString(4, textField_3.getText());
                st.setString(5, textField_4.getText());
                st.setString(6, textField_5.getText());
                st.setString(7, textField_6.getText());
                st.setString(8, ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText());
                int i = st.executeUpdate();
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "Book returned Successfully");
                    delete();
                }
            
                else
                    JOptionPane.showMessageDialog(null, "Something Went Wrong");
		
            }

            if(ae.getSource() == b3){
                this.setVisible(false);
		        new admin_menu().setVisible(true);
			
            }
            con.close();
        }
        catch(Exception e){
            if(textField.getText().length() == 0 || textField_1.getText().length() == 0){
                JOptionPane.showMessageDialog(null,"Invalid Book ID or Student ID\n");
            }
            
            else
                JOptionPane.showMessageDialog(null, "Something Went Wrong");
        }
    }
}
