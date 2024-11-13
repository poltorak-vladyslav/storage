public class Producer extends Thread {

    private final Storage storage;
    private final int producerId;
    private final int productsToProduce;

    public Producer(Storage storage, int producerId, int productsToProduce) {
        this.storage = storage;
        this.producerId = producerId;
        this.productsToProduce = productsToProduce;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < productsToProduce; i++) {
                storage.produce(producerId, new Product(i));
                Thread.sleep((int)(Math.random() * 100));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
