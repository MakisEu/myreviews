package gui;

import api.AccommodationManager;
import api.AccommodationManagerProvider;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class AccommodationManagerGui extends JFrame implements ActionListener {

    JTextField textField_number1;
    JButton button_log;

    AccommodationManager service;

    public void StartGUI() {
        service = new AccommodationManager();

        this.setTitle("Accommodation Finder");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.setLayout(new FlowLayout());

        // buttons
        button_log = new JButton("Show");

        // text fields and area
        textField_number1 = new JTextField(10);
        // add to the panel
        this.add(textField_number1);
        this.add(button_log);
        // add action listeners
        button_log.addActionListener(this);
        //this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String x = textField_number1.getText();
        String[] temp=x.split("#");
        if (temp[0].equals("a")) {
            JOptionPane.showMessageDialog(this, service.getApartment(temp[1],temp[2]).show(), "Apartment", JOptionPane.INFORMATION_MESSAGE);
        }
        if (temp[0].equals("h")) {
            JOptionPane.showMessageDialog(this, service.getHotel(temp[1], temp[2]).show(), "Hotel", JOptionPane.INFORMATION_MESSAGE);
        }
        if (temp[0].equals("m")) {
            JOptionPane.showMessageDialog(this, service.getMaisonette(temp[1], temp[2]).show(), "Maisonette", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        //new AccommodationManagerGui().StartGUI();
        /*AccommodationManagerProvider AM=new AccommodationManagerProvider();
        AM.addAccommodation("Διαμέρισμα", "three-story building in Antigonidon(Apartment)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy");
        AM.destructor();*/
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AccommodationManagerGui().StartGUI();
            }
        });
    }
}
