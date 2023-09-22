package gui;

import api.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JPanel implements ActionListener {
    JTextField username,password;
    JFrame frame;
    JLabel pass,uname;
    JPanel p;
    JButton login;//sign_up;

    public LoginGUI startGui(JFrame f){
        frame=f;
        this.setSize(600,600);
        this.setLayout(new FlowLayout());
        login=new JButton("Log in");
        //sign_up=new JButton("Sign up");
        username=new JTextField();
        password=new JTextField();
        pass=new JLabel("Password:");
        uname=new JLabel("Username:");
        p=new JPanel(new GridLayout(3,1));
        p.add(uname);
        p.add(username);
        p.add(pass);
        p.add(password);
        p.add(login);
        //p.add(sign_up);
        this.add(p,BorderLayout.CENTER);
        login.addActionListener(this);
        this.setVisible(true);
        return this;
    }
    public static void main(String[] args) {

        new LoginGUI().startGui(new JFrame());
    }
    public void login(String usrname,String pssword){
        String x=new Login().log_in(usrname,pssword);
        if (x==null){
            JOptionPane.showMessageDialog(this, "The username and password do not match a registration", "User/Provider not found", JOptionPane.ERROR_MESSAGE);
        }
        else{
        String type=x.split("#")[0];
        String name=x.split("#")[1];
        if (type.equals("Provider")){
            //this.setVisible(false);
            new ProviderGUI().g(usrname,name);
            frame.dispose();

        }
        else{
            //this.setVisible(false);
            new UserGUI().startGUI(usrname,name);
            frame.dispose();
        }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String Username=username.getText();
        String Password=password.getText();
        if (e.getActionCommand().equals("Log in")){
            if (Username.length()<1 || Password.length()<1){
                JOptionPane.showMessageDialog(this, "Please fill all fields", "Not all fields are filled", JOptionPane.ERROR_MESSAGE);}
            else {
                this.login(Username,Password);
            }
        }
    }
}
