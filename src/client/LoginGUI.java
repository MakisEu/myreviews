package client;

import api.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LoginGUI extends JPanel implements ActionListener {
    JTextField username,password;
    JFrame frame;
    JLabel pass,uname;
    JPanel p;
    JButton login;//sign_up;
    Client client;
    public LoginGUI(Client client) {
        super();
        this.client=client;
    }

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

        new LoginGUI(new Client("127.0.0.1", 5000)).startGui(new JFrame());
    }
    public void login(String usrname,String pssword) throws IOException, ClassNotFoundException {
        String x=this.client.login(usrname,pssword);;
        if (x.equals("Wrong credentials!")){
            JOptionPane.showMessageDialog(this, "The username and password do not match a registration", "User/Provider not found", JOptionPane.ERROR_MESSAGE);
        }
        else{
        String type=x.split("#")[0];
        String name=x.split("#")[1];
        if (type.equals("Provider")){
            //this.setVisible(false);
            new ProviderGUI(client).g(usrname,name);
            frame.dispose();

        }
        else{
            //this.setVisible(false);
            new UserGUI(client).startGUI(usrname,name);
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
                try {
                    this.login(Username,Password);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }
}
