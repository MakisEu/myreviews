package gui;

import api.User;

import javax.swing.*;
import javax.swing.JFrame;
public class UserGUI extends JFrame {
    User service;
    JTabbedPane tabs;
    JTextField nameField,locationField,typeField,propertiesField;
    JButton searchButton;
    JFrame frame;
    JList list;
    public UserGUI startGUI(String name,String username){
        service=new api.User(name,username);
        frame=new JFrame();
        frame.setTitle("Operations for users");
        frame.setSize(1600, 700);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(true);
        tabs=new JTabbedPane();
        tabs.add("Dashboard",new DashboardUser().startGUI(service,frame));
        tabs.add("Search",new AccommodationManagerUserGui().newGui(service));
        frame.setVisible(true);
        frame.add(tabs);

        return this;
    }

    public static void main(String[] args) {
        new UserGUI().startGUI("someGuy2","SG2");
    }




}
