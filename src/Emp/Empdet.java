package Emp;



import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * User Registration using Swing
 * @author javaguides.net
 *
 */
public class Empdet extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField employeeno;
    private JTextField employeename;
    private JTextField age;
    private JTextField salary;
    private JButton btnNewButton;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	Empdet frame = new Empdet();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */

    public Empdet() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Desktop\\STDM.jpg"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblEmployeeDetail = new JLabel("EMPLOYEE DETAIL");
        lblEmployeeDetail.setFont(new Font("Times New Roman", Font.PLAIN, 42));
        lblEmployeeDetail.setBounds(362, 52, 325, 50);
        contentPane.add(lblEmployeeDetail);

        JLabel lblName = new JLabel("EMPLOYEE NO");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblName.setBounds(58, 152, 99, 43);
        contentPane.add(lblName);

        JLabel lblNewLabel = new JLabel("EMPLOYEE NAME");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel.setBounds(58, 243, 110, 29);
        contentPane.add(lblNewLabel);
        
        employeeno = new JTextField();
        employeeno.setFont(new Font("Tahoma", Font.PLAIN, 32));
        employeeno.setBounds(214, 151, 228, 50);
        contentPane.add(employeeno);
        employeeno.setColumns(10);

        employeename = new JTextField();
        employeename.setFont(new Font("Tahoma", Font.PLAIN, 32));
        employeename.setBounds(214, 235, 228, 50);
        contentPane.add(employeename);
        employeename.setColumns(10);

       
        

        age = new JTextField();
        age.setFont(new Font("Tahoma", Font.PLAIN, 32));
        age.setBounds(707, 151, 228, 50);
        contentPane.add(age);
        age.setColumns(10);

        JLabel lblage = new JLabel("AGE");
        lblage.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblage.setBounds(542, 159, 99, 29);
        contentPane.add(lblage);


        JLabel lblsalary = new JLabel("SALARY");
        lblsalary.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblsalary.setBounds(542, 329, 139, 26);
        contentPane.add(lblsalary);

        salary = new JTextField();
        salary.setFont(new Font("Tahoma", Font.PLAIN, 32));
        salary.setBounds(707, 320, 228, 50);
        contentPane.add(salary);
        salary.setColumns(10);


        btnNewButton = new JButton("SAVE DATA");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String employeeNo = employeeno.getText();
                String employeeName = employeename.getText();
                String Age = age.getText();
                String Salary = salary.getText();
                

                String msg = "" +employeename;
                msg += " \n";
                
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdetail?useSSL=false", "root", "test");

                    String query = "INSERT INTO account values('" + employeeNo + "','" + employeeName + "','" + Age + "','" +
                        Salary + "')";

                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(btnNewButton, "This is alredy exist");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton,
                            "Welcome, " + msg + "Employee data update successfully");
                    }
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnNewButton.setBounds(399, 447, 259, 74);
        contentPane.add(btnNewButton);
    }

}