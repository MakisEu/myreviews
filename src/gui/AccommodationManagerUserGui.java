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
    JLabel label1,label2,label3,label4,rate,grade,desc;
    JPanel panel1,panel2,panel3,panel4;

    public AccommodationManagerUserGui newGui(User s) {
        service = s;
        this.setSize(1300, 300);
        //this.setLayout(new FlowLayout());
        //this.setLayout(new BorderLayout());
        button_Search = new JButton("Search");
        textField_City = new JTextField(10);
        textField_Type = new JTextField(10);
        textField_Name = new JTextField(10);
        textField_Prop = new JTextField(10);
        panel1=new JPanel();

        //panel1.setPreferredSize(new Dimension(100,50));
        //panel1.setBackground(Color.magenta);
        //this.add(panel1,BorderLayout.NORTH);
        //this.add(panel1);
        button_Search.setBackground(Color.ORANGE);
        label1=new JLabel("Accommodation City:");
        label2=new JLabel("Accommodation Type:");
        label3=new JLabel("Accommodation Name:");
        label4=new JLabel("Give desirable properties:");
        panel1=new JPanel(new GridLayout(5,1));
        panel1.add(label1);
        panel1.add(textField_City);
        panel1.add(label2);
        panel1.add(textField_Type);
        panel1.add(label3);
        panel1.add(textField_Name);
        panel1.add(label4);
        panel1.add(textField_Prop);
        add(panel1,BorderLayout.NORTH);

        panel2=new JPanel();
        panel2=new JPanel((new GridLayout(4,1)));
        //panel2.setBackground(Color.red);
        add(panel2,BorderLayout.CENTER);

        panel1.add(button_Search);


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
        String[] all=new String[2];//=service.Search(ct,tp,nm,prp);
        all[0]="ena";
        all[1]="dio";
        for (int i=0;i<all.length;i++) {
            System.out.println(all[i]);
        }

        if (!(all.length<1)){
            rate=new JLabel("Rate:");
            grade=new JLabel("Grade:");
            desc=new JLabel("Description:");

            panel2.add(rate);
            textField_Rate=new JTextField(10);
            panel2.add(textField_Rate);

            panel2.add(grade);
            textField_Grade=new JTextField(10);
            panel2.add(textField_Grade);

            panel2.add(desc);
            textField_Description=new JTextField(10);
            panel2.add(textField_Description);


            button_Rate=new JButton("Rate");
            button_Rate.setBackground(Color.orange);
            panel2.add(button_Rate);
            button_Rate.addActionListener(this);

            this.validate();
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
