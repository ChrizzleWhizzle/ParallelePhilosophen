public class Fork extends Lockable {

    public boolean take() {
        return lock.tryLock();
    }

    public boolean drop() {
        try {
            lock.unlock();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
