package gui;

import api.User;

import javax.swing.*;
import javax.swing.JFrame;
public class UserGUI extends JPanel {
    JTabbedPane tabs;
    JTextField nameField,locationField,typeField,propertiesField;
    JButton searchButton;
    JFrame frame;
    JList list;
    public UserGUI startGUI(){
        frame=new JFrame();
        frame.setTitle("Operations for users");
        frame.setSize(600,400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(true);
        tabs=new JTabbedPane();
        //tabs.add("Dashboard",new AccommodationManagerUserGui());
        frame.setVisible(true);


        return this;
    }

    public static void main(String[] args) {
        new UserGUI().startGUI();

    }




}
