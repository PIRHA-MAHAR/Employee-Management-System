package Employee.Management.System;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener {
    JTextField tname, tfname, taddress, tphone, temail, tsalary;
    JRadioButton male, female;
    ButtonGroup genderGroup;
    JLabel tempidLabel, tdobLabel, tadharLabel;
    JComboBox<String> edu, deptComboBox, desigComboBox;
    JButton updatebutton, back;

    String empId;

    UpdateEmployee(String empId) {
        this.empId = empId;

        getContentPane().setBackground(new Color(204, 229, 255));
        setLayout(null);

        JLabel heading = new JLabel("Update Employee Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);

        // Name
        JLabel name = new JLabel("Name");
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font("Arial", Font.BOLD, 20));
        add(name);
        tname = new JTextField();
        tname.setBounds(200, 150, 150, 30);
        add(tname);

        // Father's Name
        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(400, 150, 150, 30);
        fname.setFont(new Font("Arial", Font.BOLD, 20));
        add(fname);
        tfname = new JTextField();
        tfname.setBounds(600, 150, 150, 30);
        add(tfname);

        // Birth Date Label
        JLabel dob = new JLabel("Birth Date");
        dob.setBounds(50, 200, 150, 30);
        dob.setFont(new Font("Arial", Font.BOLD, 20));
        add(dob);
        tdobLabel = new JLabel();
        tdobLabel.setBounds(200, 200, 150, 30);
        add(tdobLabel);

        // Salary
        JLabel salary = new JLabel("Salary");
        salary.setBounds(400, 200, 150, 30);
        salary.setFont(new Font("Arial", Font.BOLD, 20));
        add(salary);
        tsalary = new JTextField();
        tsalary.setBounds(600, 200, 150, 30);
        add(tsalary);

        // Address
        JLabel address = new JLabel("Address");
        address.setBounds(50, 250, 150, 30);
        address.setFont(new Font("Arial", Font.BOLD, 20));
        add(address);
        taddress = new JTextField();
        taddress.setBounds(200, 250, 150, 30);
        add(taddress);

        // Phone
        JLabel phone = new JLabel("Phone");
        phone.setBounds(400, 250, 150, 30);
        phone.setFont(new Font("Arial", Font.BOLD, 20));
        add(phone);
        tphone = new JTextField();
        tphone.setBounds(600, 250, 150, 30);
        add(tphone);

        // Email
        JLabel email = new JLabel("Email");
        email.setBounds(50, 300, 150, 30);
        email.setFont(new Font("Arial", Font.BOLD, 20));
        add(email);
        temail = new JTextField();
        temail.setBounds(200, 300, 150, 30);
        add(temail);

        // Education
        JLabel education = new JLabel("Higher Education");
        education.setBounds(400, 300, 200, 30);
        education.setFont(new Font("Arial", Font.BOLD, 20));
        add(education);
        String items[] = {"BSSE", "BBA", "B.Tech", "BA", "BSC", "B.Com", "MCA", "MA", "MTech", "MSC", "PHD"};
        edu = new JComboBox<>(items);
        edu.setBounds(600, 300, 150, 30);
        add(edu);

        // Adhar Number Label Title
        JLabel adhar = new JLabel("Adhar Number");
        adhar.setBounds(400, 350, 150, 30);
        adhar.setFont(new Font("Arial", Font.BOLD, 20));
        add(adhar);

        // Adhar Number Value Label
        tadharLabel = new JLabel();
        tadharLabel.setBounds(600, 350, 150, 30);
        add(tadharLabel);

        // Employee ID Label Title
        JLabel empid = new JLabel("Employee ID");
        empid.setBounds(50, 400, 200, 30);
        empid.setFont(new Font("Arial", Font.BOLD, 20));
        add(empid);
        tempidLabel = new JLabel();
        tempidLabel.setBounds(200, 400, 150, 30);
        tempidLabel.setFont(new Font("Arial", Font.BOLD, 20));
        tempidLabel.setForeground(Color.RED);
        add(tempidLabel);

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

        // Department
        JLabel department = new JLabel("Department");
        department.setBounds(50, 450, 150, 30);
        department.setFont(new Font("Arial", Font.BOLD, 20));
        add(department);
        deptComboBox = new JComboBox<>();
        deptComboBox.setBounds(200, 450, 150, 30);
        add(deptComboBox);

        // Designation
        JLabel designation = new JLabel("Designation");
        designation.setBounds(400, 450, 150, 30);
        designation.setFont(new Font("Arial", Font.BOLD, 20));
        add(designation);
        desigComboBox = new JComboBox<>();
        desigComboBox.setBounds(600, 450, 150, 30);
        add(desigComboBox);

        updatebutton = new JButton("Update");
        updatebutton.setBounds(450, 550, 150, 40);
        updatebutton.setBackground(Color.black);
        updatebutton.setForeground(Color.WHITE);
        updatebutton.addActionListener(this);
        add(updatebutton);

        back = new JButton("Back");
        back.setBounds(250, 550, 150, 40);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);

        fetchDepartmentAndDesignationData();
        fetchEmployeeDetails();
    }

    private void fetchDepartmentAndDesignationData() {
        try {
            Conn c = new Conn();
            ResultSet deptRS = c.statement.executeQuery("SELECT Dept_Name FROM Department");
            while (deptRS.next()) {
                deptComboBox.addItem(deptRS.getString("Dept_Name"));
            }

            ResultSet desigRS = c.statement.executeQuery("SELECT Desig_Title FROM Designation");
            while (desigRS.next()) {
                desigComboBox.addItem(desigRS.getString("Desig_Title"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fetchEmployeeDetails() {
        try {
            Conn c = new Conn();
            ResultSet rs = c.statement.executeQuery("SELECT * FROM Emp WHERE empid = '" + empId + "'");
            if (rs.next()) {
                tname.setText(rs.getString("Name"));
                tfname.setText(rs.getString("F_name"));
                tdobLabel.setText(rs.getString("DOB"));
                tsalary.setText(rs.getString("Salary"));
                taddress.setText(rs.getString("Address"));
                tphone.setText(rs.getString("Phone"));
                temail.setText(rs.getString("Email"));
                edu.setSelectedItem(rs.getString("Education"));
                tadharLabel.setText(rs.getString("Adhar_No"));
                tempidLabel.setText(rs.getString("empid"));

                String gender = rs.getString("Gender");
                if (gender.equals("Male")) {
                    male.setSelected(true);
                } else {
                    female.setSelected(true);
                }

                String deptID = rs.getString("Dept_ID");
                String desigID = rs.getString("Desig_ID");

                ResultSet deptNameRS = c.statement.executeQuery("SELECT Dept_Name FROM Department WHERE Dept_ID = '" + deptID + "'");
                if (deptNameRS.next()) {
                    deptComboBox.setSelectedItem(deptNameRS.getString("Dept_Name"));
                }

                ResultSet desigNameRS = c.statement.executeQuery("SELECT Desig_Title FROM Designation WHERE Desig_ID = '" + desigID + "'");
                if (desigNameRS.next()) {
                    desigComboBox.setSelectedItem(desigNameRS.getString("Desig_Title"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == updatebutton) {
            try {
                Conn c = new Conn();
                String query = "UPDATE Emp SET Name='" + tname.getText() + "', F_name='" + tfname.getText() + "', Salary='" + tsalary.getText() +
                        "', Address='" + taddress.getText() + "', Phone='" + tphone.getText() + "', Email='" + temail.getText() +
                        "', Education='" + edu.getSelectedItem() + "', Gender='" + (male.isSelected() ? "Male" : "Female") +
                        "', Dept_ID=(SELECT Dept_ID FROM Department WHERE Dept_Name='" + deptComboBox.getSelectedItem() + "'), " +
                        "Desig_ID=(SELECT Desig_ID FROM Designation WHERE Desig_Title='" + desigComboBox.getSelectedItem() + "') WHERE empid='" + empId + "'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Updated Successfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new UpdateEmployee("1001"); // Example empid
    }
}
