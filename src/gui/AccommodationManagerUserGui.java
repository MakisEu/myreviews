package gui;

import javax.swing.*;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import api.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class AccommodationManagerUserGui extends JPanel implements ActionListener {
    User service;
    JButton button_Search;
    JTextField textField_Type, textField_City, textField_Name, textField_Prop;
    JLabel label;

    public AccommodationManagerUserGui newGui(User s) {
        service = s;
        this.setSize(1300, 300);
        this.setLayout(new FlowLayout());

        button_Search = new JButton("Search");
        textField_City = new JTextField(10);
        textField_Type = new JTextField(10);
        textField_Name = new JTextField(10);
        textField_Prop = new JTextField(10);
        label=new JLabel();
        label.setText("Give city");
        //label.setLabelFor(textField_Prop);
        //label.setHorizontalAlignment(JLabel.BOTTOM);

        this.add(button_Search);
        this.add(textField_City);
        this.add(textField_Type);
        this.add(textField_Name);
        this.add(textField_Prop);


        button_Search.addActionListener(this);

        return this;

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println("hi");

    String ct=textField_City.getText();
    String tp=textField_Type.getText();
    String nm=textField_Name.getText();
    String[] prp=textField_Prop.getText().split(",");

   /* if (tx.length<1)
        {
        tx=new String[5];
        for (int i=0;i<5;i++)
            tx[i]="";
        }*/

    if (e.getActionCommand().equals("Search")){
        System.out.println(ct+","+tp+","+nm+","+prp.length);
        if (ct.length()<1)
            ct="";
        if (tp.length()<1)
            tp="";
        if (nm.length()<1)
            nm="";
        for (int i=0;i<prp.length;i++) {
            if (prp[i].length() < 1)
                prp[i] = "";
        }
        String[] all=service.Search(ct,tp,nm,prp);
        //for (int i=0;i<all.length;i++)
            //System.out.println(all[i]);
        }




    }





}
