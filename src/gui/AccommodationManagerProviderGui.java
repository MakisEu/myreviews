package gui;

import api.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class AccommodationManagerProviderGui extends JPanel implements ActionListener {

    JTextField textField_UID, textField_Change, textField_Edit,textField_Prop;
    JRadioButton radio_button_Edit, radio_button_Add, radio_button_Delete;
    JButton button_change, button_show, button_Edit;//,button_showOwned;
    JLabel instructions1,instructions2,instructions3,instructions4,instructions5,instructions6,instructions7,instructions8,instructions9,instructions10,instructions11,instructions12,instructions13;
    Provider service;

    public AccommodationManagerProviderGui startGUI(Provider s) {
        service = s;
        this.setSize(1600, 300);
        this.setLayout(new FlowLayout());

        // buttons
        button_show = new JButton("Show");
        button_Edit = new JButton("Do Selected");
        //button_showOwned=new JButton("Show Owned");
        button_change = new JButton("Change");

        // text fields and panels
        textField_UID = new JTextField(20);
        textField_Edit = new JTextField(10);
        textField_Change = new JTextField(10);
        textField_Prop = new JTextField(10);
        instructions1=new JLabel("Instructions on how to use: \"The button \\\"Show\\\" shows the information of an accommodation with a specific UID(Unique ID).\\n");
        //instructions2=new JLabel(");
        instructions3=new JLabel("The first field takes a UID(Unique ID) of an accommodation and is required by the \"Show\" and \"Change\" buttons and the actions \"Edit\" and \"Delete\".\n");
        instructions4=new JLabel("The second field takes different parameters based on the action selected. For action \"Edit\",\n");
        instructions5=new JLabel("it takes new parameters to replace the accommodation with a specified UID in the form Name_of_accommodation,address,postal_code,city,description (to skip a field, leave 2 commas(,,))\n");
        instructions6=new JLabel("For the action \"Add\", it takes parameters in the form type(a,h or m),name_of_the_accommodation,address,postal_code,city,description and creates a new accommodation.\n");
        //instructions7=new JLabel("For the action\"Delete\", it takes the name of the accommodation\n");
        instructions8=new JLabel("The third field takes the (optional) properties of an accommodation and is an optional field of actions \"Edit\" and \"Add\" in the form Key1-Value1,Key2-Value2, ...\n");
        instructions9=new JLabel("The action \"Edit\", edits the fields of an accommodation with a specific UID with the input from the second and third fields.\n");
        instructions10=new JLabel("The action \"Add\", adds an accommodation with input from the second and third fields. The action \"Delete\", deletes an accommodation with input the UID from the first field.\n");
        instructions11=new JLabel("The fourth field takes different parameters depending on the type of accommodation of the UID in the first field. It takes the extra fields(fields added by us) of an accommodation.\n");
        instructions12=new JLabel("For Apartment, it takes input in the form floor,space,guard,elevator. For Hotel, it takes input in the form stars,floor,suite. For Maisonette, it takes input roommates\n");
        instructions13=new JLabel("The button \"Change\" changes the extra fields and takes input from the first and the fourth fields.\n");
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
        //this.add(instructions2);
        this.add(instructions3);
        this.add(instructions4);
        this.add(instructions5);
        this.add(instructions6);
        //this.add(instructions7);
        this.add(instructions8);
        this.add(instructions9);
        this.add(instructions10);
        this.add(instructions11);
        this.add(instructions12);
        this.add(instructions13);

        // add action listeners
        //button_showOwned.addActionListener(this);
        button_show.addActionListener(this);
        button_Edit.addActionListener(this);
        button_change.addActionListener(this);

        this.setVisible(true);
        return this;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String[] temp = textField_UID.getText().split("#",-1);}
        /*Accommodation acc;
        String[] temp2 = textField_Change.getText().split(",",-1);
        String[] temp3 = textField_Edit.getText().split(",",-1);
        String[] prop = textField_Prop.getText().split(",");
        if (temp3.length<1){
            temp3=new String[5];
            for (int i=0;i<5;i++){temp3[i]="";}
        }
        if (e.getActionCommand().equals("Do Selected") && radio_button_Add.isSelected()){
            if (!(temp3.length==6)){
                JOptionPane.showMessageDialog(this, "Invalid Input.", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
            boolean q=service.addAccommodation(temp3[0], temp3[1], temp3[2], temp3[3], temp3[4], temp3[5]);
            if (q){
                JOptionPane.showMessageDialog(this, new Helper().AddProperties(temp3[0],service,temp3[1],prop).show(), "Accommodation added successfully", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(this, "Invalid Accommodation Type.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        }
        else{
            if (!(temp.length==3)){
                JOptionPane.showMessageDialog(this, "Invalid Input.", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;}
            acc=new Helper().Change(temp[0],temp[2],service,temp2,e.getActionCommand().equals("Change"));
            if(acc==null){
            JOptionPane.showMessageDialog(this, "ACCOMMODATION NOT FOUND. PLEASE CHECK THAT THE UID IS CORRECT", "ERROR!!!", JOptionPane.ERROR_MESSAGE);
        }
        else{
            if (e.getActionCommand().equals("Change") && (temp2.length>0 && !temp2[0].equals(""))){
                JOptionPane.showMessageDialog(this, "ACCOMMODATION CHANGED SUCCESSFULLY", "CHANGE", JOptionPane.INFORMATION_MESSAGE);
            }
            else if (e.getActionCommand().equals("Do Selected")) {
                if (radio_button_Edit.isSelected()) {
                    service.editAccommodation(temp[0], temp3[0], temp3[1], temp3[2], temp3[3], temp3[4], acc.getName(), prop);
                    JOptionPane.showMessageDialog(this, "Accommodation was edited successfully", "Edited Successfully", JOptionPane.INFORMATION_MESSAGE);

                }
                if (radio_button_Delete.isSelected()){
                    service.deleteAccommodation(temp[2]);
                    JOptionPane.showMessageDialog(this, "Accommodation was deleted successfully", "Deleted Successfully", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            if (!(e.getActionCommand().equals("Do Selected") && radio_button_Delete.isSelected())) {
                JOptionPane.showMessageDialog(this, acc.show(), new Helper().getTitle(temp[0]), JOptionPane.INFORMATION_MESSAGE);
            }
        }
        }
        try {
            service.destructor();
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }*/

    public static void main(String[] args) {
        Provider p=new Provider("someGuy","SG");
        new AccommodationManagerProviderGui().startGUI(p);
    }
}
