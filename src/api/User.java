package api;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

public class User {
    AccommodationManagerUser amu;
    String name,username;
    public User(String n,String u){
        name=n;
        username=u;
        amu=new AccommodationManagerUser();
    }

    public String getName(){
        return name;
    }

    public String getUsername(){
        return username;
    }

    public void AddRating(String on,String rating,float score){
        String[] x=on.split("#");
        amu.addRating(x[0],x[1],rating,score,username,new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date()),name);
    }

   public Apartment getApartment(String o,String n)  {
       return amu.getApartment(o,n);
   }

    public Hotel getHotel(String o,String n)  {
        return amu.getHotel(o,n);
    }

    public Maisonette getMaisonette(String o,String n)  {
        return amu.getMaisonette(o,n);
    }



    public void EditRating(String on,String rating,float score){
        System.out.println("EDITTT");
        String[] x=on.split("#");
        amu.editRatings(x[0],x[1],rating,score,username);
    }
    public void DeleteRating(String on){
        String[] x=on.split("#");
        amu.deleteRating(x[0],x[1],username);
    }

    public String[] allRatings(){
        String[] all;
        all=amu.allRatings(username);
        return all;
    }

    public double getMean(String username){
        return amu.getMean(username);
    }


    public String[] Search(String city,String type,String name,String[] prop){
        String[][] temp;
        String[] t;
        HashSet<String> aMain=null;
        HashSet<String> hMain=null;
        HashSet<String> mMain=null;
        if(city.length()>1){
            aMain=new HashSet<>();
            hMain=new HashSet<>();
            mMain=new HashSet<>();
            temp=amu.findLocation(city);
            for (String s:temp[0]){
                aMain.add(s);
            }
            for (String s:temp[1]){
                hMain.add(s);
            }
            for (String s:temp[2]){
                mMain.add(s);
            }
        }
        if(prop[0].length()>2){
            String[] a1=new String[prop.length],a2=new String[prop.length];
            int c=0;
            for (String s: prop){
                a1[c]=s.split("-")[0];
                a2[c]=s.split("-")[1];
                c++;
            }
            temp= amu.findProperties(a1,a2);
            if (aMain!=null){
            HashSet<String> aSub=new HashSet<>();
            HashSet<String> hSub=new HashSet<>();
            HashSet<String> mSub=new HashSet<>();
            for (String s:temp[0]){
                aSub.add(s);
            }
            for (String s:temp[1]){
                hSub.add(s);
            }
            for (String s:temp[2]){
                mSub.add(s);
            }
            aMain.retainAll(aSub);
            hMain.retainAll(hSub);
            mMain.retainAll(mSub);}
            else{
                aMain=new HashSet<>();
                hMain=new HashSet<>();
                mMain=new HashSet<>();
                temp=amu.findLocation(city);
                for (String s:temp[0]){
                    aMain.add(s);
                }
                for (String s:temp[1]){
                    hMain.add(s);
                }
                for (String s:temp[2]){
                    mMain.add(s);
                }
            }
        }
        if(name.length()>1){
            temp= amu.findName(name);
            if (aMain!=null){
                HashSet<String> aSub=new HashSet<>();
                HashSet<String> hSub=new HashSet<>();
                HashSet<String> mSub=new HashSet<>();
                for (String s:temp[0]){
                    aSub.add(s);
                }
                for (String s:temp[1]){
                    hSub.add(s);
                }
                for (String s:temp[2]){
                    mSub.add(s);
                }
                aMain.retainAll(aSub);
                hMain.retainAll(hSub);
                mMain.retainAll(mSub);}
            else{
                aMain=new HashSet<>();
                hMain=new HashSet<>();
                mMain=new HashSet<>();
                temp=amu.findLocation(city);
                for (String s:temp[0]){
                    aMain.add(s);
                }
                for (String s:temp[1]){
                    hMain.add(s);
                }
                for (String s:temp[2]){
                    mMain.add(s);
                }
            }
        }
        if(type.length()>1){
            if (aMain!=null) {
                if(type.equals("Διαμέρισμα")){
                    return aMain.toArray(new String[0]);
                }
                else if(type.equals("Ξενοδοχείο")){
                    return hMain.toArray(new String[0]);
                }
                else if(type.equals("Μεζονέτα")){
                    return hMain.toArray(new String[0]);
                }
            }
            else{
                aMain=new HashSet<>();
                hMain=new HashSet<>();
                mMain=new HashSet<>();
                temp=amu.findLocation(city);
                HashSet<String> main=new HashSet<>();
                if(type.equals("Διαμέρισμα")){
                    for (String s:temp[0]){
                        main.add(s);}
                }
                else if(type.equals("Ξενοδοχείο")){
                    for (String s:temp[1]){
                        main.add(s);}
                }
                else if(type.equals("Μεζονέτα")){
                    for (String s:temp[2]){
                        main.add(s);}
                }
                return main.toArray(new String[0]);
            }
        }
        ArrayList<String> ar=new ArrayList<>();
        t=aMain.toArray(new String[0]);
        for (String s:t){
            ar.add(s+"#"+"Apartment");
        }
        t=hMain.toArray(new String[0]);
        for (String s:t){
            ar.add(s+"#"+"Hotel");
        }
        t=mMain.toArray(new String[0]);
        for (String s:t){
            ar.add(s+"#"+"Maisonette");
        }
        return ar.toArray(new String[0]);
    }
}