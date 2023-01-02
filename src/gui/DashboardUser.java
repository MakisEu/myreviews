package gui;

import api.Hotel;
import api.User;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DashboardUser extends JPanel implements  ActionListener{

    User service;

    JList jList;
    JTextArea jTextArea;
    JButton refresh;
    public void updateList(){
        jList.setModel(new AbstractListModel() {
            String[] strings = service.allRatings();

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

    public DashboardUser newGui(User s) {
        service=s;
        jList = new JList();
        jTextArea = new JTextArea();
        refresh=new JButton("Refresh list");

        //System.out.println(service.allRatings().length);

        updateList();
        jTextArea.setColumns(20);
        jTextArea.setRows(5);
        this.add(refresh);
        this.add(jList);
        this.add(jTextArea);
        refresh.addActionListener(this);
        this.setVisible(true);
        return this;
    }

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {
        //set text on right here
        String s = (String) jList.getSelectedValue();
        if (s!=null){
            String[] p=s.split(",");
            if (p[1].equals("Apartment")) {
                jTextArea.setText(service.getApartment(p[2],p[0]).show());}
            if (p[1].equals("Hotel")){
                jTextArea.setText(service.getHotel(p[2],p[0]).show());}
            if (p[1].equals("Maisonette")){
                jTextArea.setText(service.getMaisonette(p[2],p[0]).show());}}
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Refresh list")){
            this.updateList();
        }

    }
}
