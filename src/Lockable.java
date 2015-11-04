import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Chris on 04.11.2015.
 */
public abstract class Lockable {

    final ReentrantLock lock = new ReentrantLock();

}
