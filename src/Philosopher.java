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
    public int totalMealsEaten;
    private boolean hasBothForks = false;

    public Philosopher(int id, Table table) {
        this.id = id;
        this.table = table;
    }

    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {

                takeSeat();
                // take forks
                while(!hasBothForks) {
                    seat.takeRightFork();
                    if(!seat.takeLeftFork()){
                        seat.dropRight();
                    }
                    else {
                        hasBothForks =true;
                    }
                }; //boolean hasbothforks
                eat();
                seat.dropLeft();
                seat.dropRight();
                seat.standUp();
                if (mealsEaten == maxMealsEaten) goToSleep();
                else meditate();
            }
        } catch (Exception e) {
            return;
        }
    }

    private void eat() throws InterruptedException {
            postMsg("eating for " + eatTime + "on Seat: " + seat.id);
            mealsEaten++;
            totalMealsEaten++;
            Thread.sleep(eatTime);
    }

    private void goToSleep() throws InterruptedException {
            postMsg("sleeping for " + sleepTime);
            Thread.sleep(sleepTime);
            mealsEaten = 0;
    }

    private void meditate() throws InterruptedException {
            postMsg("meditating for " + meditateTime);
            Thread.sleep(meditateTime);
    }

    private void postMsg(String str) {
        System.out.printf("Time: %d Event: %d Philosopher %d %s\n",
                System.currentTimeMillis(), ++event, id, str);
    }

    private void takeSeat() throws InterruptedException{
        seat = table.takeSeat();
    }

}