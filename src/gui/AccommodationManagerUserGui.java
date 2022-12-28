package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import api.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class AccommodationManagerUserGui extends JPanel implements ActionListener {
    User service;
    JButton button_Search;
    JTextField textField_Search;

    public AccommodationManagerUserGui newGui(User s){
        service=s;
        this.setSize(1300, 300);
        this.setLayout(new FlowLayout());

         button_Search=new JButton("Search");
         textField_Search=new JTextField(20);

         this.add(button_Search);
         this.add(textField_Search);

         button_Search.addActionListener(this);

         return this;

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==button_Search){
            String text=textField_Search.getText();
        }



    }

}
