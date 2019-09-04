import java.time.LocalDate;
import java.util.Scanner;

//tine loc de UI, nu trebuie facut neaparat serializabil
public class Receptionist {
    Hotel hotel;

    public Receptionist(Hotel hotel) {
        this.hotel = hotel;
    }

    /* Meniu:
       1.Pentru a rezerva o camera:
       -alegeti data
       -alegeti numele pe care sa se faca rezervarea
       2.Pentru a afisa toate rezervarile
       3.Inchide program
        */
    private void showMenu(){
        System.out.println("Alegeti tasta:");
        System.out.println("1.Pentru a rezerva o camera;");
        System.out.println("2.Pentru a afisa rezervarile;");
        System.out.println("3.Pentru a inchide programul.");
        System.out.println("4.Pentru a afisa alfabetic toate rezervarile.");
    }

    public void startWork(){
        Scanner scanner = new Scanner(System.in);
        while(true) {
            showMenu();
            String option = scanner.nextLine();
            switch (option){
                case "1":
                    System.out.println("Alege data rezervarii (yyyy-mm-dd):");
                    LocalDate date= LocalDate.parse(scanner.nextLine());
                    System.out.println("Pe ce nume doriti sa faceti rezervarea?");
                    String name=scanner.nextLine();
                    int roomNumber=hotel.getAvailableRoom(date);
                    if(roomNumber==-1){
                        System.out.println("Din pacate, nu mai sunt camere disponibile.");
                    }else{
                        hotel.reserveRoom(roomNumber,date,name);
                    }
                    break;
                case "2":
                    System.out.println(hotel.rooms);
                    break;
                case "3":
                    hotel.save();
                    return;
                case "4":
                    System.out.println(hotel.getAllReservationsSortedByName());
            }
        }
    }
}
