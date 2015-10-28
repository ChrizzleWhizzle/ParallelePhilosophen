import java.util.concurrent.locks.ReentrantLock;

public class Philosoph {
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
    // test

    private ReentrantLock _lock = new ReentrantLock(true);

}