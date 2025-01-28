package client;

import api.Pair;
import api.User;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AccommodationManagerUserGui extends JPanel implements ActionListener {
    JButton button_Search, button_Rate, button_Edit, button_Delete, refresh;
    JTextField textField_Type, textField_City, textField_Name, textField_Prop, textField_Description, textField_Grade, textField_Rate;
    JLabel label1, label2, label3, label4, rate, grade, desc;
    JPanel panel1, panel2, panel3;
    JList<String> list;
    JTextArea jTextArea;
    String[] all = new String[0];
    boolean q=false;
    ListSelectionEvent ev;
    Client client;
    Pair<String,String> userCreds;

    public AccommodationManagerUserGui(Client client, Pair<String, String> userCreds) {
        this.client=client;
        this.userCreds=userCreds;
    }

    public AccommodationManagerUserGui newGui() {
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
        rate = new JLabel("UID of accommodation:");
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
        String prp = textField_Prop.getText();
        if (e.getActionCommand().equals("Search")) {
            //System.out.println(ct + "," + tp + "," + nm + "," + prp.length);
            if (ct.length() < 1)
                ct = "";
            if (tp.length() < 1)
                tp = "";
            if (nm.length() < 1)
                nm = "";
            if (prp.length() < 1)
                prp="";
            try {
                all = client.user_search(userCreds.a, userCreds.b, ct, tp, nm, prp);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }

            if (all==null || all.length < 1)
                JOptionPane.showMessageDialog(this, "There are no accommodations with these elements", "Accommodation not found", JOptionPane.ERROR_MESSAGE);
            else
                newM();
        }

        if (e.getActionCommand().equals("Refresh list")) {
            this.updateList();
        }

        int q;
        String[] messages;
        String processRating;
        if (e.getActionCommand().equals("Rate") || e.getActionCommand().equals("Delete Rating") || e.getActionCommand().equals("Edit Rating")) {
            if (e.getActionCommand().equals("Rate")) {
                processRating = "add_rating";
            } else if (e.getActionCommand().equals("Edit Rating")) {
                processRating = "edit_rating";
            } else {
                processRating = "delete_rating";
            }
            try {
                messages = client.user_process_rating(userCreds.a, userCreds.b, processRating, textField_Rate.getText(), textField_Description.getText(), textField_Grade.getText().replaceAll("[^0-9]", ""));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            JOptionPane.showMessageDialog(this, messages[0], messages[1], Integer.parseInt(messages[2]));
        }
    }



    public void updateList() {
        list.setModel(new AbstractListModel() {
            String[] strings=all;


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
                try {
                    list1ValueChanged(evt);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
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


    private void list1ValueChanged(ListSelectionEvent evt) throws IOException, ClassNotFoundException {
        //set text on right here
        String s = (String) list.getSelectedValue();
        if (s != null) {
            String[] p=s.split("#");
            jTextArea.setText(client.user_show_details(userCreds.a, userCreds.b, p[2],p[0],p[1]));
        }
    }

}



