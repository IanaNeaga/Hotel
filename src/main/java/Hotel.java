import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Hotel implements Serializable{
    private static final long serialVersionUID = -3489485716942379257L;
    ArrayList<Room> rooms;

    public Hotel() {
        rooms = new ArrayList<Room>();
        for (int i = 0; i < 3; i++) {
            rooms.add(new Room(new ArrayList<Reservation>(), i));
        }
    }

    public boolean isRoomAvailable(int roomNumber, LocalDate date) {
        Room x = rooms.get(roomNumber);
        return x.isAvailable(date);
    }

    public boolean reserveRoom(int roomNumber, LocalDate date, String name) {
        Room x = rooms.get(roomNumber);
        return x.reserve(date, name);
    }

    public int getAvailableRoom(LocalDate date) {
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).isAvailable(date)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return rooms + "";
    }

    public void addRoom(ArrayList<Reservation> reservations, int roomNumber) {
        Room room = new Room(reservations, roomNumber);
    }



    public void save() {
        // Serialization
        try {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream("hotel.db");
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(this);

            out.close();
            file.close();

            System.out.println("Object has been serialized");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static Hotel load()
    {
        Hotel object1 = null;
        // Deserialization
        try
        {
            // Reading the object from a file
            FileInputStream file = new FileInputStream("hotel.db");
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            object1 = (Hotel)in.readObject();

            in.close();
            file.close();

            System.out.println("Object has been deserialized ");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (object1==null){
            object1=new Hotel();
        }
        return object1;
    }


    public List<Reservation> getAllReservationsSortedByName(){
        //Pasul 1: obtinem o lista cu toate rezervarile tuturor camerelor
        List<Reservation> acumulator=new ArrayList<Reservation>();
        for(Room r:rooms){
            List<Reservation> tmp=r.getAllReservations();
            acumulator.addAll(tmp);
        }

        //Pasul 2: le sortez
        acumulator.sort(new Comparator<Reservation>(){

            @Override
            public int compare(Reservation o1, Reservation o2) {
                return o1.name.compareTo(o2.name);
            }
        });

//        sau*
//        Collections.sort(acumulator);

        //Pasul 3: le returnez
        return acumulator;
    }

}
