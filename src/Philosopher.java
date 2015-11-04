import java.util.concurrent.locks.ReentrantLock;

public class Philosopher extends Thread {
    // Process:
    // start with meditate
    // if hungry go to dining room
    // take a free seat
    // take right fork (only one Philosopher can take the fork at time)
    // take left fork (only one Philosopher can take the fork at time)
    // eat
    // go back to meditate
    // after 3 meals go to sleep
    // (rave)
    // repeat
    // horst

    private final int eatTime = 1;
    private final int meditateTime = 5;
    private final int sleepTime = 10;
    private static int event=0;

    private int id;
    private Seat seat;
    private Table table;
    private static final int maxMealsEaten = 3;
    private int mealsEaten;
    private int totalMealsEaten;

    public Philosopher(int id, Table table) {
        this.id = id;
        this.table = table;
    }

    public void run() {
        while (true) {

            takeSeat();
            // take right fork
            do {
                seat.dropRight();
                seat.takeRightFork();
            }while (!seat.takeLeftFork());
            // take left fork
            eat();
            seat.dropLeft();
            seat.dropRight();
            seat.standUp();
            if (mealsEaten == maxMealsEaten) goToSleep();
            else meditate();
        }
    }

    private void eat() {
        try {
            postMsg("eating for " + eatTime + "on Seat: " + seat.id);
            mealsEaten++;
            totalMealsEaten++;
            Thread.sleep(eatTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void goToSleep() {
        try {
            postMsg("sleeping for " + sleepTime);
            Thread.sleep(sleepTime);
            mealsEaten = 0;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void meditate() {
        try {
            postMsg("meditating for " + meditateTime);
            Thread.sleep(meditateTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void postMsg(String str) {
        System.out.printf("Time: %d Event: %d Philosopher %d %s\n",
                System.currentTimeMillis(), ++event, id, str);
    }

    private void takeSeat() {
        seat = table.takeSeat();
    }

}