import java.util.List;


public class Table {
    final List<Seat> seats;
    final List<Fork> forks;
    int freeSeats;

    public Table(List seats, List forks) {
        this.seats = seats;
        this.forks = forks;
        freeSeats = seats.size();
    }

    public Seat takeSeat(){
        Seat freeSeat = null;
        try{

        }
        finally {

        }

        return freeSeat;
    }
}
