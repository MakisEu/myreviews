package gui;

import api.Provider;

import javax.swing.*;

public class GuiFake extends JFrame{
    JTabbedPane tabs;
    Provider service;

    public void g(String username,String first_name){
        service=new Provider(username,first_name);
        //JPanel p=new JPanel();
        this.setTitle("Accommodation Management");
        this.setSize(1600, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        tabs=new JTabbedPane();

        tabs.add("Dashboard",new DashboardProvider().startGUI(service));
        tabs.add("Accommodation Manager",new AccommodationManagerProviderGui().startGUI(service));
        this.add(tabs);
        this.setVisible(true);
    }
     public static void main(String[] args) {
        new GuiFake().g("someGuy","SG");

    }
}
