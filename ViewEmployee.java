package Employee.Management.System;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class ViewEmployee extends JFrame implements ActionListener {

    Choice co;
    JTable table;
    Button searchBtn,back,UpdateBtn; // Button for search

    ViewEmployee() {

        // COMPONENTS
        // Adding background
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("ICONS/back.jpeg"));
        Image im1 = img.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon img1 = new ImageIcon(im1);
        JLabel l1 = new JLabel(img1);
        l1.setBounds(0, 0, 900, 700);
        add(l1);

        // Label
        JLabel search = new JLabel("Search By EmployeeID");
        search.setBounds(50, 50, 250, 30);
        search.setFont(new Font("Times New Roman", Font.BOLD, 21));
        search.setForeground(Color.black);
        l1.add(search);

        // Choice dropdown
        co = new Choice();
        co.setBounds(280, 50, 200, 30);
        l1.add(co);
        try {
            Conn cc = new Conn();
            String query = "select * from Emp";
            ResultSet resultSet = cc.statement.executeQuery(query);
            while (resultSet.next()) {
                co.add(resultSet.getString("empid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Search button
        searchBtn = new Button("Search");
        searchBtn.setBounds(500, 50, 100, 30);
        searchBtn.setFont(new Font("Arial", Font.BOLD, 16));
        searchBtn.addActionListener(this);
        l1.add(searchBtn);

        UpdateBtn = new Button("Update");
        UpdateBtn.setBounds(630, 50, 100, 30);
        UpdateBtn.addActionListener(this);
        l1.add(UpdateBtn);

        back=new Button("Back");
        back.setBounds(750, 50, 100, 30);
        back.addActionListener(this);
        l1.add(back);

        // Table
        table = new JTable();
        try {
            Conn C = new Conn();
            // We make object of Conn class whenever we have to make connection between Database and our Java Program.
            ResultSet resultSet = C.statement.executeQuery("select * from Emp");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Scroll pane for table
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(0, 100, 900, 600);
        add(scroll);

        // Frame settings
        setSize(900, 700);
        setLocation(300, 100);
        setLayout(null);
        setVisible(true);
    }

    // ActionListener logic
    public void actionPerformed(ActionEvent e) {

            if (e.getSource() == searchBtn) {
                try {
                Conn C = new Conn();
                    String empId = co.getSelectedItem();
                   String query = "SELECT * FROM Emp WHERE empid= '" + empId + "'";

                    // We make object of Conn class whenever We have to make connection between Database and Our Java Program.
                ResultSet resultSet = C.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            } catch(Exception E){
                E.printStackTrace();
            }
        }
        else if(e.getSource() == back) {
            setVisible(false);
            new Home();//Open Manin Screen
        }
        else if(e.getSource() == UpdateBtn) {
             setVisible(false);
             new UpdateEmployee(co.getSelectedItem());
            }
    }

    public static void main(String args[]) {
        new ViewEmployee();
    }
}
