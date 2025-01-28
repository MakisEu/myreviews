package client;

import api.Pair;
import api.User;

import javax.swing.*;
import java.io.IOException;
import java.lang.reflect.Parameter;

public class UserGUI extends JFrame {
    User service;
    JTabbedPane tabs;
    JTextField nameField,locationField,typeField,propertiesField;
    JButton searchButton;
    JFrame frame;
    JList list;
    Client client;

    public UserGUI(Client client) {
        super();
        this.client=client;
    }

    public UserGUI startGUI(String name,String username) throws IOException, ClassNotFoundException {
        Pair<String,String> userCreds=new Pair<>(name,username);

        frame=new JFrame();
        frame.setTitle("Operations for users");
        frame.setSize(1600, 700);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(true);
        tabs=new JTabbedPane();
        tabs.add("Dashboard",new DashboardUser(client,userCreds).startGUI(frame));
        tabs.add("Search",new AccommodationManagerUserGui(client,userCreds).newGui());
        frame.setVisible(true);
        frame.add(tabs);

        return this;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new UserGUI(new Client("127.0.0.1", 5000)).startGUI("someGuy2","SG2");
    }




}
