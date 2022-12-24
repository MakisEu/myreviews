package gui;

import api.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class ProviderGui extends JFrame implements ActionListener {

    JTextField textField_UID, textField_Change, textField_Edit,textField_Prop;
    JTextArea textArea_results;
    JRadioButton radio_button_add, radio_button_subtract, radio_button_multiply;
    JButton button_change, button_show, button_Edit;
    boolean button_flag=true;
    Provider service;

    public void startGUI() {
        service = new Provider();

        this.setTitle("Accommodation Management");
        this.setSize(1200, 65);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.setLayout(new FlowLayout());

        // buttons
        button_show = new JButton("Show");
        button_Edit = new JButton("Edit Accommodation");

        // text fields and area
        textField_UID = new JTextField(10);
        textField_Edit = new JTextField(10);
        textField_Change = new JTextField(10);
        textField_Prop = new JTextField(10);

        // radio buttons
        /*radio_button_add = new JRadioButton("ds");
        radio_button_add.setSelected(true);
        radio_button_subtract = new JRadioButton("subtract");
        radio_button_multiply = new JRadioButton("multiply");
        ButtonGroup group = new ButtonGroup();
        group.add(radio_button_add);
        group.add(radio_button_multiply);
        group.add(radio_button_subtract);*/

        // add to the panel
        this.add(textField_UID);
        this.add(button_show);
        this.add(textField_Edit);
        this.add(textField_Prop);
        this.add(button_Edit);
        this.add(textField_Change);
        //this.add(radio_button_add);
        //this.add(radio_button_subtract);
        //this.add(radio_button_multiply);
        //this.add(textArea_results);

        // add action listeners
        button_show.addActionListener(this);
        button_Edit.addActionListener(this);

        /**
         // δημιουργία ανώνυμης κλάσης
         button_calculate.addActionListener(new ActionListener() {
        @Override public void actionPerformed(ActionEvent e) {
        int x = Integer.parseInt(textField_number1.getText());
        int y = Integer.parseInt(textField_number2.getText());
        if (radio_button_add.isSelected()) {
        textArea_results.setText(service.add(x, y) + "");
        } else if (radio_button_subtract.isSelected()) {
        textArea_results.setText(service.subtract(x, y) + "");
        } else if (radio_button_multiply.isSelected()) {
        textArea_results.setText(service.multiply(x, y) + "");
        }
        }
        });
         */

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String x = textField_UID.getText(), t = null;
        String[] temp = x.split("#");
        Accommodation acc = null;
        String[] temp2 = textField_Change.getText().split(",");
        String[] temp3 = textField_Edit.getText().split(",");
        String[] prop = textField_Prop.getText().split(",");
        if (button_flag) {
            button_change = new JButton("Change");
            button_flag = false;
            this.add(button_change);
            button_change.addActionListener(this);
        }
        if (temp[0].equals("a")) {
            t = "a";
            Apartment a = service.getApartment(temp[1], temp[2]);
            if (a != null) {
                button_change.setText("Change(floor,space,guard,elevator)(use ,, if you want to skip a value)");
                if (e.getActionCommand().equals("Change(floor,space,guard,elevator)(use ,, if you want to skip a value)")) {
                    service.setApartment(temp2[0], temp2[1], temp2[2], temp2[3], a);
                }
                acc = a;
            }
        }
        if (temp[0].equals("h")) {
            t = "h";
            Hotel h = service.getHotel(temp[1], temp[2]);
            if (h != null) {
                button_change.setText("Change(stars,floor,suite)(use ,, if you want to skip a value)");
                if (e.getActionCommand().equals("Change(stars,floor,suite)(use ,, if you want to skip a value)")) {
                    service.setHotel(temp2[0], temp2[1], temp2[2], h);
                }
                acc = h;
            }
            this.setVisible(true);
            //JOptionPane.showMessageDialog(this, service.getHotel(temp[1], temp[2]).show(), "Hotel", JOptionPane.INFORMATION_MESSAGE);
        }
        if (temp[0].equals("m")) {
            t = "m";
            Maisonette m = service.getMaisonette(temp[1], temp[2]);
            if (m != null) {
                button_change.setText("Change(Roommates)");
                if (e.getActionCommand().equals("Change(stars,floor,suite)(use ,, if you want to skip a value)")) {
                    service.setMaisonette(temp2[0], m);
                }
                acc = m;
            }
        }
            if (acc != null) {
                if (e.getActionCommand().equals("Edit Accommodation")) {
                    service.editAccommodation(t, temp3[0], temp3[1], temp3[2], temp3[3], temp3[4], acc.getOwner(), acc.getName(), prop);
                }
                JOptionPane.showMessageDialog(this, acc.show(), "Hotel", JOptionPane.INFORMATION_MESSAGE);
            }
            try {
                service.destructor();
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
    }

    public static void main(String[] args) throws FileNotFoundException {
        AccommodationManagerProvider AM=new AccommodationManagerProvider();
        AM.addAccommodation("Ξενοδοχείο", "three-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy");
        AM.destructor();
        new ProviderGui().startGUI();
    }
}
