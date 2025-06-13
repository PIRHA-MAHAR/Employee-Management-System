package Employee.Management.System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
//class Login
class Login extends JFrame implements ActionListener{
    //Attributes
    JTextField tusername;
    JPasswordField tpassword;
    JButton login,back;
    Login(){
        //Elements
        JLabel username=new JLabel("Username");
        username.setBounds(40,20,100,30);
        add(username);
        tusername=new JTextField();
        tusername.setBounds(150,20,150,30);
        add(tusername);
        JLabel password=new JLabel("Password");
        password.setBounds(40,70,100,30);
        add(password);
        tpassword=new JPasswordField();
        tpassword.setBounds(150,70,150,30);
        add(tpassword );
//Login Button
        login=new JButton("LOGIN");
        login.setBounds(150,140,150,30);
        login.setBackground(Color.black);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
//Back button
        back=new JButton("BACK");
        back.setBounds(150,180,150,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

//For icon on picture
        ImageIcon i11=new ImageIcon(ClassLoader.getSystemResource("ICONS/second.jpg"));
        Image i22=i11.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
        ImageIcon i33=new ImageIcon(i22);
        JLabel imag=new JLabel(i33);
        imag.setBounds(350,10,600,400);
        add(imag);

//Add Image to background
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("ICONS/LoginB.jpg"));
        Image i2=i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(0,0,600,300);
        add(img);
        setSize(600,300 );
        setLocation(450,200);
        setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==login){

            try{

                String username=tusername.getText();
                String password=tpassword.getText();
                Conn conn=new Conn();
                //Employee.Management.System.conn con=new Employee.Management.System.conn();
                String query="select * from login where username ='"+username+"' and password ='"+password+"'";
                ResultSet result=conn.statement.executeQuery(query);
                if(result.next()){
                    setVisible(false);
                    new Home();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid username or password");
                }
            }
            catch(Exception E){
                E.printStackTrace();
            }

        }
        else if(e.getSource()==back){
            new Role();
        }
    }
    public static void main(String args[]){
        new Login();
    }
}