package Employee.Management.System;

import javax.swing.*;
import java.awt.*;

public class Project extends JFrame{

    //Constructor
    Project(){
        ImageIcon il=new ImageIcon(ClassLoader.getSystemResource("ICONS/front.gif"));

        Image i2=il.getImage().getScaledInstance(1170,650,Image.SCALE_DEFAULT);

        ImageIcon i3=new ImageIcon(i2);
        JLabel  image=new JLabel(i3);
        image.setBounds(0,0,1170,650);
        add(image);


        setSize(1170,650);
        setLocation(150,50);
        setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


//Exception Handling
        try{
            Thread.sleep(5000);
            setVisible(false);
            new Role();

        }
        catch (Exception e){
            e.printStackTrace();
        }


    }
    public static void main(String args[]){

        new Project();
    }

}


