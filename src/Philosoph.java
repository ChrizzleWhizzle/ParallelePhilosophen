import java.util.concurrent.locks.ReentrantLock;

public class Philosoph extends Thread {
    // Process:
    // start with meditate
    // if hungry go to dining room
    // take a free seat
    // take right fork (only one Philosoph can take the fork at time)
    // take left fork (only one Philosoph can take the fork at time)
    // eat
    // go back to meditate
    // after 3 meals go to sleep
    // (rave)
    // repeat
    // horst

    private ReentrantLock _lock = new ReentrantLock(true);
    private final int eatTime = 1000;
    private final int meditateTime = 1000;
    private final int sleepTime = 10000;
    private static int event=0;

    private int id;
    private Seat seat;
    private static final int maxMealsEaten = 3;
    private int mealsEaten;

    public Philosoph(int id) {
        this.id = id;
    }

    public void run() {
        while (true) {

            if (takeSeat()) continue;
            // take right fork
            // take left fork
            eat();
            if (mealsEaten == maxMealsEaten) goToSleep();
            else meditate();
        }
    }

    private void eat() {
        try {
            postMsg("eating for " + eatTime);
            mealsEaten++;
            Thread.sleep(eatTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void goToSleep() {
        try {
            postMsg("sleeping for " + sleepTime);
            Thread.sleep(sleepTime);
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
        System.out.printf("%d %d Philosopher %d %s\n",
                System.currentTimeMillis(), ++event, id, str);
    }

    private boolean takeSeat() {
        return false;
    }

}