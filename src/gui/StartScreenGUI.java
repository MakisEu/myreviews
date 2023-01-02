package gui;

import api.Provider;
import api.User;

import javax.swing.*;

public class StartScreenGUI extends JFrame{
    JTabbedPane tabs;
    Provider serviceP;
    User serviceU;

    public void g(String username,String first_name){
        //JPanel p=new JPanel();
        this.setTitle("My Reviews");
        this.setSize(250, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        tabs=new JTabbedPane();
        tabs.add("Log in",new LoginGUI().startGui());
        //tabs.add("Accommodation Manager",new AccommodationManagerProviderGui().startGUI(service));
        tabs.add("Sign up",new SignupGUI().startGui());
        this.add(tabs);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new StartScreenGUI().g("someGuy","SG");
    }
}

