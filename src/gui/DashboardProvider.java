package gui;

import api.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class DashboardProvider extends JPanel implements  ActionListener{

    Provider service;

    JList jList;
    JTextArea jTextArea;
    JButton refresh;
    public void updateList(){
        jList.setModel(new AbstractListModel() {
            ArrayList<Apartment> ap=service.getOwnedApartments();
            ArrayList<Hotel> ho=service.getOwnedHotels();
            ArrayList<Maisonette> ma=service.getOwnedMaisonettes();
            String[] a={};
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
    }
    public DashboardProvider startGUI(Provider p) {
        service=p;
        jList = new JList();
        jTextArea = new JTextArea();
        refresh=new JButton("Refresh list");

        updateList();
        jTextArea.setColumns(20);
        jTextArea.setRows(5);
        this.add(refresh);
        this.add(jList);
        this.add(jTextArea);
        //f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //f.add(jPanel1);
        //f.pack();
        refresh.addActionListener(this);
        this.setVisible(true);
        return this;
    }

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {
        //set text on right here
        String s = (String) jList.getSelectedValue();
        String[] p=s.split("#");
        if (p[1].equals("Apartment")) {
            jTextArea.setText(service.getApartment(p[0]).show());}
        if (p[1].equals("Hotel")){
            jTextArea.setText(service.getHotel(p[0]).show());}
        if (p[1].equals("Maisonette")){
            jTextArea.setText(service.getMaisonette(p[0]).show());}
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Refresh list")){
            this.updateList();
        }

    }

    /*public DashboardProvider startGUI(String o, String fn) {
        service = new Provider(o,fn);

        this.setSize(1600, 300);

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

        this.setVisible(true);
        return this;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }*/

    //public static void main(String[] args) {
    //}
}
