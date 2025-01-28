package client;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Dashboard extends JPanel implements ActionListener {
    JList jList;
    JTextArea jTextArea;
    JFrame frame;
    JLabel ratings;
    JButton refresh,Logout;
    Client client;

    public Dashboard(Client client) {
        super();
        this.client=client;
    }

    public void updateList() throws IOException, ClassNotFoundException {
    }
    public void Logout(){
        new StartScreenGUI(client).g();
        frame.dispose();
    }
    public void GUI(JFrame j) throws IOException, ClassNotFoundException {
        frame=j;
        jList = new JList();
        jTextArea = new JTextArea();
        Logout=new JButton("Log out");
        refresh=new JButton("Refresh list");


        //System.out.println(service.allRatings().length);

        jTextArea.setColumns(20);
        jTextArea.setRows(5);
        this.add(refresh);
        ratings=new JLabel();
        this.add(ratings);
        this.add(jList);
        this.add(jTextArea);
        this.add(Logout);
        Logout.addActionListener(this);
        refresh.addActionListener(this);
        updateList();
        this.setVisible(true);
    }
    private void jList1ValueChanged(ListSelectionEvent evt) {
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Refresh list")){
            try {
                this.updateList();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getActionCommand().equals("Log out")){
            Logout();
        }
    }
}
