import java.util.*;
class SeatAlreadyBookedException extends Exception{
    public SeatAlreadyBookedException(String msg) {
        super(msg);
}}
public class TicketBooking{
    public static void main(String[] args) throws SeatAlreadyBookedException {
        TreeMap<Integer,String> seatMap = new TreeMap<>();
        for(int i = 1;i<=5;i++){
            seatMap.put(i,"Available");
        }
        int seatToBook = 3;
        if(seatMap.get(seatToBook).equals("Booked")){
            throw new SeatAlreadyBookedException("Seat is already booked");
        }else{
            seatMap.put(seatToBook,"Booked");
        }

        System.out.println("Seat Status: ");
        for(Map.Entry<Integer,String>e: seatMap.entrySet()){ //Loop to print the seat status
            System.out.println("Seat "+e.getKey()+": "+e.getValue());
        }
    }
}
