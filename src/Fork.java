public class Fork extends Lockable {

    public boolean take() {
        return lock.tryLock();
    }

    public void drop() {
        try {
            lock.unlock();
        } catch (Exception e) {
        }
    }
}
