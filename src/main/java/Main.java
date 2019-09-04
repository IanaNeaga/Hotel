public class Main {
    public static void main(String[] args) {
//        Hotel hotel=new Hotel();
        Receptionist receptionist=new Receptionist(Hotel.load());
        receptionist.startWork();
    }
}
