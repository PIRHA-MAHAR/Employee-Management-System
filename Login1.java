package Employee.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Login1 extends JFrame implements ActionListener {
    JTextField tempid;
    JPasswordField tpassword;
    JButton login, back;

    Login1() {
        setTitle("Employee Login");

        // Emp_ID Label and Field
        JLabel EmpId = new JLabel("Emp_ID");
        EmpId.setBounds(40, 20, 100, 30);
        add(EmpId);

        tempid = new JTextField();
        tempid.setBounds(150, 20, 150, 30);
        add(tempid);

        // Password Label and Field
        JLabel password = new JLabel("Password");
        password.setBounds(40, 70, 100, 30);
        add(password);

        tpassword = new JPasswordField();
        tpassword.setBounds(150, 70, 150, 30);
        add(tpassword);

        // Login Button
        login = new JButton("LOGIN");
        login.setBounds(150, 140, 150, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        // Back Button
        back = new JButton("BACK");
        back.setBounds(150, 180, 150, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        // Background image (optional)
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("ICONS/co.jpeg"));
        Image i22 = i11.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel imag = new JLabel(i33);
        imag.setBounds(350, 10, 600, 400);
        add(imag);

        // Frame setup
        setSize(600, 300);
        setLocation(450, 200);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            try {
                String ID = tempid.getText().trim();
                String password = new String(tpassword.getPassword());

                if (ID.equals("") || password.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill all fields");
                    return;
                }

                Conn conn = new Conn();

                String query = "SELECT * FROM Loginemp WHERE empid = '"+ID+"'AND Password = '"+password+"'";
                //PreparedStatement ps = conn.connection.prepareStatement(query);
                //ps.setString(1, ID);
                //ps.setString(2, password);
                ResultSet result=conn.statement.executeQuery(query);

               // ResultSet result = ps.executeQuery();

                if (result.next()) {
                    setVisible(false);
                    new EmployeeDashboard(ID); // Pass Emp_ID to dashboard
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error connecting to database");
            }
        } else if (e.getSource() == back) {
            // You can navigate to main menu or home here
            setVisible(false);
            // new MainMenu(); // if you have a main screen
        }
    }

    public static void main(String args[]) {
        new Login1();
    }
}