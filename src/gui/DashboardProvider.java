package gui;

import api.Hotel;
import api.Provider;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DashboardProvider extends JPanel implements  ActionListener{

    Provider service;

    JList jList;
    JTextArea jTextArea;
    JLabel ratings;
    JFrame frame;
    JButton refresh,Logout;
    public void updateList(){

        ratings.setText("Number of ratings: "+service.getAllRatingsNumber()+"| Average rating: "+service.getAllAccommodationsGrades());
        jList.setModel(new AbstractListModel() {

            String[] strings = service.getNames();
            @Override
            public int getSize() {
                return strings.length;
            }

            @Override
            public Object getElementAt(int i) {
                return strings[i];
            }
        });
        jList.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jTextArea.setText("");
    }
    public void Logout(){
        new StartScreenGUI().g();
        frame.dispose();
    }
    public DashboardProvider startGUI(Provider p,JFrame j) {
        frame=j;
        service=p;
        jList = new JList();
        jTextArea = new JTextArea();
        refresh=new JButton("Refresh list");
        Logout=new JButton("Log out");
        ratings=new JLabel();

        updateList();
        jTextArea.setColumns(20);
        jTextArea.setRows(5);
        this.add(refresh);
        this.add(ratings);
        this.add(jList);
        this.add(jTextArea);
        this.add(Logout, BorderLayout.PAGE_END);
        refresh.addActionListener(this);
        Logout.addActionListener(this);
        this.setVisible(true);
        return this;
    }

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {
        //set text on right here
        String s = (String) jList.getSelectedValue();
        if (s!=null){
        String[] p=s.split("#");
        if (p[1].equals("Apartment")) {
            jTextArea.setText(service.getApartment(p[0]).show());}
        if (p[1].equals("Hotel")){
            Hotel ac=service.getHotel(p[0]);
            jTextArea.setText(ac.show());}
        if (p[1].equals("Maisonette")){
            jTextArea.setText(service.getMaisonette(p[0]).show());}}
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
