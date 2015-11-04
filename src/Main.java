import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        int nForks = 10;
        int nSeats = 10;
        int nPhilosophers = 50;
        List<Seat> seatList = new ArrayList<>(nSeats);
        List<Fork> forkList = new ArrayList<>(nForks);

        //Create forks
        for(int i = 0; i < nForks; i++){
            forkList.add(new Fork());
        }

        //Create seats
        int seatID = 1;
        seatList.add(new Seat(seatID++, forkList.get(nForks - 1),forkList.get(0)));
        for(int i = 0; i < nSeats - 1; i++){
            seatList.add(new Seat(seatID++, forkList.get(i),forkList.get(i+1)));
        }
        System.out.println("Seatlist: " + seatList.toString());
        System.out.println("Forklist: " + forkList.toString());

        //Create table
        Table table = new Table(seatList,forkList);
        for(int i = 0; i < nPhilosophers; i++){
            new Philosopher(i + 1, table).start();
        }
        System.out.println("started");
    }
}
