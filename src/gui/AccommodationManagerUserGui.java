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
    JButton button_Search,button_Rate;
    JTextField textField_Type, textField_City, textField_Name, textField_Prop,textField_Description,textField_Grade,textField_Rate;
    JLabel label1,label2,label3,label4,label5;

    public AccommodationManagerUserGui newGui(User s) {
        service = s;
        this.setSize(1300, 300);
        this.setLayout(new FlowLayout());

        button_Search = new JButton("Search");
        textField_City = new JTextField(10);
        textField_Type = new JTextField(10);
        textField_Name = new JTextField(10);
        textField_Prop = new JTextField(10);
        /*label1=new JLabel("Give city");
        label1.setLabelFor(textField_City);
        label2=new JLabel("Give type");
        label2.setLabelFor(textField_City);*/


        this.add(button_Search);
        this.add(textField_City);
        this.add(textField_Type);
        this.add(textField_Name);
        this.add(textField_Prop);
        //this.add(label1);
        //this.add(label2);

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
        for (int i=0;i<all.length;i++) {
            System.out.println(all[i]);
        }

        if (!(all.length<1)){
            button_Rate=new JButton("Rate");
            this.add(button_Rate);
            textField_Description=new JTextField();
            this.add(textField_Description);
            textField_Grade=new JTextField();
            this.add(textField_Grade);
            textField_Rate=new JTextField();
            this.add(textField_Rate);
            //String[] tx=textField_Rate.getText().split(",",2);
            for (int i=0;i<all.length;i++) {
                if (textField_Rate.getText().equals(all[i]) && e.getActionCommand().equals("Rate")){
                    service.AddRating(textField_Rate.getText(),textField_Description.getText(),Integer.parseInt(textField_Grade.getText().replaceAll("[^0-9]", "")));
                }
            }

        }



        }




    }





}
