import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Chris on 28.10.2015.
 */
public class Seat {

    private final ReentrantLock lock = new ReentrantLock();
    private Fork leftFork;
    private Fork rightFork;

    public Seat(Fork leftFork, Fork rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public String toString() {
        return super.toString().concat(leftFork.toString().concat(rightFork.toString()));
    }
}
