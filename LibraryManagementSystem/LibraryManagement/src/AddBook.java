import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.event.*;
import java.sql.*;

public class AddBook extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField t1,t2,t3,t4,t5,t6;
    private JButton b1,b2,btn,btn1,btn2;
    JComboBox comboBox;
        
    public static void main(String[] args) {
	    new AddBook().setVisible(true);
    }

    public AddBook() {
        setBounds(600, 100, 950, 660);
        Color myColor = new Color(9, 19, 35); 
        Color textColor = new Color(237,93,0); 
        Color textFieldColor = new Color(54, 57, 61);
        UIManager.put("TextField.caretForeground", new ColorUIResource(Color.white));

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("Add Book");
        title.setForeground(new Color(255,0,108));
        title.setFont(new Font("Candara", Font.BOLD, 30));
        title.setBounds(500, 40, 140, 50);
        contentPane.add(title);

        JLabel l1 = new JLabel("Name");
        l1.setForeground(textColor);
        l1.setFont(new Font("Candara", Font.BOLD, 20));
        l1.setBounds(400, 180, 90, 22);
        contentPane.add(l1);

        JLabel l2 = new JLabel("ISBN");
        l2.setForeground(textColor);
        l2.setFont(new Font("Candara", Font.BOLD, 20));
        l2.setBounds(400, 240, 90, 22);
        contentPane.add(l2);

        JLabel l3 = new JLabel("Author");
        l3.setForeground(textColor);
        l3.setFont(new Font("Candara", Font.BOLD, 20));
        l3.setBounds(400, 300, 120, 22);
        contentPane.add(l3);

        JLabel l4 = new JLabel("Price");
        l4.setForeground(textColor);
        l4.setFont(new Font("Candara", Font.BOLD, 20));
        l4.setBounds(400, 480, 90, 25);
        contentPane.add(l4);

        JLabel l5 = new JLabel("Genre");
        l5.setForeground(textColor);
        l5.setFont(new Font("Candara", Font.BOLD, 20));
        l5.setBounds(400, 420, 90, 22);
        contentPane.add(l5);

        JLabel l6 = new JLabel("Book ID");
        l6.setForeground(textColor);
        l6.setFont(new Font("Candara", Font.BOLD, 20));
        l6.setBounds(400, 120, 90, 22);
        contentPane.add(l6);

        JLabel l7 = new JLabel("Edition");
        l7.setForeground(textColor);
        l7.setFont(new Font("Candara", Font.BOLD, 20));
        l7.setBounds(400, 360, 90, 22);
        contentPane.add(l7);

        t1 = new JTextField();
        t1.setForeground(Color.white);
        t1.setBackground(textFieldColor);
        t1.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        t1.setBounds(550, 117, 198, 23);
        t1.setColumns(10);
        contentPane.add(t1);

        t2 = new JTextField();
        t2.setForeground(Color.white);
        t2.setBackground(textFieldColor);
        t2.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        t2.setColumns(10);
        t2.setBounds(550, 177, 198, 23);
        contentPane.add(t2);

        t3 = new JTextField();
        t3.setForeground(Color.white);
        t3.setBackground(textFieldColor);
        t3.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        t3.setColumns(10);
        t3.setBounds(550, 237, 198, 23);
        contentPane.add(t3);

        t4 = new JTextField();
        t4.setForeground(Color.white);
        t4.setBackground(textFieldColor);
        t4.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        t4.setColumns(10);
        t4.setBounds(550, 297, 198, 23);
        contentPane.add(t4);

        t5 = new JTextField();
        t5.setForeground(Color.white);
        t5.setBackground(textFieldColor);
        t5.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        t5.setColumns(10);
        t5.setBounds(550, 417, 198, 23);
        contentPane.add(t5);

        t6 = new JTextField();
        t6.setForeground(Color.white);
        t6.setBackground(textFieldColor);
        t6.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        t6.setColumns(10);
        t6.setBounds(550, 477, 198, 23);
        contentPane.add(t6);

        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        comboBox.setForeground(Color.white);
        comboBox.setBackground(textFieldColor);
        comboBox.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        comboBox.setBounds(550, 357, 194, 23);
        contentPane.add(comboBox);

        b1 = new JButton("Add");
        b1.addActionListener(this);
        b1.setBorder(new CompoundBorder(new LineBorder(new Color(128, 128, 128)), null));
        b1.setFont(new Font("Segoe UI", Font.BOLD, 15));
        b1.setBounds(650, 550, 100, 33);
        b1.setBackground(new Color(0, 209, 23));
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);

        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setBorder(new CompoundBorder(new LineBorder(new Color(105, 105, 105)), null));
        b2.setFont(new Font("Segoe UI", Font.BOLD, 16));
        b2.setBounds(400, 550, 100, 33);
        b2.setBackground(new Color(9, 159, 255));
        b2.setForeground(Color.WHITE);
        
        contentPane.add(b2);

        JPanel panel1 = new JPanel();
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

        btn1 = new JButton("Add Student",new ImageIcon("LibraryManagement\\src\\icons\\user-icon2.png"));
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
        contentPane.add(panel);
            
        panel.setBackground(myColor);
        contentPane.setBackground(Color.WHITE);
        setResizable(false);
        setLocationRelativeTo(null);

    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?characterEncoding=latin1", "root", "vansh123");
            if(ae.getSource() == b1){
                String sql = "insert into book(book_id, name, isbn, publisher, edition, genre, price) values(?, ?, ?, ?, ?, ?, ?)";
		        PreparedStatement st = con.prepareStatement(sql);
                st.setString(1, t1.getText());
                st.setString(2, t2.getText());
                st.setString(3, t3.getText());
                st.setString(4, t4.getText());
                st.setString(5, (String) comboBox.getSelectedItem());
                st.setString(6, t5.getText());
                st.setString(7, t6.getText());

                int rs = st.executeUpdate();
                if (rs > 0)
                    JOptionPane.showMessageDialog(null, "Successfully Added");
                else
                    JOptionPane.showMessageDialog(null, "Something Went Wrong");
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
                st.close();
            }
            if(ae.getSource() == b2){
                this.setVisible(false);
		        new admin_menu().setVisible(true);
            }

            if(ae.getSource() == btn1){
                this.setVisible(false);
                new addStudents().setVisible(true);
            }

            if(ae.getSource() == btn2){
                this.setVisible(false);
                new returnBook().setVisible(true);
            
            }

            if(ae.getSource() == btn){
                this.setVisible(false);
                new viewStudents().setVisible(true);
            
            }

            con.close();
        }
        catch(Exception e){
            if(t1.getText().length()==0 || t2.getText().length()==0 || t3.getText().length()==0 || t4.getText().length()==0 || t5.getText().length()==0 || t6.getText().length()==0)
            {
                JOptionPane.showMessageDialog(null,"Please enter all details");
            }
            else
                JOptionPane.showMessageDialog(null, "Something Went Wrong");
        }

    }
}
