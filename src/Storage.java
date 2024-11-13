import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

public class Storage {

    private final ConcurrentLinkedQueue<Product> storage = new ConcurrentLinkedQueue<>();
    private final Semaphore items;
    private final Semaphore spaces;
    private final Semaphore doors;

    public Storage(int capacity, int doors) {
        this.items = new Semaphore(0);
        this.spaces = new Semaphore(capacity);
        this.doors = new Semaphore(doors);
    }

    public void produce(int producerId, Product product) throws InterruptedException {
        spaces.acquire();
        doors.acquire();

        storage.add(product);
        System.out.println("Виробник " + producerId + " додав " + product);

        doors.release();
        items.release();
    }

    public void consume(int consumerId) throws InterruptedException {
        items.acquire();
        doors.acquire();

        Product product = storage.poll();
        System.out.println("Споживач " + consumerId + " отримав " + product);

        doors.release();
        spaces.release();
    }
}
