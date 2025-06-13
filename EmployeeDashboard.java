package Employee.Management.System;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class EmployeeDashboard extends JFrame {
    String empID;

    public EmployeeDashboard(String empID) {
        this.empID = empID;

        // Frame setup
        setTitle("Employee Dashboard");
        setSize(700, 500);
        setLocation(400, 150);
        setLayout(null);

        JLabel heading = new JLabel("Employee Details");
        heading.setBounds(250, 10, 200, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(heading);

        try {
            Conn conn = new Conn();
            String query = "SELECT * FROM Emp WHERE empid = ?";
            PreparedStatement ps = conn.connection.prepareStatement(query);
            ps.setString(1, empID);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Example: Display each detail
                JLabel l1 = new JLabel("Name: " + rs.getString("name"));
                l1.setBounds(50, 60, 300, 25);
                add(l1);

                JLabel l2 = new JLabel("Father's Name: " + rs.getString("F_name"));
                l2.setBounds(50, 90, 300, 25);
                add(l2);

                JLabel l3 = new JLabel("DOB: " + rs.getString("DOB"));
                l3.setBounds(50, 120, 300, 25);
                add(l3);

                JLabel l4 = new JLabel("Phone: " + rs.getString("Phone"));
                l4.setBounds(50, 150, 300, 25);
                add(l4);

                JLabel l5 = new JLabel("Email: " + rs.getString("Email"));
                l5.setBounds(50, 180, 300, 25);
                add(l5);

                JLabel l6 = new JLabel("Designation: " + rs.getString("designation"));
                l6.setBounds(50, 210, 300, 25);
                add(l6);

                JLabel l7 = new JLabel("Address: " + rs.getString("Address"));
                l7.setBounds(50, 240, 300, 25);
                add(l7);

                JLabel l8 = new JLabel("Education: " + rs.getString("Education"));
                l8.setBounds(50, 270, 300, 25);
                add(l8);

                JLabel l9 = new JLabel("Salary: ₹" + rs.getString("Salary"));
                l9.setBounds(50, 300, 300, 25);
                add(l9);

                JLabel l10 = new JLabel("Gender: " + rs.getString("Gender"));
                l10.setBounds(50, 330, 300, 25);
                add(l10);

                JLabel l11 = new JLabel("Adhar No: " + rs.getString("Adhar_No"));
                l11.setBounds(50, 360, 300, 25);
                add(l11);
            } else {
                JOptionPane.showMessageDialog(null, "Employee not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }
}
