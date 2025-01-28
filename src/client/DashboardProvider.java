package client;

import api.Hotel;
import api.Pair;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.io.IOException;

public class DashboardProvider extends Dashboard {

    Pair<String, String> provider_cred;

    public DashboardProvider(Client client, Pair<String, String> provider_creds) {
        super(client);
        this.provider_cred=provider_creds;
    }

    public DashboardProvider startGUI( JFrame j) throws IOException, ClassNotFoundException {
        this.GUI(j);
        return this;
    }
    private void jList1ValueChanged(ListSelectionEvent evt) throws IOException, ClassNotFoundException {
        //set text on right here
        String s = (String) jList.getSelectedValue();
        if (s!=null) {
            String[] p = s.split("#");
            jTextArea.setText(client.provider_show_details(provider_cred.a, provider_cred.b, p[1], p[0]));
        }
    }
    public void updateList() throws IOException, ClassNotFoundException {

        Pair<Integer,Pair<Double,String[]>> pairs=client.provider_update_list(provider_cred.a,provider_cred.b);

        ratings.setText("Number of ratings: "+pairs.a+"| Average rating: "+pairs.b.a);
        jList.setModel(new AbstractListModel() {

            String[] strings = pairs.b.b;
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
                try {
                    jList1ValueChanged(evt);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        jTextArea.setText("");
    }
}

