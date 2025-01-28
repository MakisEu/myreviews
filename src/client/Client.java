package client;

import api.Pair;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;

public class Client {
    // initialization: socket, input & output streams
    private Socket socket = null;
    private DataInputStream input = null;
    private ObjectInputStream input_obj = null;
    private OutputStream output = null;
    String address;
    int port;
    // implementation of constructor
    public Client(String address, Integer port) {
        // Connect to server
        this.address=address;
        this.port=port;
    }
    public void reconnect() throws IOException {
        socket = new Socket(address, port);
    }

    public String login(String username, String password) throws IOException {
        this.reconnect();
        output = new ObjectOutputStream(socket.getOutputStream());
        HashMap<String,String> data=new HashMap<>();
        data.put("operation","1");
        data.put("username",username);
        data.put("password",password);
        ((ObjectOutputStream) output).writeObject(data);
        output.flush();

        input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        String login_result=input.readUTF();
        System.out.println("Login: "+login_result);
        return login_result;
    }

    public String signup(String username,String password,String name, String surname,String type) throws IOException {
        this.reconnect();
        output = new ObjectOutputStream(socket.getOutputStream());
        HashMap<String,String> data=new HashMap<>();
        data.put("operation","2");
        data.put("username",username);
        data.put("password",password);
        data.put("name",name);
        data.put("surname",surname);
        data.put("type",type);
        ((ObjectOutputStream) output).writeObject(data);
        output.flush();

        input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        String registration_results=input.readUTF();
        return registration_results;
    }

    public Pair<Double,String[]> user_update_list(String name,String username) throws IOException, ClassNotFoundException {
        this.reconnect();
        output = new ObjectOutputStream(socket.getOutputStream());
        HashMap<String,String> data=new HashMap<>();
        data.put("operation","3");
        data.put("username",username);
        data.put("name",name);
        data.put("sub_operation","update_list");
        ((ObjectOutputStream) output).writeObject(data);
        output.flush();

        input_obj = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
        Double mean = (Double) ((ObjectInputStream) input_obj).readObject();
        String[] ratings = (String[]) ((ObjectInputStream) input_obj).readObject();
        Pair<Double,String[]> pair=new Pair<>(mean,ratings);
        return pair;
    }

    public String[] user_search(String name,String username,String city, String type, String accommodation_name,String properties) throws IOException, ClassNotFoundException {
        this.reconnect();
        output = new ObjectOutputStream(socket.getOutputStream());
        HashMap<String,String> data=new HashMap<>();
        data.put("operation","3");
        data.put("username",username);
        data.put("name",name);
        data.put("sub_operation","search");
        data.put("city",city);
        data.put("type",type);
        data.put("accommodation_name",accommodation_name);
        data.put("properties",properties);
        ((ObjectOutputStream) output).writeObject(data);
        output.flush();

        input_obj = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
        String[] search_results = (String[]) ((ObjectInputStream) input_obj).readObject();
        return search_results;
    }

    public String user_show_details(String name,String username,String type, String owner,String accommodation_name) throws IOException, ClassNotFoundException {
        this.reconnect();
        output = new ObjectOutputStream(socket.getOutputStream());
        HashMap<String,String> data=new HashMap<>();
        data.put("operation","3");
        data.put("username",username);
        data.put("name",name);
        data.put("sub_operation","show_details");
        data.put("type",type);
        data.put("owner",owner);
        data.put("accommodation_name",accommodation_name);
        ((ObjectOutputStream) output).writeObject(data);
        output.flush();

        input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        String accommodation_details=input.readUTF();
        return accommodation_details;
    }

    public String[] user_process_rating(String name,String username,String process_rating, String uid,String rating_description, String rating_score) throws IOException, ClassNotFoundException {
        this.reconnect();
        output = new ObjectOutputStream(socket.getOutputStream());
        HashMap<String,String> data=new HashMap<>();
        data.put("operation","3");
        data.put("username",username);
        data.put("name",name);
        data.put("sub_operation","process_rating");
        data.put("process_rating",process_rating);
        data.put("uid",uid);
        data.put("rating_description",rating_description);
        data.put("rating_score",rating_score);
        ((ObjectOutputStream) output).writeObject(data);
        output.flush();

        input_obj = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
        String[] processing_results = (String[]) ((ObjectInputStream) input_obj).readObject();
        return processing_results;
    }

    public Pair<Integer,Pair<Double,String[]>> provider_update_list(String name,String first_name) throws IOException, ClassNotFoundException {
        this.reconnect();
        output = new ObjectOutputStream(socket.getOutputStream());
        HashMap<String,String> data=new HashMap<>();
        data.put("operation","4");
        data.put("first_name",first_name);
        data.put("name",name);
        data.put("sub_operation","update_list");
        ((ObjectOutputStream) output).writeObject(data);
        output.flush();

        input_obj = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
        int number_of_ratings = (Integer) ((ObjectInputStream) input_obj).readObject();
        Double avg_of_grades = (Double) ((ObjectInputStream) input_obj).readObject();
        String[] names = (String[]) ((ObjectInputStream) input_obj).readObject();
        Pair<Double,String[]> pair=new Pair<>(avg_of_grades,names);
        Pair<Integer,Pair<Double,String[]>> out= new Pair<>(number_of_ratings,pair);
        return out;
    }

    public String provider_show_details(String name,String first_name,String type, String accommodation_name) throws IOException, ClassNotFoundException {
        this.reconnect();
        output = new ObjectOutputStream(socket.getOutputStream());
        HashMap<String,String> data=new HashMap<>();
        data.put("operation","4");
        data.put("first_name",first_name);
        data.put("name",name);
        data.put("sub_operation","show_details");
        data.put("type",type);
        data.put("accommodation_name",accommodation_name);
        ((ObjectOutputStream) output).writeObject(data);
        output.flush();

        input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        String accommodation_details=input.readUTF();
        return accommodation_details;
    }

    public void provider_delete_accommodation(String name,String first_name,String uid) throws IOException, ClassNotFoundException {
        this.reconnect();
        output = new ObjectOutputStream(socket.getOutputStream());
        HashMap<String,String> data=new HashMap<>();
        data.put("operation","4");
        data.put("first_name",first_name);
        data.put("name",name);
        data.put("sub_operation","delete_accommodation");
        data.put("uid",uid);
        ((ObjectOutputStream) output).writeObject(data);
        output.flush();

    }

    public String provider_add_accommodation(String name,String first_name,String type, String accommodation_name, String address, String postal_code, String city, String description, String properties, String special) throws IOException, ClassNotFoundException {
        this.reconnect();
        output = new ObjectOutputStream(socket.getOutputStream());
        HashMap<String,String> data=new HashMap<>();
        data.put("operation","4");
        data.put("first_name",first_name);
        data.put("name",name);
        data.put("sub_operation","add_accommodation");
        data.put("type",type);
        data.put("accommodation_name",accommodation_name);
        data.put("address",address);
        data.put("postal_code",postal_code);
        data.put("city",city);
        data.put("description",description);
        data.put("properties",properties);
        data.put("special",special);
        ((ObjectOutputStream) output).writeObject(data);
        output.flush();

        input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        String accommodation_details=input.readUTF();
        System.out.println("Accommodation details: "+accommodation_details);
        return accommodation_details;
    }

    public Pair<String,String> provider_edit_accommodation(String name,String first_name,String uid, String address, String postal_code, String city, String description, String properties, String special) throws IOException, ClassNotFoundException {
        this.reconnect();
        output = new ObjectOutputStream(socket.getOutputStream());
        HashMap<String,String> data=new HashMap<>();
        data.put("operation","4");
        data.put("first_name",first_name);
        data.put("name",name);
        data.put("sub_operation","edit_accommodation");
        data.put("uid",uid);
        data.put("address",address);
        data.put("postal_code",postal_code);
        data.put("city",city);
        data.put("description",description);
        data.put("properties",properties);
        data.put("special",special);
        ((ObjectOutputStream) output).writeObject(data);
        output.flush();

        input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        String accommodation_is_not_null=input.readUTF();
        String accommodation_details = "";
        if (accommodation_is_not_null.equals("1")){
            accommodation_details=input.readUTF();
        }
        Pair<String,String> pair= new Pair<>(accommodation_is_not_null,accommodation_details);
        return pair;
    }
    /**
     * Closes the connection with the server
     */
    public void closeConnection(){
        // terminate the connection
        try {
            input.close();
            output.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
        }
    }
    public static void main(String[] args) {
        try {
            Client clientSideTCP = new Client("127.0.0.1", 5000);
            new StartScreenGUI(clientSideTCP).g();
            clientSideTCP.closeConnection();
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Incorrect amount of arguments for this operation!");
        }

    }
}
