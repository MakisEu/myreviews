package api;

import java.util.ArrayList;
import java.util.HashSet;

public class UserSub {
    /**
     * All the Variables in the User class:
     * amu              AccommodationManagerUser object
     * name             The name of a user
     * username         The username of a user
     */
    AccommodationManagerUser amu;
    String name,username;

    /**
     * Normal constructor:
     * @param n The name
     * @param u The username
     */
    public UserSub(String u,String n){
        name=n;
        username=u;
        amu=new AccommodationManagerUser();
    }

    /**
     * Method that Searches and returns all the accommodations with same characteristics with the parameters
     * @param city The city of the accommodation
     * @param type The type of the accommodation
     * @param name The name of the accommodation
     * @param prop The properties of the accommodation
     * @return A string array with the accommodations with the preferred characteristic
     */
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
                if (s!=null)
                    aMain.add(s);
            }
            for (String s:temp[1]){
                if (s!=null)
                    hMain.add(s);
            }
            for (String s:temp[2]){
                if (s!=null)
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
                    if (s!=null)
                        aSub.add(s);
                }
                for (String s:temp[1]){
                    if (s!=null)
                        hSub.add(s);
                }
                for (String s:temp[2]){
                    if (s!=null)
                        mSub.add(s);
                }
                aMain.retainAll(aSub);
                hMain.retainAll(hSub);
                mMain.retainAll(mSub);}
            else{
                aMain=new HashSet<>();
                hMain=new HashSet<>();
                mMain=new HashSet<>();
                for (String s:temp[0]){
                    if (s!=null)
                        aMain.add(s);
                }
                for (String s:temp[1]){
                    if (s!=null)
                        hMain.add(s);
                }
                for (String s:temp[2]){
                    if (s!=null)
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
                    if (s!=null)
                        aSub.add(s);
                }
                for (String s:temp[1]){
                    if (s!=null)
                        hSub.add(s);
                }
                for (String s:temp[2]){
                    if (s!=null)
                        mSub.add(s);
                }
                aMain.retainAll(aSub);
                hMain.retainAll(hSub);
                mMain.retainAll(mSub);}
            else{
                aMain=new HashSet<>();
                hMain=new HashSet<>();
                mMain=new HashSet<>();
                for (String s:temp[0]){
                    if (s!=null)
                        aMain.add(s);
                }
                for (String s:temp[1]){
                    if (s!=null)
                        hMain.add(s);
                }
                for (String s:temp[2]){
                    if (s!=null)
                        mMain.add(s);
                }
            }
        }
        if(type.length()>1){
            if (aMain!=null) {
                if(type.equalsIgnoreCase("apartment")){
                    hMain=null;
                    mMain=null;
                    //return aMain.toArray(new String[0]);
                }
                else if(type.equalsIgnoreCase("hotel")){
                    aMain=null;
                    mMain=null;
                    //return hMain.toArray(new String[0]);
                }
                else if(type.equalsIgnoreCase("maisonette")){
                    hMain=null;
                    aMain=null;
                    //return hMain.toArray(new String[0]);
                }
            }
            else{
                temp=amu.findType(type);
                aMain=new HashSet<>();
                hMain=new HashSet<>();
                mMain=new HashSet<>();
                for (String s:temp[0]){
                    if (s!=null)
                        aMain.add(s);
                }
                for (String s:temp[1]){
                    if (s!=null)
                        hMain.add(s);
                }
                for (String s:temp[2]){
                    if (s!=null)
                        mMain.add(s);
                }
            }
        }
        ArrayList<String> ar=new ArrayList<>();
        if (aMain!=null){
            t=aMain.toArray(new String[0]);
            for (String s:t){
                if (s!=null)
                    ar.add(s+"#"+"Apartment");
            }}
        if (hMain!=null){
            t=hMain.toArray(new String[0]);
            for (String s:t){
                if (s!=null)
                    ar.add(s+"#"+"Hotel");
            }}
        if (mMain!=null){
            t=mMain.toArray(new String[0]);
            for (String s:t){
                if (s!=null)
                    ar.add(s+"#"+"Maisonette");
            }}
        return ar.toArray(new String[0]);
    }

}
