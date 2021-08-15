import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
public class viewStudents extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTable table_1;
    private JButton b,sb,db,ab;
    private JLabel l,txt,txt_name;
    private JTextField txt1,txt2;

    public static void main(String[] args) {
        new viewStudents().setVisible(true);
    }

    public void delete() {
        try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?characterEncoding=latin1", "root", "vansh123");
                String sql = "delete from student where student_id=?";
                PreparedStatement st = con.prepareStatement(sql);
                st.setString(1, txt2.getText());
                int i = st.executeUpdate();
                if (i > 0)
                    JOptionPane.showMessageDialog(null, "Student Removed Successfully");
                else
                    JOptionPane.showMessageDialog(null, "Error in Removing");
            } 

        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
	    }
    }

    public void bookDet() {
        Connection con;
        Statement s;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?characterEncoding=latin1","root","vansh123");
            s =con.createStatement();
            String sql = "Select * from student";
            ResultSet rs = s.executeQuery(sql);

            while(rs.next()){
                String sid = String.valueOf(rs.getString("student_id"));
                String name = rs.getString("name");
                String Father = rs.getString("father");
                String Course = rs.getString("course");
                String Branch = rs.getString("branch");
                String Year = rs.getString("year");
                String Sem = rs.getString("semester");

                String tbData[] = {sid , name, Father,Course,Branch,Year,Sem};
                String tbData11[] = {"Srudent ID" , "Name", "Father's Name", "Course", "Branch","Year","Semester"};
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
        Connection con;
        //Statement s;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?characterEncoding=latin1","root","vansh123"); 
            if(ae.getSource() == sb){       
                String sql = "select * from student where name =?";
                PreparedStatement st = con.prepareStatement(sql);
                st.setString(1, txt1.getText());
                ResultSet rs = st.executeQuery();
    
                while (rs.next()) {
                    txt2.setText(rs.getString("student_id"));
                }

                st.close();
                rs.close();
            }

            if(ae.getSource() == db){
                JOptionPane.showConfirmDialog(null, "Do you want to Remove Student?");
                delete();
            }

            if(ae.getSource() == b){
                this.setVisible(false);
                new statistics().setVisible(true);		
            }

            if(ae.getSource() == ab){
                this.setVisible(false);
                new AddBook().setVisible(true);
            }
            con.close();
        }

        catch(Exception e)
        {
            if(txt.getText().length() == 0){
                JOptionPane.showMessageDialog(null,"Enter Student Id\n");
            }

            else
                JOptionPane.showMessageDialog(null,"Something went wrong\n");
        }    
}

    public viewStudents(){
        setTitle("Student Details");
        setBounds(400, 200, 1200, 670);
        Color myColor = new Color(9, 19, 35);
        Color textColor = new Color(255,103,0); 
	    contentPane = new JPanel();
        contentPane.setBackground(myColor);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(42, 200, 1100, 300);

        table_1 = new JTable();
        table_1.getTableHeader().setBackground(new Color(255,153,0)); //new Color(204, 255, 255)
        table_1.setForeground(Color.black);
        table_1.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,18));
        table_1.setFont(new Font("Segoe UI",Font.BOLD,16));
        table_1.setRowHeight(25);
        table_1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        scrollPane.setViewportView(table_1);
        scrollPane.getViewport().setBackground(Color.white);
        contentPane.add(scrollPane);

        l = new JLabel("View Students");
        l.setForeground(new Color(0, 213, 23));
        l.setBounds(515,40,300,100);
        l.setFont(new Font("Candara",Font.BOLD,28));
        contentPane.add(l);

        txt = new JLabel("Student ID");
        txt.setFont(new Font("Segoe UI", Font.BOLD, 17));
        txt.setBounds(102, 140, 350, 28);
        txt.setForeground(Color.white);
        contentPane.add(txt);

        txt_name = new JLabel("Student Name");
        txt_name.setFont(new Font("Segoe UI", Font.BOLD, 17));
        txt_name.setBounds(658, 140, 350, 28);
        txt_name.setForeground(Color.white);
        contentPane.add(txt_name);

        txt1 = new JTextField();
        txt1.setFont(new Font("Segoe UI", Font.BOLD,15));
        txt1.setBounds(795, 140, 200, 28);
        txt1.setForeground(new Color(255,0,204));
        contentPane.add(txt1);

        txt2 = new JTextField();
        txt2.setFont(new Font("Segoe UI", Font.BOLD, 15));
        txt2.setBounds(200, 140, 150, 28);
        txt2.setForeground(new Color(255,0,204));
        txt2.setBackground(new Color(234, 237, 237));
        txt2.setEditable(false);
        contentPane.add(txt2);

        sb = new JButton("Search");
        sb.addActionListener(this);
        sb.setFont(new Font("Segoe UI", Font.BOLD, 16));
        sb.setBounds(1022, 140, 106, 30);
        sb.setBackground(textColor);
        sb.setForeground(Color.WHITE);
        contentPane.add(sb);

        ab = new JButton("Add Student");
        ab.addActionListener(this);
        ab.setFont(new Font("Segoe UI", Font.BOLD, 16));
        ab.setBounds(370, 140, 130, 28);
        ab.setBackground(new Color(0, 209, 23));
        ab.setForeground(Color.WHITE);
        contentPane.add(ab);

        b = new JButton("Back");
        b.addActionListener(this);
        b.setFont(new Font("Segoe UI", Font.BOLD, 16));
        b.setBounds(42, 540, 96, 30);
        b.setBackground(new Color(0, 175, 238));
        b.setForeground(Color.WHITE);
        contentPane.add(b);

        db = new JButton("Remove Student");
        db.addActionListener(this);
        db.setFont(new Font("Segoe UI", Font.BOLD, 16));
        db.setBounds(980, 540, 160, 30);
        db.setBackground(new Color(255, 0, 0));
        db.setForeground(Color.WHITE);
        contentPane.add(db);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        bookDet();
    }

}