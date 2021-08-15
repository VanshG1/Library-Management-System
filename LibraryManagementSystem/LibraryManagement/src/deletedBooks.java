import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
public class deletedBooks extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTable table_1;
    private JButton b,sb,db,ab;
    private JLabel l,txt,txt_name;
    private JTextField txt1,txt2;

    public static void main(String[] args) {
        new deletedBooks().setVisible(true);
    }

    public void delete() {
        try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?characterEncoding=latin1", "root", "vansh123");
                String sql = "delete from bookBackup where book_id=?";
                PreparedStatement st = con.prepareStatement(sql);
                st.setString(1, txt2.getText());
                int i = st.executeUpdate();
                if (i > 0)
                    JOptionPane.showMessageDialog(null, "Book Removed Successfully");
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
            String sql = "Select * from bookBackup";
            ResultSet rs = s.executeQuery(sql);

            while(rs.next()){
                String bid = String.valueOf(rs.getString("book_id"));
                String name = rs.getString("name");
                String Isbn = rs.getString("isbn");
                String author = rs.getString("publisher");
                String edi = rs.getString("edition");
                String gen = rs.getString("genre");
                String pr = rs.getString("price");

                String tbData[] = {bid , name, Isbn,author,edi,gen,pr};
                String tbData11[] = {"Book ID" , "Book Name", "ISBN", "Author", "Edition","Genre","Price"};
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
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?characterEncoding=latin1","root","vansh123"); 
            if(ae.getSource() == sb){       
                String sql = "select * from bookBackup where name =?";
                PreparedStatement st = con.prepareStatement(sql);
                st.setString(1, txt1.getText());
                ResultSet rs = st.executeQuery();
    
                while (rs.next()) {
                    txt2.setText(rs.getString("book_id"));
                }

                st.close();
                rs.close();
            }

            if(ae.getSource() == db){
    
                JOptionPane.showConfirmDialog(null, "Are you sure you permanently delete the book?");
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
                JOptionPane.showMessageDialog(null,"Enter Book Id\n");
            }

            else
                JOptionPane.showMessageDialog(null,"Something went wrong\n");
        }    
}

    public deletedBooks(){
        setTitle("Book Details");
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
        table_1.getTableHeader().setBackground(new Color(255,153,0));
        table_1.setForeground(Color.black);
        table_1.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,18));
        table_1.setFont(new Font("Segoe UI",Font.BOLD,16));
        table_1.setRowHeight(25);
        table_1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        scrollPane.setViewportView(table_1);
        scrollPane.getViewport().setBackground(Color.white);
        contentPane.add(scrollPane);

        l = new JLabel("Deleted Books");
        l.setForeground(new Color(0, 213, 23));
        l.setBounds(515,40,300,100);
        l.setFont(new Font("Candara",Font.BOLD,28));
        contentPane.add(l);

        txt = new JLabel("Book ID");
        txt.setFont(new Font("Segoe UI", Font.BOLD, 17));
        txt.setBounds(102, 140, 350, 28);
        txt.setForeground(Color.white);
        contentPane.add(txt);

        txt_name = new JLabel("Book Name");
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

        ab = new JButton("Add Book");
        ab.addActionListener(this);
        ab.setFont(new Font("Segoe UI", Font.BOLD, 16));
        ab.setBounds(370, 140, 116, 28);
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

        db = new JButton("Delete Permanently");
        db.addActionListener(this);
        db.setFont(new Font("Segoe UI", Font.BOLD, 14));
        db.setBounds(960, 540, 180, 30);
        db.setBackground(new Color(255, 0, 0));
        db.setForeground(Color.WHITE);
        contentPane.add(db);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        bookDet();
    }

}
