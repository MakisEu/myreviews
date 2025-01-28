package gui;

import api.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class AMPGUIEdit_Add extends JPanel implements ActionListener {

    JTextField textField_UID, textField_name,textField_PC,textField_City,textField_Address,textField_description,textField_Prop,textField_Special;
    JRadioButton radio_button_Edit, radio_button_Add, radio_button_Delete,radio_button_Apartment,radio_button_Hotel,radio_button_Maisonette;
    JButton button_Add, button_Edit,button_Delete;
    JLabel UID,Name,City,PostalCode,Address,description,props,instructions1,instructions2,instructions3,type,special;
    Provider service;
    JPanel Add;

    public AMPGUIEdit_Add startGUI(Provider s) {
        service = s;
        this.setSize(1600, 400);
        this.setLayout(new FlowLayout());

        // buttons
        button_Add = new JButton("Add");
        button_Edit = new JButton("Edit");
        button_Delete=new JButton("Delete");
        button_Add.setBackground(Color.orange);
        button_Edit.setBackground(Color.orange);
        button_Delete.setBackground(Color.red);

        // text fields and panels
        textField_UID = new JTextField(20);
        textField_name = new JTextField(20);
        textField_PC = new JTextField(10);
        textField_City = new JTextField(10);
        textField_Address = new JTextField(20);
        textField_description = new JTextField(10);
        textField_Prop = new JTextField(10);
        textField_Special=new JTextField();

        UID=new JLabel("UID of accommodation(only required by Edit and is \"Delete\"'s only field)");
        Name=new JLabel("Name");
        PostalCode=new JLabel("Postal Code");
        City=new JLabel("City");
        Address=new JLabel("Address");
        description=new JLabel("Description");
        props=new JLabel("Properties(Property-Value)");
        type=new JLabel("Type of accommodation(only required by Add)");
        instructions1=new JLabel("Leave field empty if you don't want to edit a field using the Edit button");
        instructions2=new JLabel("To skip a special field, leave that field empty");
        instructions3=new JLabel("Special fields:1)Hotel:stars,floor,suite. 2)Apartment:floor,space,guard,elevator. 3)Maisonette:roommates");

        special=new JLabel("Special fields of accommodation(field1,field2,...)(optional)");


        // radio buttons
        //radio_button_Edit = new JRadioButton("Edit");
        radio_button_Maisonette = new JRadioButton("Maisonette");
        radio_button_Hotel = new JRadioButton("Hotel");
        radio_button_Apartment = new JRadioButton("Apartment");
        radio_button_Apartment.setSelected(true);
        radio_button_Add = new JRadioButton("Add");
        ButtonGroup group = new ButtonGroup();
        group.add(radio_button_Apartment);
        group.add(radio_button_Hotel);
        group.add(radio_button_Maisonette);

        //this.add(textField_Change,BorderLayout.CENTER);

        // add to the panel
        //this.add(button_showOwned);
        Add=new JPanel(new GridLayout(14,1));
        JPanel temp=new JPanel(new FlowLayout());

        Add.add(UID);
        Add.add(textField_UID);
        Add.add(type);
        temp.add(radio_button_Apartment);
        temp.add(radio_button_Hotel);
        temp.add(radio_button_Maisonette);
        Add.add(temp,BorderLayout.CENTER);
        //Add.add(new JLabel(""));
        Add.add(Name);
        Add.add(textField_name);
        Add.add(City);
        Add.add(textField_City);
        Add.add(Address);
        Add.add(textField_Address);
        Add.add(PostalCode);
        Add.add(textField_PC);
        Add.add(description);
        Add.add(textField_description);
        Add.add(props);
        Add.add(textField_Prop);
        Add.add(special);
        Add.add(textField_Special);
        Add.add(button_Add);
        Add.add(button_Edit);
        Add.add(button_Delete);
        Add.add(instructions1);
        Add.add(instructions2);
        Add.add(instructions3);
        this.add(Add,BorderLayout.CENTER);
        /*this.add(button_Add);
        this.add(textField_Edit);
        this.add(textField_Prop);
        this.add(radio_button_Edit);
        this.add(radio_button_Add);
        this.add(radio_button_Delete);
        this.add(button_Edit);
        this.add(radio_button_Apartment);

        // add action listeners
        //button_showOwned.addActionListener(this);*/
        button_Add.addActionListener(this);
        button_Edit.addActionListener(this);
        button_Delete.addActionListener(this);

        this.setVisible(true);
        return this;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String name=textField_name.getText();
        String city=textField_City.getText();
        String PC=textField_PC.getText();
        String address=textField_Address.getText();
        String description=textField_description.getText();
        String[] prop=textField_Prop.getText().split(",",-1);
        String[] special=textField_Special.getText().split(",",-1);
        if (e.getActionCommand().equals("Delete")){
            String[] uid=textField_UID.getText().split("#");
            service.deleteAccommodation(uid[2],uid[0]);
            JOptionPane.showMessageDialog(this, "The accommodation was deleted.", "Deleted Accommodation", JOptionPane.INFORMATION_MESSAGE);

    }
        if (e.getActionCommand().equals("Edit")){
            String[] uid=textField_UID.getText().split("#");
            Accommodation acc=null;
            if (uid[0].equals("h")){
                Hotel ac=service.getHotel(uid[2]);
                if(special.length==3)
                {new Helper2().setHotel(special[0],special[1],special[2],ac);}
                else if (!(special.length==1 && special[0].equals(""))){
                    JOptionPane.showMessageDialog(this, "Incorrect amount of special fields. Special fields will not be edited.", "Edited Successfully(Partially)", JOptionPane.ERROR_MESSAGE);}
                acc=ac;

            }
            if (uid[0].equals("m")){
                Maisonette ac=service.getMaisonette(uid[2]);
                if(special.length==1)
                {new Helper2().setMaisonette(special[0],ac);}
                else if (special.length!=1 && special[0].equals("")){
                    JOptionPane.showMessageDialog(this, "Incorrect amount of special fields. Special fields will not be edited.", "Edited Successfully(Partially)", JOptionPane.ERROR_MESSAGE);
                }
                acc=ac;
            }
            if (uid[0].equals("a")){
                Apartment ac=service.getApartment(uid[2]);
                if(special.length==4)
                {new Helper2().setApartment(special[0],special[1],special[2],special[3],ac);}
                else if (special.length!=1 && special[0].equals("")){
                    JOptionPane.showMessageDialog(this, "Incorrect amount of special fields. Special fields will not be edited.", "Edited Successfully(Partially)", JOptionPane.ERROR_MESSAGE);
                }
                acc=ac;
            }
            if (acc!=null){
                service.editAccommodation(uid[0], name, address, PC, city, description, acc.getName(), prop);
                JOptionPane.showMessageDialog(this, "Accommodation was edited successfully", "Edited Successfully", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(this, acc.show(), new Helper().getTitle(uid[0]), JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(this, "Accommodation was not found", "Accommodation was not found!!!", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getActionCommand().equals("Add")){
            if (name.length()<1 || PC.length()<1 || address.length()<1 || city.length()<1 || description.length()<1){
                JOptionPane.showMessageDialog(this, "Please fill all the required fields.", "Not all required fields are filled!!!", JOptionPane.ERROR_MESSAGE);
            }
            else{
            Accommodation ac=null;
            String type="";
            if(radio_button_Apartment.isSelected()){
                service.addAccommodation("a",name,address,PC,city,description);
                Apartment acc=service.getApartment(name);
                if(special.length==4)
                {new Helper2().setApartment(special[0],special[1],special[2],special[3],acc);}
                else if (special.length!=0){
                    JOptionPane.showMessageDialog(this, "Incorrect amount of special fields. Special fields will stay in their default values.", "Added Successfully(Partially)", JOptionPane.ERROR_MESSAGE);
                }
                type="a";
                ac=acc;
            }
            else if (radio_button_Hotel.isSelected()){
                service.addAccommodation("h",name,address,PC,city,description);
                Hotel acc=service.getHotel(name);
                if(special.length==3)
                {new Helper2().setHotel(special[0],special[1],special[2],acc);}
                else if (special.length!=0){
                    JOptionPane.showMessageDialog(this, "Incorrect amount of special fields. Special fields will stay in their default values.", "Added Successfully(Partially)", JOptionPane.ERROR_MESSAGE);}
                ac=acc;
                type="h";
            }
            else {
                service.addAccommodation("m",name,address,PC,city,description);
                Maisonette acc=service.getMaisonette(name);
                if(special.length==1)
                {new Helper2().setMaisonette(special[0],acc);}
                else if (special.length!=0){
                    JOptionPane.showMessageDialog(this, "Incorrect amount of special fields. Special fields will not be edited.", "Added Successfully(Partially)", JOptionPane.ERROR_MESSAGE);
                }
                ac=acc;
                type="m";
                }
            new Helper().AddProperties(type,service,name,prop);
            JOptionPane.showMessageDialog(this, "Accommodation was edited successfully", "Edited Successfully", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(this, ac.show(), new Helper().getTitle(type), JOptionPane.INFORMATION_MESSAGE);
            }
        }

        try {
            service.destructor();
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        ;
        /*String[] temp = textField_UID.getText().split("#",-1);
        Accommodation acc;
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
        }*/
    }

    public static void main(String[] args) {
        Provider p=new Provider("someGuy","SG");
        new AMPGUIEdit_Add().startGUI(p);
    }
}
