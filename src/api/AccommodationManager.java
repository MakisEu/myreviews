package api;

import java.util.ArrayList;

public class AccommodationManager {
    private ArrayList<Apartment> apartments;
    private ArrayList<Hotel> hotels;
    private ArrayList<Maisonette> maisonettes;

    public AccommodationManager() {
        apartments = new ArrayList<>();
        hotels = new ArrayList<>();
        maisonettes = new ArrayList<>();
    }

    public String getType(String o, String n) {
        for (Apartment a : apartments) {
            if (n == a.getName() && o == a.getOwner()) {
                return "Διαμέρισμα";
            }
        }
        for (Hotel a : hotels) {
            if (n == a.getName() && o == a.getOwner()) {
                return "Ξενοδοχείο";
            }
        }
        for (Maisonette a : maisonettes) {
            if (n == a.getName() && o == a.getOwner()) {
                return "Μεζονέτα";
            }
        }
        return null;
    }

    public String addAccommodation(String type, String n, String a, String tk, String c, String desc, String o) {
        if (type == "Ξενοδοχείο") {
            Hotel h = new Hotel(n, a, tk, c, desc, o);
            hotels.add(h);
            return "Added successfully";
        } else if (type == "Διαμέρισμα") {
            Apartment ap = new Apartment(n, a, tk, c, desc, o);
            apartments.add(ap);
            return "Added successfully";
        } else if (type == "Μεζονέτα") {
            Maisonette h = new Maisonette(n, a, tk, c, desc, o);
            maisonettes.add(h);
            return "Added successfully";
        } else {
            return "Incorrect type. Addition failed.";
        }
    }

    public void editHotel(String owner, String name, int star, int floor, boolean suite) {
        for (Hotel a : hotels) {
            if (a.getOwner() == owner && a.getName() == name) {
                a.setFloors(floor);
                a.setStars(star);
                a.setHasSuite(suite);
            }
        }
    }

    public void editApartment(String owner, String name, int floor, int space, boolean guard, boolean elevator) {
        for (Apartment a : apartments) {
            if (a.getOwner() == owner && a.getName() == name) {
                a.setSpace(space);
                a.setElevator(elevator);
                a.setFloor(floor);
                a.setGuard(guard);
            }
        }
    }

    public void editMaisonette(String owner, String name, int rm) {
        for (Maisonette a : maisonettes) {
            if (a.getOwner() == owner && a.getName() == name) {
                a.setRoommates(rm);
            }
        }
    }

    public void updateProperty(String o, String n, String key, String val) {
        String type = this.getType(o, n);
        if (type == "Ξενοδοχείο") {
            for (Hotel h : hotels) {
                if (h.getOwner() == o && h.getName() == n) {
                    h.updateProperty(key, val);
                }
            }
        } else if (type == "Διαμέρισμα") {
            for (Apartment h : apartments) {
                if (h.getOwner() == o && h.getName() == n) {
                    h.updateProperty(key, val);
                }
            }

        } else if (type == "Μεζονέτα") {
            for (Maisonette h : maisonettes) {
                if (h.getOwner() == o && h.getName() == n) {
                    h.updateProperty(key, val);
                }
            }
        }
    }

    public void addRating(String o, String n, String desc, float ra, String user, String date) {
        String type = this.getType(o, n);
        if (type == "Ξενοδοχείο") {
            for (Hotel h : hotels) {
                if (h.getOwner() == o && h.getName() == n) {
                    h.addRating(desc, ra, user, date);
                }
            }
        } else if (type == "Διαμέρισμα") {
            for (Apartment h : apartments) {
                if (h.getOwner() == o && h.getName() == n) {
                    h.addRating(desc, ra, user, date);
                }
            }

        } else if (type == "Μεζονέτα") {
            for (Maisonette h : maisonettes) {
                if (h.getOwner() == o && h.getName() == n) {
                    h.addRating(desc, ra, user, date);
                }
            }
        }
    }

    public void editRatings(String o, String n, String desc, float ra, String user) {
        String type = this.getType(o, n);
        if (type == "Ξενοδοχείο") {
            for (Hotel h : hotels) {
                if (h.getOwner() == o && h.getName() == n) {
                    h.editRating(user, desc, ra);
                }
            }
        } else if (type == "Διαμέρισμα") {
            for (Apartment h : apartments) {
                if (h.getOwner() == o && h.getName() == n) {
                    h.editRating(user, desc, ra);
                }
            }

        } else if (type == "Μεζονέτα") {
            for (Maisonette h : maisonettes) {
                if (h.getOwner() == o && h.getName() == n) {
                    h.editRating(user, desc, ra);
                }
            }
        }
    }

    public void deleteRating(String o, String n, String user) {
        String type = this.getType(o, n);
        if (type == "Ξενοδοχείο") {
            for (Hotel h : hotels) {
                if (h.getOwner() == o && h.getName() == n) {
                    h.deleteRating(user);
                }
            }
        } else if (type == "Διαμέρισμα") {
            for (Apartment h : apartments) {
                if (h.getOwner() == o && h.getName() == n) {
                    h.deleteRating(user);
                }
            }

        } else if (type == "Μεζονέτα") {
            for (Maisonette h : maisonettes) {
                if (h.getOwner() == o && h.getName() == n) {
                    h.deleteRating(user);
                }
            }
        }
    }

    public void deleteAccommodation(String owner, String name) {
        String type = this.getType(owner, name);
        System.out.println(type);
        if (type == "Ξενοδοχείο") {
            for (Hotel h : hotels) {
                if (h.getOwner() == owner && h.getName() == name) {
                    hotels.remove(h);
                    return;
                }
            }
        } else if (type == "Διαμέρισμα") {
            for (Apartment h : apartments) {
                if (h.getOwner() == owner && h.getName() == name) {
                    apartments.remove(h);
                    return;
                }
            }
        } else if (type == "Μεζονέτα") {
            for (Maisonette h : maisonettes) {
                if (h.getOwner() == owner && h.getName() == name) {
                    maisonettes.remove(h);
                    return;
                }
            }
        }
    }

    public void showAll() {
        for (Apartment a : apartments) {
            a.show();
        }
        for (Hotel h : hotels) {
            h.show();
        }
        for (Maisonette m : maisonettes) {
            m.show();
        }
    }

    public void showOwned(String owner) {
        for (Apartment a : apartments) {
            if (a.getOwner() == owner) {
                a.show();
            }
        }
        for (Hotel h : hotels) {
            if (h.getOwner() == owner) {
                h.show();
            }
        }
        for (Maisonette m : maisonettes) {
            if (m.getOwner() == owner) {
                m.show();
            }
        }
    }

    public Hotel getHotel(String owner, String name) {
        for (Hotel a : hotels) {
            if (a.getOwner() == owner && a.getName() == name) {
                return a;
            }
        }
        return null;
    }

    public Apartment getApartment(String owner, String name) {
        for (Apartment a : apartments) {
            if (a.getOwner() == owner && a.getName() == name) {
                return a;
            }
        }
        return null;
    }

    public Maisonette getMaisonette(String owner, String name) {
        for (Maisonette a : maisonettes) {
            if (a.getOwner() == owner && a.getName() == name) {
                return a;
            }
        }
        return null;
    }

    public void setDescription(String o,String n,String desc) {
        String type = this.getType(o, n);

        if (type == "Ξενοδοχείο")
            this.getHotel(o, n).setDescription(desc);
        else if (type == "Διαμέρισμα")
            this.getApartment(o, n).setDescription(desc);
        else {
            this.getMaisonette(o, n).setDescription(desc);}
        }
    public void setName(String o,String n,String name) {
        String type = this.getType(o, n);

        if (type == "Ξενοδοχείο")
            this.getHotel(o, n).setName(name);
        else if (type == "Διαμέρισμα")
            this.getApartment(o, n).setName(name);
        else {
            this.getMaisonette(o, n).setName(name);}
    }
    public void setTK(String o,String n,String tk) {
        String type = this.getType(o, n);

        if (type == "Ξενοδοχείο")
            this.getHotel(o, n).setTK(tk);
        else if (type == "Διαμέρισμα")
            this.getApartment(o, n).setTK(tk);
        else {
            this.getMaisonette(o, n).setTK(tk);}
    }
    public void setCity(String o,String n,String c) {
        String type = this.getType(o, n);

        if (type == "Ξενοδοχείο")
            this.getHotel(o, n).setCity(c);
        else if (type == "Διαμέρισμα")
            this.getApartment(o, n).setCity(c);
        else {
            this.getMaisonette(o, n).setCity(c);
        }
    }
    public void setAddress(String o,String n,String a) {
        String type = this.getType(o, n);

        if (type == "Ξενοδοχείο")
            this.getHotel(o, n).setAddress(a);
        else if (type == "Διαμέρισμα")
            this.getApartment(o, n).setAddress(a);
        else {
            this.getMaisonette(o, n).setAddress(a);
        }
    }
}