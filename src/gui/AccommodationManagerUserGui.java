package gui;

import javax.swing.*;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import api.*;
import java.awt.*;
import java.util.Arrays;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.io.FileNotFoundException;

public class AccommodationManagerUserGui extends JPanel implements ActionListener {
    User service;
    JButton button_Search, button_Rate, button_Edit, button_Delete, refresh;
    JTextField textField_Type, textField_City, textField_Name, textField_Prop, textField_Description, textField_Grade, textField_Rate;
    JLabel label1, label2, label3, label4, rate, grade, desc;
    JPanel panel1, panel2, panel3;
    JList<String> list;
    JTextArea jTextArea;
    String[] all = new String[0];
    boolean q=false;
    javax.swing.event.ListSelectionEvent ev;

    public AccommodationManagerUserGui newGui(User s) {
        service = s;
        this.setSize(1400, 300);
        //this.setLayout(new FlowLayout());
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
        //panel1 = new JPanel(new GridLayout(5, 1));
        panel1.add(label1);
        panel1.add(textField_City);
        panel1.add(label2);
        panel1.add(textField_Type);
        panel1.add(label3);
        panel1.add(textField_Name);
        panel1.add(label4);
        panel1.add(textField_Prop);
        panel1.setLayout(new FlowLayout());
        panel1.add(button_Search);
        panel1.setBackground(Color.GRAY);
        this.add(panel1);

        panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());
        panel2.setBackground(Color.gray);
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
        this.add(panel2);

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

            all = Arrays.copyOf(all, service.Search(ct,tp,nm,prp).length);
            all=service.Search(ct,tp,nm,prp);
            //all = Arrays.copyOf(all, 2);
            //all[0] = "e#a";
            //all[1] = "d#o";

            newM();

            if (all.length < 1) {
                JOptionPane.showMessageDialog(this, "There are no accommodations with these elements", "Accommodation not found", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getActionCommand().equals("Refresh list")) {
            this.updateList();
        }

        boolean bool;
        if (e.getActionCommand().equals("Rate")) {
            bool = service.AddRating(textField_Rate.getText(), textField_Description.getText(), Float.parseFloat(textField_Grade.getText().replaceAll("[^0-9]", "")));
            if (!bool)
                JOptionPane.showMessageDialog(this, "Rating added successfully", "Added Rating", JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(this, "You cannot rate this accommodation", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (e.getActionCommand().equals("Edit Rating")) {
            bool = service.EditRating(textField_Rate.getText(), textField_Description.getText(), Float.parseFloat(textField_Grade.getText().replaceAll("[^0-9]", "")));
            if (bool)
                JOptionPane.showMessageDialog(this, "Edited Rating added successfully", "Added Edited Rating", JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(this, "You cannot edit this accommodation!!!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (e.getActionCommand().equals("Delete Rating")) {
            bool = service.DeleteRating(textField_Rate.getText());
            if (bool)
                JOptionPane.showMessageDialog(this, "Accommodation deleted successfully", "Deleted Rating", JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(this, "You cannot delete this accommodation!!!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateList() {
        list.setModel(new AbstractListModel() {
            String[] strings = all;

            @Override
            public int getSize() {
                return strings.length;
            }

            @Override
            public Object getElementAt(int i) {
                return strings[i];
            }
        });
        list.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent evt) {
                list1ValueChanged(evt);
            }
        });
        jTextArea.setText("");
    }


    public void newM() {
        if (!q) {
            list = new JList<>();
            jTextArea = new JTextArea();
            refresh = new JButton("Refresh list");

            updateList();
            jTextArea.setColumns(20);
            jTextArea.setRows(5);
            this.add(refresh);
            this.add(list);
            this.add(jTextArea);
            refresh.addActionListener(this);
            this.validate();
            this.setVisible(true);
        }
        q=true;
    }


    private void list1ValueChanged(javax.swing.event.ListSelectionEvent evt) {
        //set text on right here
        String s = (String) list.getSelectedValue();
        if (s != null) {
            String[] p=s.split("#");
            if (p[1].equals("Apartment")) {
                jTextArea.setText(service.getApartment(p[2],p[0]).show());}
            if (p[1].equals("Hotel")){
                jTextArea.setText(service.getHotel(p[2],p[0]).show());}
            if (p[1].equals("Maisonette")){
                jTextArea.setText(service.getMaisonette(p[2],p[0]).show());}}
    }

}



