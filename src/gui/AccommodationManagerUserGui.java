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
    JButton button_Search, button_Rate, button_Edit, button_Delete;
    JTextField textField_Type, textField_City, textField_Name, textField_Prop, textField_Description, textField_Grade, textField_Rate;
    JLabel label1, label2, label3, label4, rate, grade, desc, label5;
    JPanel panel1, panel2, panel3, panel4;

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
        panel1 = new JPanel();

        button_Search.setBackground(Color.ORANGE);
        label1 = new JLabel("Accommodation City:");
        label2 = new JLabel("Accommodation Type:");
        label3 = new JLabel("Accommodation Name:");
        label4 = new JLabel("Give desirable properties:");
        panel1 = new JPanel(new GridLayout(5, 1));
        panel1.add(label1);
        panel1.add(textField_City);
        panel1.add(label2);
        panel1.add(textField_Type);
        panel1.add(label3);
        panel1.add(textField_Name);
        panel1.add(label4);
        panel1.add(textField_Prop);
        add(panel1, BorderLayout.NORTH);
        panel1.add(button_Search);

        panel2 = new JPanel();
        panel2 = new JPanel((new GridLayout(5, 1)));
        rate = new JLabel("Name of accommodation:");
        grade = new JLabel("Grade:");
        desc = new JLabel("Description:");
        panel2.add(rate);
        textField_Rate = new JTextField(10);
        panel2.add(textField_Rate);
        panel2.add(grade);
        textField_Grade = new JTextField(10);
        panel2.add(textField_Grade);
        panel2.add(desc);
        textField_Description = new JTextField(10);
        panel2.add(textField_Description);
        button_Rate = new JButton("Rate");
        button_Rate.setBackground(Color.orange);
        panel2.add(button_Rate);
        add(panel2, BorderLayout.CENTER);

        button_Edit = new JButton("Edit Rating");
        button_Delete = new JButton("Delete Rating");
        button_Edit.setBackground(Color.orange);
        button_Delete.setBackground(Color.red);
        panel2.add(button_Edit);
        panel2.add(button_Delete);

        button_Edit.addActionListener(this);
        button_Delete.addActionListener(this);
        button_Rate.addActionListener(this);
        button_Search.addActionListener(this);
        return this;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println("hi");
        String ct = textField_City.getText();
        String tp = textField_Type.getText();
        String nm = textField_Name.getText();
        String[] prp = textField_Prop.getText().split(",");
        if (e.getActionCommand().equals("Search")) {
            //System.out.println(ct + "," + tp + "," + nm + "," + prp.length);
            if (ct.length() < 1)
                ct = "";
            if (tp.length() < 1)
                tp = "";
            if (nm.length() < 1)
                nm = "";
            for (int i = 0; i < prp.length; i++) {
                if (prp[i].length() < 1)
                    prp[i] = "";
            }
            String[] all = new String[2];//=service.Search(ct,tp,nm,prp);
            all[0] = "ena";
            all[1] = "dio";
            if (all.length<1){
                JOptionPane.showMessageDialog(this,"There are no accommodations with these elements","Accommodation not found",JOptionPane.ERROR_MESSAGE);
            }


            boolean flag = false;
            if (e.getActionCommand().equals("Rate")) {
                System.out.println("Rate");
                for (int i = 0; i < all.length && !flag; i++) {
                    if (textField_Rate.getText().equals(all[i])) {
                        service.AddRating(textField_Rate.getText(), textField_Description.getText(), Float.parseFloat(textField_Grade.getText().replaceAll("[^0-9]", "")));
                        JOptionPane.showMessageDialog(this, "Rating added successfully", "Added Rating", JOptionPane.INFORMATION_MESSAGE);
                        flag = true;
                    }
                }
                if (!flag)
                    JOptionPane.showMessageDialog(this, "Accommodation name not existing!", "ERROR!!!", JOptionPane.ERROR_MESSAGE);
            } else if (e.getActionCommand().equals("Edit Rating")) {
                System.out.println("Edit");
                for (int i = 0; i < all.length; i++) {
                    if (textField_Rate.getText().equals(all[i])) {
                        service.EditRating(textField_Rate.getText(), textField_Description.getText(), Float.parseFloat(textField_Grade.getText().replaceAll("[^0-9]", "")));
                        JOptionPane.showMessageDialog(this, "Edited Rating added successfully", "Added Rating", JOptionPane.INFORMATION_MESSAGE);
                        flag = true;
                    }
                }
                if (!flag) {
                    JOptionPane.showMessageDialog(this, "Accommodation name not existing!", "ERROR!!!", JOptionPane.ERROR_MESSAGE);
                }
            } else if (e.getActionCommand().equals("Delete Rating")) {
                System.out.println("Delete");
                for (int i = 0; i < all.length; i++) {
                    if (textField_Rate.getText().equals(all[i])) {
                        service.DeleteRating(textField_Rate.getText());
                        JOptionPane.showMessageDialog(this, "Accommodation deleted successfully", "Deleted Rating", JOptionPane.INFORMATION_MESSAGE);
                        flag = true;
                    }
                }
                if (!flag) {
                    JOptionPane.showMessageDialog(this, "Accommodation name not existing!", "ERROR!!!", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

}

