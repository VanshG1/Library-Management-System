import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class admin_menu  extends JFrame implements ActionListener{
    JPanel c;
    JButton view_but,issue_book,issued_but,add_user,add_book,return_book;

    public admin_menu()
    {
        setBounds(500,600,700,600);
        c = new JPanel();
        c.setBorder(new EmptyBorder(5, 5, 5, 5));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(c);
        c.setLayout(null);
        
        Image icon = Toolkit.getDefaultToolkit().getImage("LibraryManagement\\src\\icons\\home.jpg");  
        setIconImage(icon);
        setTitle("Home Page"); 

        Color myColor = new Color(9, 19, 35); 
        Color text = new Color(237,93,0);

        JPanel box = new JPanel();
        box.setBounds(40,20,600,80);
        box.setBackground(myColor);
        box.setLayout(new GridBagLayout());

        JLabel lms = new JLabel("LIBRARY MANAGEMENT SYSTEM");
        lms.setFont(new Font("Raleway", Font.BOLD, 28));
        lms.setForeground(text);
        lms.setSize(700,30);
        box.add(lms);
        add(box);

        view_but=new JButton("View Books");
        view_but.setBounds(60,270,120,25);
        view_but.addActionListener(this);
        add(view_but);

        issue_book=new JButton("Issue Book"); 
        issue_book.setBounds(255,270,120,25);
        issue_book.addActionListener(this);
        add(issue_book);

        issued_but=new JButton("Statistics");
        issued_but.setBounds(450,270,160,25);
        issued_but.addActionListener(this);
        add(issued_but);

        add_user=new JButton("Add Students");
        add_user.setBounds(60,470,120,25);
        add_user.addActionListener(this);
        add(add_user);

        add_book=new JButton("Add Books");
        add_book.setBounds(255,470,120,25);
        add_book.addActionListener(this);
        add(add_book);

        return_book=new JButton("Return Book");
        return_book.setBounds(450,470,160,25); 
        return_book.addActionListener(this);
        add(return_book);

        JLabel l1 = new JLabel();
        l1.setIcon(new ImageIcon("LibraryManagement\\src\\icons\\viewbook1.png"));
        l1.setBounds(45,10,400,350);
        add(l1);

        JLabel l2 = new JLabel();
        l2.setIcon(new ImageIcon("LibraryManagement\\src\\icons\\issueBooks1.png"));
        l2.setBounds(240,10,400,350);
        add(l2);

        JLabel l3 = new JLabel();
        l3.setIcon(new ImageIcon("LibraryManagement\\src\\icons\\statis1.png"));
        l3.setBounds(450,10,400,350);
        add(l3);

        JLabel l4 = new JLabel();
        l4.setIcon(new ImageIcon("LibraryManagement\\src\\icons\\addUser.png"));
        l4.setBounds(40,10,400,750);
        add(l4);

        JLabel l5 = new JLabel();
        l5.setIcon(new ImageIcon("LibraryManagement\\src\\icons\\BookIcon2.png"));
        l5.setBounds(240,10,400,750);
        add(l5);

        JLabel l6 = new JLabel();
        l6.setIcon(new ImageIcon("LibraryManagement\\src\\icons\\ReturnBook1.png"));
        l6.setBounds(450,10,400,750);
        add(l6);

        c.setBackground(Color.white);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args)
    {
        new admin_menu().setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == add_book){
            this.setVisible(false);
            new AddBook().setVisible(true);
        }

        if(ae.getSource() == issued_but){
            this.setVisible(false);
            new statistics().setVisible(true);
        }
        if(ae.getSource() == add_user){
            this.setVisible(false);
            new addStudents().setVisible(true);
        }
        if(ae.getSource() == issue_book){
            this.setVisible(false);
            new IssueBook().setVisible(true);
        }
        if(ae.getSource() == return_book){
            this.setVisible(false);
            new returnBook().setVisible(true);
        
        }
        if(ae.getSource() == view_but){
            this.setVisible(false);
            new viewBooks().setVisible(true);
        
        }

    }
    

}
