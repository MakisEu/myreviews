package api;

import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Server {
    // initialization of socket and input stream
    private ServerSocket serverSocket = null;

    //HashMap<String,Boolean> isLoggedIn;
    private Login login;
    private AllRegistered registered;
    // implementation of constructor
    public Server(int port) {
// start server and wait for a connection
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started!");
            System.out.println("Waiting for a client ......");

            login=new Login();
            registered=new AllRegistered();
            // running infinite loop accepting client request
            while (true) {
                // socket object to receive incoming client requests
                Socket client = serverSocket.accept();
                System.out.println("New client connected: "
                        + client.getInetAddress().getHostAddress());
                // create a new thread object of Runnable
                ClientHandler clientSock = new ClientHandler(client,login,registered);
                // This thread will handle the client separately
                new Thread(clientSock).start();
                System.out.println("Connection Closed: "
                        + client.getInetAddress().getHostAddress());

            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) {
        Server serverSideTCP = new Server(5000);
    }
    /*
     * ClientHandler is a class implements the logic of the server for a client's requests
     */
    private static class ClientHandler implements Runnable {
        private final Socket clientSocket;

        private InputStream in = null;
        private OutputStream output= null ;


        private Login login;
        private AllRegistered registered;
        // Constructor that passes the data of the server into this instance
        public ClientHandler(Socket socket, Login login, AllRegistered registered)
        {
            this.clientSocket = socket;
            this.login=login;
            this.registered=registered;

        }
        // the thread echoes client's messages
        public void run()
        {
            try {
                // take input from the client socket
                HashMap<String, String> data = getDefaultData();

                in = new ObjectInputStream(new BufferedInputStream(clientSocket.getInputStream()));
                HashMap<String, String> new_data = (HashMap<String, String>) ((ObjectInputStream) in).readObject();
                data.putAll(new_data);
                try {
                    System.out.println("Input: "+data.toString().replaceAll("[{}]", ""));

                    String operation=data.get("operation"); // Operation/Functionality to execute. 0: Login, 1: SignUp. 3:User functionality, 4: Provider functionality
                    String username;
                    String password;
                    String name;
                    String surname;
                    String type;
                    switch (operation) {
                        case "1": // When FN_ID is 1
                            username=data.get("username");
                            password=data.get("password");
                            String login_result=login.log_in(username,password);
                            if (login_result == null){
                                login_result= "Wrong credentials!";
                            }

                            output = new DataOutputStream(clientSocket.getOutputStream());
                            ((DataOutputStream) output).writeUTF(login_result);
                            break;
                        case "2": // When FN_ID is 2
                            username=data.get("username");
                            password=data.get("password");
                            name=data.get("name");
                            surname=data.get("surname");
                            type=data.get("type");
                            String registration_result=registered.add_registration(username,password,name,surname,type);

                            output = new DataOutputStream(clientSocket.getOutputStream());
                            ((DataOutputStream) output).writeUTF(registration_result);
                            break;
                        case "3": // When FN_ID is 3
                            name=data.get("name");
                            username=data.get("username");
                            User user=new User(name,username);
                            user_control(data, user);
                            break;
                        case "4": // When FN_ID is 4
                            name=data.get("name");
                            Provider provider=new Provider(name,data.get("first_name"));
                            provider_control(data,provider);
                            break;
                    }
                    this.closeConnection();
                } catch (IOException e) {
                    System.out.println(e);
                    System.out.println(data.toString().replaceAll("[{}]", ""));

                }

            }
            catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        private static HashMap<String, String> getDefaultData() {
            HashMap<String,String> data=new HashMap<>();
            data.put("operation","");
            data.put("username","");
            data.put("password","");
            data.put("name","");
            data.put("surname","");
            data.put("owner","");
            data.put("type","");
            data.put("sub_operation","");
            data.put("uid","");
            data.put("address","");
            data.put("postal_code","");
            data.put("city","");
            data.put("description","");
            data.put("properties","");
            data.put("special","");
            data.put("process_rating","");
            data.put("accommodation_name","");
            data.put("rating_description","");
            data.put("rating_score","");
            return data;
        }

        private void provider_control(HashMap<String,String> args, Provider provider) throws IOException {
            String operation=args.get("sub_operation");

            String name,type;
            String address,PC,city,description;
            String special;
            String accomodation_details;
            String[] prop, special_fields,uid;
            Accommodation acc;
            String message;


            switch (operation){
                case "update_list":
                    output = new ObjectOutputStream(clientSocket.getOutputStream());
                    ((ObjectOutputStream) output).writeObject(provider.getAllRatingsNumber());
                    ((ObjectOutputStream) output).writeObject(provider.getAllAccommodationsGrades());
                    ((ObjectOutputStream) output).writeObject(provider.getNames());
                    output.flush();
                    break;
                case "show_details":
                    type=args.get("type");
                    name=args.get("accommodation_name");
                    output = new DataOutputStream(clientSocket.getOutputStream());
                    ((DataOutputStream) output).writeUTF(get_accommodation_details_provider(provider,type,name));
                    output.flush();
                    break;
                case "delete_accommodation":
                    uid=args.get("uid").split("#");
                    provider.deleteAccommodation(uid[2],uid[0]);
                    provider.destructor();
                    break;
                case "add_accommodation":
                    type=args.get("type");
                    name=args.get("accommodation_name");
                    address=args.get("address");
                    PC=args.get("postal_code");
                    city=args.get("city");
                    description=args.get("description");
                    prop=args.get("properties").split(",",-1);
                    special=args.get("special");
                    special_fields=special.split(",", -1);
                    provider.addAccommodation(type,name,address,PC,city,description);;

                    if (type.equals("a")){
                        acc=provider.getApartment(name);
                        if (special.length()==4) {
                            new Helper2().setApartment(special_fields[0], special_fields[1], special_fields[2], special_fields[3], (Apartment) acc);
                        }
                    } else if (type.equals("h")) {
                        acc=provider.getHotel(name);
                        if (special.length()==3) {
                            new Helper2().setHotel(special_fields[0], special_fields[1], special_fields[2], (Hotel) acc);
                        }
                    } else {
                        acc=provider.getMaisonette(name);
                        if (special.length()==1) {
                            new Helper2().setMaisonette(special_fields[0], (Maisonette) acc);
                        }
                    }
                    if (prop.length>0) {
                        new Helper().AddProperties(type, provider, name, prop);
                    }
                    provider.destructor();

                    accomodation_details=acc.show();
                    output = new DataOutputStream(clientSocket.getOutputStream());
                    ((DataOutputStream) output).writeUTF(accomodation_details);
                    output.flush();
                    break;
                case "edit_accommodation":
                    message="";
                    uid=args.get("uid").split("#");
                    type=uid[0];
                    name=uid[2];
                    address=args.get("address");
                    PC=args.get("postal_code");
                    city=args.get("city");
                    description=args.get("description");
                    prop=args.get("properties").split(",",-1);
                    special=args.get("special");
                    special_fields=special.split(",", -1);
                    output = new DataOutputStream(clientSocket.getOutputStream());


                    if (type.equals("a")){
                        acc=provider.getApartment(name);
                        if (special.length()==4) {
                            new Helper2().setApartment(special_fields[0], special_fields[1], special_fields[2], special_fields[3], (Apartment) acc);
                        }
                    } else if (type.equals("h")) {
                        acc=provider.getHotel(name);
                        if (special.length()==3) {
                            new Helper2().setHotel(special_fields[0], special_fields[1], special_fields[2], (Hotel) acc);
                        }
                    } else {
                        acc=provider.getMaisonette(name);
                        if (special.length()==4) {
                            new Helper2().setMaisonette(special_fields[0], (Maisonette) acc);
                        }
                    }
                    if (acc!=null){
                        ((DataOutputStream) output).writeUTF("1");
                        provider.editAccommodation(uid[0], name, address, PC, city, description, acc.getName(), prop);
                        accomodation_details=acc.show();
                        ((DataOutputStream) output).writeUTF(accomodation_details);
                    }
                    else{
                        ((DataOutputStream) output).writeUTF("0");
                    }
                    provider.destructor();
                    output.flush();
                    break;
            }

        }
        public String get_accommodation_details_provider(Provider provider, String type, String name){
            String shown="";
            switch (type){
                case "Apartment":
                    shown=provider.getApartment(name).show();
                    break;
                case "Hotel":
                    shown=provider.getHotel(name).show();
                case "Maisonette":
                    shown=provider.getMaisonette(name).show();
                    break;
            }
            return shown;
        }

        public void user_control(HashMap<String,String> args,User user) throws IOException {
            String operation=args.get("sub_operation");
            String ct,tp,nm,prp;
            String owner,name,type;
            String process_rating;
            String[] prps;

            switch (operation){
                case "update_list":
                    output = new ObjectOutputStream(clientSocket.getOutputStream());
                    ((ObjectOutputStream) output).writeObject(user.getMean());
                    ((ObjectOutputStream) output).writeObject(user.allRatings());
                    output.flush();
                    break;
                case "search":
                    ct=args.get("city");
                    tp=args.get("type");
                    nm=args.get("accommodation_name");
                    prps=args.get("properties").split(",");
                    for (int i = 0; i < prps.length; i++) {
                        if (prps[i].length() < 1 )
                            prps[i] = "";
                    }
                    System.out.println("prps[0]:"+prps[0]);
                    output = new ObjectOutputStream(clientSocket.getOutputStream());
                    ((ObjectOutputStream) output).writeObject(user.Search(ct,tp,nm, prps));
                    output.flush();
                    break;
                case  "show_details":
                    type=args.get("type");
                    owner=args.get("owner");
                    name=args.get("accommodation_name");
                    output = new DataOutputStream(clientSocket.getOutputStream());
                    ((DataOutputStream) output).writeUTF(get_accommodation_details_user(user,type,owner,name));
                    output.flush();
                    System.out.println("Accommodation_details"+get_accommodation_details_user(user,type,owner,name));
                    break;
                case "process_rating":
                    process_rating=args.get("process_rating");
                    String uid=args.get("uid");;
                    String[] messages=rating_results(user,args,process_rating,uid);
                    output = new ObjectOutputStream(clientSocket.getOutputStream());
                    ((ObjectOutputStream) output).writeObject(messages);
                    output.flush();
                    break;

            }
        }

        public  String[] rating_results(User user,HashMap<String,String> args,String process_rating,String uid){
            String message, title, error;
            if (process_rating.equals("add_rating")){
                String rating=args.get("rating_description");
                float score=Float.parseFloat(args.get("rating_score"));
                int q=user.AddRating(uid,rating,score);
                if (q==0){
                    message = "Rating added successfully";title = "Added Rating";error = "1";
                } else if (q==1) {
                    message = "You have already rated this accommodation";title = "Error";error = "0";
                }
                else{
                    message = "You can not rate a non-existent accommodation";title = "Error";error = "0";
                }
            } else if (process_rating.equals("edit_rating")) {
                String rating=args.get("rating_description");
                float score=Float.parseFloat(args.get("rating_score"));
                int q=user.EditRating(uid,rating,score);
                if (q==0){
                    message = "Edited Rating added successfully";title = "Edited Rating";error = "1";
                } else if (q==1) {
                    message = "You can not edit a non-existent rating!!!";title = "Error";error = "0";
                }
                else{
                    message = "You can not edit a rating on a non-existent accommodation!!!";title = "Error";error = "0";
                }
            }
            else {
                int q=user.DeleteRating(uid);
                if (q==0){
                    message = "Rating deleted successfully";title = "Deleted Rating";error = "1";
                } else if (q==1) {
                    message = "You can not delete a non-existent rating!!!";title = "Error";error = "0";
                }
                else{
                    message = "You can not delete a rating on a non-existent accommodation!!!";title = "Error";error = "0";
                }
            }
            user.destructor();
            return new String[]{message, title, error};
        }

        public String get_accommodation_details_user(User user, String type, String owner, String name){
            String shown="";
            switch (type){
                case "Apartment":
                    shown=user.getApartment(owner,name).show();
                    break;
                case "Hotel":
                    shown=user.getHotel(owner,name).show();
                    break;
                case "Maisonette":
                    shown=user.getMaisonette(owner,name).show();
                    break;
            }
            return shown;
        }

        public void closeConnection(){
            try{
                // close connection
                clientSocket.close();
                in.close();
                output.close();
            } catch (IOException e) {
            } catch (NullPointerException e){}
        }
    }
}
