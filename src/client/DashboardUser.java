package client;

import api.Pair;
import api.User;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.io.IOException;

public class DashboardUser extends Dashboard {
    Pair<String,String> userCreds;

    public DashboardUser(Client client, Pair<String, String> userCreds) {
        super(client);
        this.userCreds=userCreds;
    }

    public DashboardUser startGUI( JFrame j) throws IOException, ClassNotFoundException {
        GUI(j);
        return this;
    }
    private void jList1ValueChanged(ListSelectionEvent evt) throws IOException, ClassNotFoundException {
        //set text on right here
        String s = (String) jList.getSelectedValue();
        if (s!=null) {
            String[] p = s.split(",");
            jTextArea.setText(client.user_show_details(userCreds.a, userCreds.b, p[1], p[2], p[0]));
        }
    }
    public void updateList() throws IOException, ClassNotFoundException {
        Pair<Double,String[]> pair= client.user_update_list(userCreds.a,userCreds.b);
        ratings.setText("Average rating: "+pair.a);
        jList.setModel(new AbstractListModel() {
            String[] strings = pair.b;

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
