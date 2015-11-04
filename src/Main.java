import javafx.scene.paint.PhongMaterial;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        int nForks = 10;
        int nSeats = 10;
        int nPhilosophers = 50;
        List<Seat> seatList = new ArrayList<>(nSeats);
        List<Fork> forkList = new ArrayList<>(nForks);
        List<Philosopher> philList = new ArrayList<>(nPhilosophers);

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
            Philosopher p = new Philosopher(i + 1, table);
            p.start();
            philList.add(p);
        }
        System.out.println("started");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
        }

        System.out.println("Killing all Philosophers");

        philList.forEach(p -> p.interrupt());

        System.out.println("Joining all Philosopher-Threads");
        long sumMealsEaten = 0;
        for (Philosopher p : philList) {
            try {

                p.join();
                System.out.println(p);
            } catch (InterruptedException e) {
            }finally {

                sumMealsEaten += p.totalMealsEaten;
            }
        }

        System.out.println("Total Meals eaten: " + sumMealsEaten);
    }
}
