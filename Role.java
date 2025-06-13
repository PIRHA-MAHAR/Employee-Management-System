package Employee.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Role extends JFrame implements ActionListener {
    JButton adminButton, userButton;

    // Constructor for setting up the Role window
    public Role() {
        // Set the title and window size
        setTitle("Select Role");
        setSize(800, 400); // Adjust size as per your requirement
        setLocation(200, 100); // Set window position
        setLayout(null); // Use null layout for custom positioning

        // Set background color of the window
        getContentPane().setBackground(new Color(135, 206, 235)); // Light Blue background

        // Admin button setup
        adminButton = new JButton("Admin Login");
        adminButton.setBounds(250, 150, 150, 30);
        adminButton.setBackground(Color.BLACK);
        adminButton.setForeground(Color.WHITE);
        adminButton.addActionListener(this);
        add(adminButton);

        // User button setup
        userButton = new JButton("User Login");
        userButton.setBounds(450, 150, 150, 30);
        userButton.setBackground(Color.BLACK);
        userButton.setForeground(Color.WHITE);
        userButton.addActionListener(this);
        add(userButton);

        // Set window properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true); // Make sure the window is visible
    }

    // Action event for buttons
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == adminButton) {
                // Open Admin Login when Admin button is clicked
                setVisible(false);
                new Login(); // Open the login screen for Admin
            } else if (e.getSource() == userButton) {
                // Open Employee Dashboard when User button is clicked
                //setVisible(false);

                new Login1(); // Open Employee Dashboard (pass employee ID if needed)
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Role(); // Create and display the Role window
    }
}