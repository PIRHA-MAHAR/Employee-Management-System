package Employee.Management.System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//Class Home

public class Home extends JFrame{

    JButton add,view;


  public   Home(){
//Backgroun image
        ImageIcon im1=new ImageIcon(ClassLoader.getSystemResource("ICONS/h.jpeg"));
        Image im2=im1.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon im3=new ImageIcon(im2);
        JLabel im4=new JLabel(im3);
        im4.setBounds(0,0,1120,630);
        add(im4);

//Heading
        JLabel head=new JLabel("Employee Management System");
        head.setBounds(340,155,400,40);
        head.setFont(new Font("Raleway",Font.BOLD,25));
        im4.add(head);
//Buttons
        JButton add=new JButton("Add Employee ");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(335,270,150,40);
        add.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){

                new AddEmployee();
                setVisible(false);
            }}
        );
        im4.add(add);

        JButton view=new JButton("View Employee ");
        view.setForeground(Color.WHITE);
        view.setBackground(Color.black);
        view.setBounds(565,270,150,60);
        view.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){
                      new ViewEmployee();
                      setVisible(false);
            }}
        );

        im4.add(view);






        setSize(1120,630);
        setLocation(350,100);
        setLayout(null);
        setVisible(true);

    }
    public static void main(String args[]){

        new Home();
    }

}
