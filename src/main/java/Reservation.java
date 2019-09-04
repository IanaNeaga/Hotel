import java.io.Serializable;
import java.time.LocalDate;

public class Reservation implements Serializable
//*, Comparable<Reservation>
//    + @Override
{
    private static final long serialVersionUID = 3166426339113740772L;
    private LocalDate date;
    public String name;
    private int roomNumber;

    public Reservation(LocalDate date, String name, int roomNumber) {
        this.date = date;
        this.name = name;
        this.roomNumber = roomNumber;
    }

    @Override
    public boolean equals(Object reservation){
        if(reservation instanceof Reservation){
            Reservation temp=(Reservation)reservation;
            return this.date.equals(temp.date)&&
                    this.roomNumber==temp.roomNumber;
        }
        return false;
    }

    @Override
    public String toString(){
        return "Room "+(roomNumber+1)+" is reserved on "+date+" by "+name+".";
    }


}
