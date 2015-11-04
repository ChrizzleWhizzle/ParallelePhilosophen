import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        int nForks = 5;
        int nSeats = 5;
        List<Seat> seatList = new ArrayList<>(nSeats);
        List<Fork> forkList = new ArrayList<>(nForks);
        for(int i = 0; i < nForks; i++){
            forkList.add(new Fork());
        }

        //Creating seats
        seatList.add(new Seat(forkList.get(nForks - 1),forkList.get(0)));
        for(int i = 0; i < nSeats - 1; i++){
            seatList.add(new Seat(forkList.get(i),forkList.get(i+1)));
        }
        System.out.println("Seatlist: " + seatList.toString());
        System.out.println("Forklist: " + forkList.toString());
        Philosoph phil1 = new Philosoph(1);
        phil1.start();
        System.out.println("started");
    }
}
