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
    JRadioButton radio_button_Edit, radio_button_Add, radio_button_Delete;
    JButton button_change, button_show, button_Edit,button_showOwned;
    JLabel instructions1,instructions2,instructions3,instructions4,instructions5,instructions6,instructions7,instructions8,instructions9,instructions10,instructions11,instructions12,instructions13;
    JTabbedPane dashboard;
    Provider service;

    public void startGUI(String o,String fn) {
        service = new Provider(o,fn);

        this.setTitle("Accommodation Management");
        this.setSize(1600, 300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.setLayout(new FlowLayout());

        // buttons
        button_show = new JButton("Show");
        button_Edit = new JButton("Do Selected");
        button_showOwned=new JButton("Show Owned");
        button_change = new JButton("Change");
        dashboard=new JTabbedPane();

        // text fields and panels
        textField_UID = new JTextField(20);
        textField_Edit = new JTextField(10);
        textField_Change = new JTextField(10);
        textField_Prop = new JTextField(10);
        instructions1=new JLabel("Instructions on how to use: The \"Show Owned\" button shows all owned accommodations and their information.\n");
        instructions2=new JLabel("The button \"Show\" shows the information of an accommodation with a specific UID(Unique ID).\n");
        instructions3=new JLabel("The first field takes a UID(Unique ID) of an accommodation and is required by the \"Show\" and \"Change\" buttons and the actions \"Edit\" and \"Delete\".\n");
        instructions4=new JLabel("The second field takes different parameters based on the action selected. For action \"Edit\",\n");
        instructions5=new JLabel("it takes new parameters to replace the accommodation with a specified UID in the form Name_of_accommodation,address,postal_code,city,description (to skip a field, leave 2 commas(,,))");
        instructions6=new JLabel("For the action \"Add\", it takes parameters in the form type(a,h or m),name_of_the_accommodation,address,postal_code,city,description and creates a new accommodation.");
        instructions7=new JLabel("For the action\"Delete, it takes the name of the accommodation\"");
        instructions8=new JLabel("The third field takes the (optional) properties of an accommodation and is an optional field of actions \"Edit\" and \"Add\" in the form Key1-Value1,Key2-Value2, ...");
        instructions9=new JLabel("The action \"Edit\", edits the fields of an accommodation with a specific UID with the input from the second and third fields.");
        instructions10=new JLabel("The action \"Add\", adds an accommodation with input from the second and third fields. The action \"Delete\", deletes an accommodation with input from the second field.");
        instructions11=new JLabel("The fourth field takes different parameters depending on the type of accommodation of the UID in the first field. It takes the extra fields(fields added by us) of an accommodation.");
        instructions12=new JLabel("For Apartment, it takes input in the form floor,space,guard,elevator. For Hotel, it takes input in the form stars,floor,suite. For Maisonette, it takes input roommates");
        instructions13=new JLabel("The button \"Change\" changes text depending on last \"Show\" click. It changes the extra fields and takes input from the first and the fourth fields.");

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
        this.add(button_showOwned);
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
        this.add(instructions2);
        this.add(instructions3);
        this.add(instructions4);
        this.add(instructions5);
        this.add(instructions6);
        this.add(instructions7);
        this.add(instructions8);
        this.add(instructions9);
        this.add(instructions10);
        this.add(instructions11);
        this.add(instructions12);
        this.add(instructions13);
        this.add(dashboard);

        // add action listeners
        button_showOwned.addActionListener(this);
        button_show.addActionListener(this);
        button_Edit.addActionListener(this);
        button_change.addActionListener(this);

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
        if (temp[0].equals("a")) {
            t = "a";
            title="Apartment";
            Apartment a = service.getApartment(temp[2]);
            if (a != null) {
                button_change.setText("Change(floor,space,guard,elevator)(use ,, if you want to skip a value)");
                if (e.getActionCommand().equals("Change(floor,space,guard,elevator)(use ,, if you want to skip a value)")) {
                    service.setApartment(temp2[0], temp2[1], temp2[2], temp2[3], a);
                }
                acc = a;
            }
            else{
                JOptionPane.showMessageDialog(this, "ACCOMMODATION NOT FOUND. PLEASE CHECK THAT THE UID IS CORRECT", "ERROR!!!", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if (temp[0].equals("h")) {
            t = "h";
            title="Hotel";
            Hotel h = service.getHotel(temp[2]);
            if (h != null) {
                button_change.setText("Change(stars,floor,suite)(use ,, if you want to skip a value)");
                if (e.getActionCommand().equals("Change(stars,floor,suite)(use ,, if you want to skip a value)")) {
                    service.setHotel(temp2[0], temp2[1], temp2[2], h);
                }
                acc = h;
            }
            else{
                JOptionPane.showMessageDialog(this, "ACCOMMODATION NOT FOUND. PLEASE CHECK THAT THE UID IS CORRECT", "ERROR!!!", JOptionPane.ERROR_MESSAGE);
            }
            //this.setVisible(true);
            //JOptionPane.showMessageDialog(this, service.getHotel(temp[1], temp[2]).show(), "Hotel", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (temp[0].equals("m")) {
            t = "m";
            title="Maisonette";
            Maisonette m = service.getMaisonette(temp[2]);
            if (m != null) {
                button_change.setText("Change(Roommates)");
                if (e.getActionCommand().equals("Change(stars,floor,suite)(use ,, if you want to skip a value)")) {
                    service.setMaisonette(temp2[0], m);
                }
                acc = m;
            }
            else{
                JOptionPane.showMessageDialog(this, "ACCOMMODATION NOT FOUND. PLEASE CHECK THAT THE UID IS CORRECT", "ERROR!!!", JOptionPane.ERROR_MESSAGE);
            }
        }
            if (acc != null) {
                if (e.getActionCommand().equals("Do Selected")) {
                    if (radio_button_Edit.isSelected()) {
                        service.editAccommodation(t, temp3[0], temp3[1], temp3[2], temp3[3], temp3[4], acc.getName(), prop);
                    }
                    if (radio_button_Delete.isSelected()){
                        service.deleteAccommodation(temp3[0]);
                    }
                }
                    if (!(e.getActionCommand().equals("Do Selected") && radio_button_Delete.isSelected()) && !e.getActionCommand().equals("Show Owned")) {
                        JOptionPane.showMessageDialog(this, acc.show(), title, JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            if (e.getActionCommand().equals("Do Selected") && radio_button_Add.isSelected()){
                service.addAccommodation(temp3[0], temp3[1], temp3[2], temp3[3], temp3[4], temp3[5]);
                Accommodation ac = null;
                if (temp3[0].equals("a")){ac=service.getApartment(temp3[1]);service.updateProperties(ac,prop);JOptionPane.showMessageDialog(this, service.showOwned(), "Accommodation added successfully", JOptionPane.INFORMATION_MESSAGE);}
                else if (temp3[0].equals("h")){ac=service.getHotel(temp3[1]);service.updateProperties(ac,prop);JOptionPane.showMessageDialog(this, service.showOwned(), "Accommodation added successfully", JOptionPane.INFORMATION_MESSAGE);}
                else if (temp3[0].equals("m")){ac=service.getMaisonette(temp3[1]);service.updateProperties(ac,prop);JOptionPane.showMessageDialog(this, service.showOwned(), "Accommodation added successfully", JOptionPane.INFORMATION_MESSAGE);}


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

    public static void main(String[] args) throws FileNotFoundException {
        AccommodationManagerProvider AM=new AccommodationManagerProvider();
        //AM.addAccommodation("Ξενοδοχείο", "three-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy");
        //AM.destructor();
        new ProviderGui().startGUI("someGuy","SG");
    }
}
