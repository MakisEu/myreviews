package client;

import api.Pair;
import api.Provider;

import javax.swing.*;
import java.io.IOException;

public class ProviderGUI extends JFrame{
    JTabbedPane tabs;
    Client client;

    public ProviderGUI(Client client) {
        super();
        this.client=client;
    }

    public void g(String username,String first_name) throws IOException, ClassNotFoundException {
        Pair<String,String> provider_creds=new Pair<>(username,first_name);
        //JPanel p=new JPanel();
        this.setTitle("Accommodation Management");
        this.setSize(1600, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        tabs=new JTabbedPane();

        tabs.add("Dashboard",new DashboardProvider(client,provider_creds).startGUI(this));
        //tabs.add("Accommodation Manager",new AccommodationManagerProviderGui().startGUI(service));
        tabs.add("Accommodation Manager",new AMPGUIEdit_Add(client,provider_creds).startGUI());
        this.add(tabs);
        this.setVisible(true);
    }
     public static void main(String[] args) throws IOException, ClassNotFoundException {
        new ProviderGUI(new Client("127.0.0.1", 5000)).g("someGuy","SG");
    }
}
