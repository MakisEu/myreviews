package gui;

import api.User;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class DashboardUser extends Dashboard{
    User service;
    public DashboardUser startGUI(User u, JFrame j){
        service=u;
        GUI(j);
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
    public void updateList(){
        ratings.setText("Average rating: "+service.getMean());
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
}
