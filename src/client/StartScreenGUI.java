package client;

import api.Provider;
import api.User;

import javax.swing.*;

public class StartScreenGUI extends JFrame{
    JTabbedPane tabs;
    Client client;

    public StartScreenGUI(Client client) {
        super();
        this.client=client;
    }

    public void g(){
        //JPanel p=new JPanel();
        this.setTitle("My Reviews");
        this.setSize(250, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        tabs=new JTabbedPane();
        tabs.add("Log in",new LoginGUI(client).startGui(this));
        //tabs.add("Accommodation Manager",new AccommodationManagerProviderGui().startGUI(service));
        tabs.add("Sign up",new SignupGUI(client).startGui());
        this.add(tabs);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new StartScreenGUI(new Client("127.0.0.1", 5000)).g();
    }
}

