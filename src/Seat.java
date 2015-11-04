import java.util.concurrent.locks.ReentrantLock;

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
