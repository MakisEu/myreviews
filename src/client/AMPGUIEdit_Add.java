package client;

import api.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AMPGUIEdit_Add extends JPanel implements ActionListener {

    JTextField textField_UID, textField_name,textField_PC,textField_City,textField_Address,textField_description,textField_Prop,textField_Special;
    JRadioButton radio_button_Edit, radio_button_Add, radio_button_Delete,radio_button_Apartment,radio_button_Hotel,radio_button_Maisonette;
    JButton button_Add, button_Edit,button_Delete;
    JLabel UID,Name,City,PostalCode,Address,description,props,instructions1,instructions2,instructions3,type,special;
    JPanel Add;
    Client client;
    Pair<String,String> providerCreds;

    public AMPGUIEdit_Add(Client client, Pair<String, String> providerCreds) {
        super();
        this.client=client;
        this.providerCreds=providerCreds;

    }

    public AMPGUIEdit_Add startGUI() {
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
            if (textField_UID.getText().equals("") || textField_UID.getText().split("#").length<3){
                JOptionPane.showMessageDialog(this, "Accommodation was not found", "Invalid UID!!!", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                client.provider_delete_accommodation(providerCreds.a,providerCreds.b,textField_UID.getText());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getActionCommand().equals("Edit")){
            if (textField_UID.getText().equals("") || textField_UID.getText().split("#").length<3) {
                JOptionPane.showMessageDialog(this, "Accommodation was not found", "Invalid UID!!!", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Pair<String,String> pair = null;
            try {
                pair = client.provider_edit_accommodation(providerCreds.a,providerCreds.b,textField_UID.getText(),address,PC,city,description,textField_Prop.getText(),textField_Special.getText());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            if (pair.a!="0"){
                JOptionPane.showMessageDialog(this, "Accommodation was edited successfully", "Edited Successfully", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(this, pair.b, new Helper().getTitle(textField_UID.getText().split("#")[0]), JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(this, "Accommodation was not found", "Accommodation was not found!!!", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getActionCommand().equals("Add")){
            String details="";
            if (name.length()<1 || PC.length()<1 || address.length()<1 || city.length()<1 || description.length()<1){
                JOptionPane.showMessageDialog(this, "Please fill all the required fields.", "Not all required fields are filled!!!", JOptionPane.ERROR_MESSAGE);
            }
            else{
            String type="";
            Map<String, Integer> map = new HashMap<>(Map.of( "a", 4, "h",3,"m",1));
            if(radio_button_Apartment.isSelected()) {
                type = "a";
            } else if (radio_button_Hotel.isSelected()) {
                type = "h";
            } else {
                type = "m";
            }
            if (special.length<=map.get(type)){
                try {
                    details=client.provider_add_accommodation(providerCreds.a,providerCreds.b,type,name,address,PC,city,description,textField_Prop.getText(),textField_Special.getText());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

            } else if (special.length==0) {
                JOptionPane.showMessageDialog(this, "Incorrect amount of special fields. Special fields will stay in their default values.", "Added Successfully(Partially)", JOptionPane.ERROR_MESSAGE);
            }
            JOptionPane.showMessageDialog(this, "Accommodation was Added successfully", "Added Successfully", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(this, details, new Helper().getTitle(type), JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        new AMPGUIEdit_Add(new Client("127.0.0.1", 5000),new Pair<>("someGuy","SG")).startGUI();
    }
}
