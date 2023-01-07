package gui;

import api.Hotel;
import api.Provider;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class DashboardProvider extends Dashboard{
    Provider service;

    public DashboardProvider startGUI(Provider p, JFrame j){
        service=p;
        this.GUI(j);
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
}

