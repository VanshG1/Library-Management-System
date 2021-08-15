import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class statistics extends JFrame {

    JPanel p;
    JButton b1,b2,b3,b4,b5;
    JLabel background,l;

    public statistics()
    {
        p= new JPanel();
        getContentPane().add(p);
        p.setLayout(null);
        p.setBounds(150, 120, 600, 333);
        p.setBackground(Color.WHITE);

        JLabel bg = new JLabel();
        bg.setIcon(new ImageIcon("LibraryManagement\\src\\icons\\StatsBg.png"));
        bg.setBounds(0,0,600,333);

        l = new JLabel("Statistics");
        l.setForeground(new Color(255,103,0));
        l.setBounds(380, 10, 200, 133);
        l.setFont(new Font("Candara", Font.BOLD, 30));
        getContentPane().add(l);

        b1= new JButton("Returned Books");
        b2= new JButton("Issued Books");
        b3= new JButton("Deleted Books");
        b4= new JButton("Back");
        b5= new JButton("View Students");

        b1.setBackground(new Color(255,0,108));
        b1.setForeground(Color.white);
        b1.setFont(new Font("Segoe UI", Font.BOLD, 15));
        b2.setBackground(new Color(0, 209, 23));
        b2.setForeground(Color.white);
        b2.setFont(new Font("Segoe UI", Font.BOLD, 15));
        b3.setBackground(new Color(255, 0, 0));
        b3.setForeground(Color.white);
        b3.setFont(new Font("Segoe UI", Font.BOLD, 15));
        b4.setBackground(new Color(9, 159, 255));
        b4.setForeground(Color.white);
        b4.setFont(new Font("Segoe UI", Font.BOLD, 16));
        b5.setForeground(Color.white);
        b5.setBackground(new Color(204, 0, 255 ));
        b5.setFont(new Font("Segoe UI", Font.BOLD, 16));

        bg.add(b1);
        b1.setBounds(350,100,150,30);
        bg.add(b2);
        b2.setBounds(350,220,150,30);
        bg.add(b3);
        b3.setBounds(120,220,140,30);
        bg.add(b4);
        b4.setBounds(480,290,100,30);
        bg.add(b5);
        b5.setBounds(120,100,150,30);

        p.add(bg);
        getContentPane().setBackground(new Color(9, 19, 35));
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Statistics");

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                returnedBook rb = new returnedBook();
                rb.setVisible(true);
                dispose();
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                issuedBook ib = new issuedBook();
                ib.setVisible(true);
                dispose();
            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletedBooks db = new deletedBooks();
                db.setVisible(true);
                dispose();
            }
        });

        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                admin_menu a = new admin_menu();
                a.setVisible(true);
                dispose();
            }
        });

        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewStudents v = new viewStudents();
                v.setVisible(true);
                dispose();
            }
        });


    }

    public static void main(String[] args) {
        new statistics();
    }

}