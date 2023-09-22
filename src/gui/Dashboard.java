package gui;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JPanel implements ActionListener {
    JList jList;
    JTextArea jTextArea;
    JFrame frame;
    JLabel ratings;
    JButton refresh,Logout;

    public void updateList(){
    }
    public void Logout(){
        new StartScreenGUI().g();
        frame.dispose();
    }
    public void GUI(JFrame j){
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
    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Refresh list")){
            this.updateList();
        }
        if (e.getActionCommand().equals("Log out")){
            Logout();
        }
    }
}
