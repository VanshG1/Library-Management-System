import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
public class issuedBook extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTable table_1;
    private JButton b;
    private JLabel l;

    public static void main(String[] args) {
        new issuedBook().setVisible(true);
    }

    public void issueBook() {
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?characterEncoding=latin1","root","vansh123");
            String sql = "select *from issuebook";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                String bid = rs.getString("book_id");
                String sid = rs.getString("student_id");
                String Bname = rs.getString("bname");
                String Sname = rs.getString("sname");
                String Course = rs.getString("course");
                String Branch = rs.getString("branch");
                String doI = rs.getString("dateOfIssue");

                String tbData[] = {sid, bid , Bname, Sname,Course,Branch,doI};
                String tbData11[] = {"Student ID", "Book ID" , "Book Name", "Student Name", "Course", "Branch","Date of Issue"};
                DefaultTableModel tblModel = (DefaultTableModel)table_1.getModel();
                tblModel.setColumnIdentifiers(tbData11);
                tblModel.addRow(tbData);
            }

        }catch(Exception e){
            System.out.println("Database Error" + e);
        }

    }

    public void actionPerformed(ActionEvent ae)
        {
            try{
                if(ae.getSource() == b){
                    this.setVisible(false);
                    new statistics().setVisible(true);		
                }
            }
            catch(Exception e)
            {

            }
        }

    public issuedBook(){
        setTitle("Statistics");
        setBounds(400, 200, 1200, 600);
        Color myColor = new Color(9, 19, 35);
	    contentPane = new JPanel();
        contentPane.setBackground(myColor);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(42, 151, 1100, 300);

        table_1 = new JTable();
        table_1.getTableHeader().setBackground(new Color(255,153,0));
        table_1.setForeground(Color.black);
        table_1.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,18));
        table_1.setFont(new Font("Segoe UI",Font.BOLD,16));
        table_1.setRowHeight(25);
        scrollPane.setViewportView(table_1);
        scrollPane.getViewport().setBackground(Color.white);
        contentPane.add(scrollPane);

        b = new JButton("Back");
        b.addActionListener(this);
        b.setFont(new Font("Segoe UI", Font.BOLD, 16));
        b.setBounds(42, 488, 96, 28);
        b.setBackground(new Color(9, 159, 255));
        b.setForeground(Color.WHITE);
        contentPane.add(b);

        l = new JLabel("Issued Book Details");
        l.setForeground(new Color(0, 213, 23));
        l.setBounds(450,40,300,100);
        l.setFont(new Font("Candara",Font.BOLD,28));
        contentPane.add(l);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        issueBook();
    }

}