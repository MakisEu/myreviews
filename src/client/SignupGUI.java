package client;

import api.AllRegistered;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SignupGUI extends JPanel implements ActionListener {
    JTextField username,password,name,surname;
    JLabel pass,uname,nme,sname,type;
    JRadioButton usr,prv;
    JPanel p;
    JButton sign_up;
    Client client;

    public SignupGUI(Client client) {
        super();
        this.client=client;
    }

    public SignupGUI startGui(){
        this.setSize(600,600);
        this.setLayout(new FlowLayout());
        sign_up=new JButton("Sign up");
        name=new JTextField();
        surname=new JTextField();
        username=new JTextField();
        password=new JTextField();
        nme=new JLabel("Name:");
        sname=new JLabel("Surname:");
        pass=new JLabel("Password:");
        uname=new JLabel("Username:");
        usr=new JRadioButton("User");
        usr.setSelected(true);
        prv=new JRadioButton("Provider");
        type=new JLabel("Type:");
        ButtonGroup group=new ButtonGroup();
        group.add(usr);
        group.add(prv);
        p=new JPanel(new GridLayout(15,1));
        p.add(nme);
        p.add(name);
        p.add(sname);
        p.add(surname);
        p.add(uname);
        p.add(username);
        p.add(pass);
        p.add(password);
        p.add(type);
        p.add(usr);
        p.add(prv);
        p.add(sign_up);
        this.add(p,BorderLayout.CENTER);

        sign_up.addActionListener(this);
        this.setVisible(true);
        return this;
    }
    public static void main(String[] args) {

        new SignupGUI(new Client("127.0.0.1", 5000)).startGui();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Sign up")){
            String Name=this.name.getText();
            String Surname=surname.getText();
            String Username=username.getText();
            String Password=password.getText();
            String Type = null;
            if (usr.isSelected()){
                Type="User";
            }
            else if (prv.isSelected()){
                Type="Provider";
            }
            if (Name.length()<1 || Surname.length()<1 || Username.length()<1 || Password.length()<1){
                JOptionPane.showMessageDialog(this, "Please fill all fields.", "Not all fields are filled.", JOptionPane.ERROR_MESSAGE);
            }
            else {
                String message= null;
                try {
                    message = client.signup(Username,Password,Name,Surname,Type);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                if (message != "This username is already used! Pick another one"){
                    JOptionPane.showMessageDialog(this, "A new account has been created.", "Registration has been added successfully!", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(this, "This Username is already in use. Please try another one", "This Username is already in use", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }
}
