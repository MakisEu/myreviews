/*package gui;

import api.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class AccommodationManagerGui extends JPanel implements ActionListener {

    JTextField textField_UID, textField_Change, textField_Edit,textField_Prop;
    JRadioButton radio_button_Edit, radio_button_Add, radio_button_Delete;
    JButton button_change, button_show, button_Edit;
    JLabel instructions1;
    JTabbedPane dashboard;

    public AccommodationManagerGui startGUI(Provider s) {

        this.setSize(1600, 300);

        this.setLayout(new FlowLayout());

        // buttons
        button_show = new JButton("Show");
        button_Edit = new JButton("Do Selected");
        //button_showOwned=new JButton("Show Owned");
        button_change = new JButton("Change");
        dashboard=new JTabbedPane();

        // text fields and panels
        textField_UID = new JTextField(20);
        textField_Edit = new JTextField(10);
        textField_Change = new JTextField(10);
        textField_Prop = new JTextField(10);
        instructions1=new JLabel("Instructions on how to use: The \"Show Owned\" button shows all owned accommodations and their information.\n");
        // radio buttons
        radio_button_Edit = new JRadioButton("Edit");
        radio_button_Edit.setSelected(true);
        radio_button_Delete = new JRadioButton("Delete");
        radio_button_Add = new JRadioButton("Add");
        ButtonGroup group = new ButtonGroup();
        group.add(radio_button_Edit);
        group.add(radio_button_Add);
        group.add(radio_button_Delete);

        // add to the panel
        //this.add(button_showOwned);
        this.add(textField_UID);
        this.add(button_show);
        this.add(textField_Edit);
        this.add(textField_Prop);
        this.add(radio_button_Edit);
        this.add(radio_button_Add);
        this.add(radio_button_Delete);
        this.add(button_Edit);
        this.add(textField_Change);
        this.add(button_change);
        this.add(instructions1);
        this.add(dashboard);

        // add action listeners
        //button_showOwned.addActionListener(this);
        button_show.addActionListener(this);
        button_Edit.addActionListener(this);
        button_change.addActionListener(this);
        return this;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String x = textField_UID.getText(), t = null,title=null;
        String[] temp = x.split("#");
        Accommodation acc = null;
        String[] temp2 = textField_Change.getText().split(",",-1);
        String[] temp3 = textField_Edit.getText().split(",",-1);
        String[] prop = textField_Prop.getText().split(",");
        if (temp3.length<1){
            temp3=new String[5];
            for (int i=0;i<5;i++){temp3[i]="";}
        }
        switch (temp[0]) {
            case "a":
                t = "a";
                title = "Apartment";
                Apartment a = service.getApartment(temp[2]);
                if (a != null) {
                    button_change.setText("Change(floor,space,guard,elevator)(use ,, if you want to skip a value)");
                    if (e.getActionCommand().equals("Change(floor,space,guard,elevator)(use ,, if you want to skip a value)")) {
                        service.setApartment(temp2[0], temp2[1], temp2[2], temp2[3], a);
                    }
                    acc = a;
                } else {
                    JOptionPane.showMessageDialog(this, "ACCOMMODATION NOT FOUND. PLEASE CHECK THAT THE UID IS CORRECT", "ERROR!!!", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "h":
                t = "h";
                title = "Hotel";
                Hotel h = service.getHotel(temp[2]);
                if (h != null) {
                    button_change.setText("Change(stars,floor,suite)(use ,, if you want to skip a value)");
                    if (e.getActionCommand().equals("Change(stars,floor,suite)(use ,, if you want to skip a value)")) {
                        service.setHotel(temp2[0], temp2[1], temp2[2], h);
                    }
                    acc = h;
                } else {
                    JOptionPane.showMessageDialog(this, "ACCOMMODATION NOT FOUND. PLEASE CHECK THAT THE UID IS CORRECT", "ERROR!!!", JOptionPane.ERROR_MESSAGE);
                }

                break;
            case "m":
                t = "m";
                title = "Maisonette";
                Maisonette m = service.getMaisonette(temp[2]);
                if (m != null) {
                    button_change.setText("Change(Roommates)");
                    if (e.getActionCommand().equals("Change(stars,floor,suite)(use ,, if you want to skip a value)")) {
                        service.setMaisonette(temp2[0], m);
                    }
                    acc = m;
                } else {
                    JOptionPane.showMessageDialog(this, "ACCOMMODATION NOT FOUND. PLEASE CHECK THAT THE UID IS CORRECT", "ERROR!!!", JOptionPane.ERROR_MESSAGE);
                }
                break;
        }
        if (acc != null) {
            if (e.getActionCommand().equals("Do Selected")) {
                if (radio_button_Edit.isSelected()) {
                    service.editAccommodation(t, temp3[0], temp3[1], temp3[2], temp3[3], temp3[4], acc.getName(), prop);
                    JOptionPane.showMessageDialog(this, "Accommodation was edited successfully", "Edited Successfully", JOptionPane.INFORMATION_MESSAGE);

                }
                if (radio_button_Delete.isSelected()){
                    service.deleteAccommodation(temp3[0]);
                    JOptionPane.showMessageDialog(this, "Accommodation was deleted successfully", "Deleted Successfully", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            if (!(e.getActionCommand().equals("Do Selected") && radio_button_Delete.isSelected()) && !e.getActionCommand().equals("Show Owned")) {
                JOptionPane.showMessageDialog(this, acc.show(), title, JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if (e.getActionCommand().equals("Do Selected") && radio_button_Add.isSelected()){
            boolean q=service.addAccommodation(temp3[0], temp3[1], temp3[2], temp3[3], temp3[4], temp3[5]);
            Accommodation ac;
            if (q){
                switch (temp3[0]) {
                    case "a":
                        ac = service.getApartment(temp3[1]);
                        new Helper().updateProperties(ac, prop);
                        JOptionPane.showMessageDialog(this, ac.show(), "Accommodation added successfully", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case "h":
                        ac = service.getHotel(temp3[1]);
                        new Helper().updateProperties(ac, prop);
                        JOptionPane.showMessageDialog(this, ac.show(), "Accommodation added successfully", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case "m":
                        ac = service.getMaisonette(temp3[1]);
                        new Helper().updateProperties(ac, prop);
                        JOptionPane.showMessageDialog(this, ac.show(), "Accommodation added successfully", JOptionPane.INFORMATION_MESSAGE);
                        break;
                }
            }
            else {
                JOptionPane.showMessageDialog(this, "Invalid Accommodation Type.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        }
        if (e.getActionCommand().equals("Show Owned")){
            JOptionPane.showMessageDialog(this, service.showOwned(), "Owned Accommodations", JOptionPane.INFORMATION_MESSAGE);

        }

        try {
            service.destructor();
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void main(String[] args) {
        Provider p=new Provider("someGuy","SG");
        new AccommodationManagerProviderGui().startGUI(p);
    }
}*/