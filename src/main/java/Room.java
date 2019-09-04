import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class Room implements Serializable {
    private static final long serialVersionUID = 5255824207797572691L;
    SortedSet<Reservation> reservations;
    int roomNumber;

    public Room(ArrayList<Reservation> reservations, int roomNumber) {
        this.reservations = new TreeSet<Reservation>();
        this.roomNumber = roomNumber;
    }

    public boolean reserve(LocalDate date, String name) {
        Reservation x = new Reservation(date, name, roomNumber);
        return reservations.add(x);
    }

    public boolean isAvailable(LocalDate date){
        Reservation r=new Reservation(date,"",roomNumber);
        return reservations.contains(r) == false;
    }

    @Override
    public String toString(){
        return ""+(roomNumber+1)+reservations;
    }

    public List<Reservation> getAllReservations(){
        List<Reservation> list=new ArrayList<Reservation>();
        list.addAll(reservations);
        return list;
    }
}
