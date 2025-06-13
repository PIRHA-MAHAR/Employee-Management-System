package Employee.Management.System;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;

public class AddEmployee extends JFrame implements ActionListener {
    // Attributes
    JTextField tname, tfname, taddress, tphone, tadhar, temail, tsalary;
    JRadioButton male, female;
    ButtonGroup genderGroup;

    JLabel tempid;
    JDateChooser tdob;
    JComboBox<String> edu, deptComboBox, desigComboBox;
    JButton addbutton, back;
    Random ran = new Random();
    int num = ran.nextInt(999999);

    AddEmployee() {
        getContentPane().setBackground(new Color(163, 255, 188)); // Background color
        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);

        // Name
        JLabel name = new JLabel("Name ");
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font("Arial", Font.BOLD, 20));
        add(name);
        tname = new JTextField();
        tname.setBounds(200, 150, 150, 30);
        tname.setBackground(Color.WHITE);
        add(tname);

        // Father's Name
        JLabel fname = new JLabel("Father's Name ");
        fname.setBounds(400, 150, 150, 30);
        fname.setFont(new Font("Arial", Font.BOLD, 20));
        add(fname);
        tfname = new JTextField();
        tfname.setBounds(600, 150, 150, 30);
        tfname.setBackground(Color.WHITE);
        add(tfname);

        // Birth Date
        JLabel dob = new JLabel("Birth Date ");
        dob.setBounds(50, 200, 150, 30);
        dob.setFont(new Font("Arial", Font.BOLD, 20));
        add(dob);
        tdob = new JDateChooser();
        tdob.setBounds(200, 200, 150, 30);
        tdob.setBackground(Color.WHITE);
        add(tdob);

        // Gender
        JLabel gender = new JLabel("Gender");
        gender.setBounds(400, 400, 150, 30);
        gender.setFont(new Font("Arial", Font.BOLD, 20));
        add(gender);
        male = new JRadioButton("Male");
        male.setBounds(550, 400, 70, 30);
        female = new JRadioButton("Female");
        female.setBounds(630, 400, 80, 30);
        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        add(male);
        add(female);

        // Salary
        JLabel salary = new JLabel("Salary ");
        salary.setBounds(400, 200, 150, 30);
        salary.setFont(new Font("Arial", Font.BOLD, 20));
        add(salary);
        tsalary = new JTextField();
        tsalary.setBounds(600, 200, 150, 30);
        tsalary.setBackground(Color.WHITE);
        add(tsalary);

        // Address
        JLabel address = new JLabel("Address");
        address.setBounds(50, 250, 150, 30);
        address.setFont(new Font("Arial", Font.BOLD, 20));
        add(address);
        taddress = new JTextField();
        taddress.setBounds(200, 250, 150, 30);
        taddress.setBackground(Color.WHITE);
        add(taddress);

        // Phone
        JLabel phone = new JLabel("Phone ");
        phone.setBounds(400, 250, 150, 30);
        phone.setFont(new Font("Arial", Font.BOLD, 20));
        add(phone);
        tphone = new JTextField();
        tphone.setBounds(600, 250, 150, 30);
        tphone.setBackground(Color.WHITE);
        add(tphone);

        // Email
        JLabel email = new JLabel("Email ");
        email.setBounds(50, 300, 150, 30);
        email.setFont(new Font("Arial", Font.BOLD, 20));
        add(email);
        temail = new JTextField();
        temail.setBounds(200, 300, 150, 30);
        temail.setBackground(Color.WHITE);
        add(temail);

        // Education
        JLabel education = new JLabel("Higher Education");
        education.setBounds(400, 300, 200, 30);
        education.setFont(new Font("Arial", Font.BOLD, 20));
        add(education);
        String items[] = {"BSSE", "BBA", "B.Tech", "BA", "BSC", "B.Com", "MCA", "MA", "MTech", "MSC", "PHD"};
        edu = new JComboBox<>(items);
        edu.setBackground(Color.WHITE);
        edu.setBounds(600, 300, 150, 30);
        add(edu);

        // Adhar Number
        JLabel adhar = new JLabel("Adhar Number");
        adhar.setBounds(400, 350, 150, 30);
        adhar.setFont(new Font("Arial", Font.BOLD, 20));
        add(adhar);
        tadhar = new JTextField();
        tadhar.setBounds(600, 350, 150, 30);
        tadhar.setBackground(Color.WHITE);
        add(tadhar);

        // Employee ID
        JLabel empid = new JLabel("Employee ID");
        empid.setBounds(50, 400, 200, 30);
        empid.setFont(new Font("Arial", Font.BOLD, 20));
        add(empid);
        tempid = new JLabel("" + num);
        tempid.setBounds(200, 400, 150, 30);
        tempid.setFont(new Font("Arial", Font.BOLD, 20));
        tempid.setForeground(Color.RED);
        add(tempid);

        // Department
        JLabel department = new JLabel("Department");
        department.setBounds(50, 450, 150, 30);
        department.setFont(new Font("Arial", Font.BOLD, 20));
        add(department);
        deptComboBox = new JComboBox<>();
        deptComboBox.setBounds(200, 450, 150, 30);
        deptComboBox.setBackground(Color.WHITE);
        add(deptComboBox);

        // Designation
        JLabel designation = new JLabel("Designation");
        designation.setBounds(400, 450, 150, 30);
        designation.setFont(new Font("Arial", Font.BOLD, 20));
        add(designation);
        desigComboBox = new JComboBox<>();
        desigComboBox.setBounds(600, 450, 150, 30);
        desigComboBox.setBackground(Color.WHITE);
        add(desigComboBox);

        // Fetch Department and Designation from Database
        fetchDepartmentAndDesignationData();

        // Buttons
        addbutton = new JButton("Add");
        addbutton.setBounds(450, 550, 150, 40);
        addbutton.setBackground(Color.black);
        addbutton.setForeground(Color.WHITE);
        add(addbutton);
        addbutton.addActionListener(this);

        back = new JButton("Back");
        back.setBounds(250, 550, 150, 40);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        add(back);
        back.addActionListener(this);

        // Frame settings
        setSize(900, 700);
        setLocation(300, 50);
        setLayout(null);
        setVisible(true);
    }

    private void fetchDepartmentAndDesignationData() {
        try {
            Conn c = new Conn();
            // Fetch Department Data
            ResultSet deptRS = c.statement.executeQuery("SELECT Dept_ID, Dept_Name FROM Department");
            while (deptRS.next()) {
                deptComboBox.addItem(deptRS.getString("Dept_Name"));
            }
            // Fetch Designation Data
            ResultSet desigRS = c.statement.executeQuery("SELECT Desig_ID, Desig_Title FROM Designation");
            while (desigRS.next()) {
                desigComboBox.addItem(desigRS.getString("Desig_Title"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addbutton) {
            String name = tname.getText();
            String fname = tfname.getText();
            String dob = ((JTextField) tdob.getDateEditor().getUiComponent()).getText();
            String salary = tsalary.getText();
            String address = taddress.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String education = (String) edu.getSelectedItem();
            String adhar = tadhar.getText();
            String department = (String) deptComboBox.getSelectedItem();
            String designation = (String) desigComboBox.getSelectedItem();
            String empid = tempid.getText();
            String gender = male.isSelected() ? "Male" : "Female";

            // Fetch Department and Designation IDs
            String deptID = getDepartmentID(department);
            String desigID = getDesignationID(designation);

            try {
                Conn c = new Conn();
                // Adding Employee Data to DB
                String query = "INSERT INTO Emp (Name, F_name, DOB, Salary, Address, Phone, Email, Education, Adhar_No, Dept_ID, Desig_ID, Gender, empid) " +
                        "VALUES ('" + name + "', '" + fname + "', '" + dob + "', '" + salary + "', '" + address + "', '" + phone + "', '" + email + "', '" +
                        education + "', '" + adhar + "', '" + deptID + "', '" + desigID + "', '" + gender + "', '" + empid + "')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Added Successfully");
                setVisible(false);
                new Home();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == back) {
            setVisible(false);
            new Home();
        }
    }

    private String getDepartmentID(String departmentName) {
        try {
            Conn c = new Conn();
            ResultSet rs = c.statement.executeQuery("SELECT Dept_ID FROM Department WHERE Dept_Name = '" + departmentName + "'");
            if (rs.next()) {
                return rs.getString("Dept_ID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

    private String getDesignationID(String designationName) {
        try {
            Conn c = new Conn();
            ResultSet rs = c.statement.executeQuery("SELECT Desig_ID FROM Designation WHERE Desig_Title = '" + designationName + "'");
            if (rs.next()) {
                return rs.getString("Desig_ID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String args[]) {
        new AddEmployee();
    }
}
