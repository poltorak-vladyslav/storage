public class Consumer extends Thread {

    private final Storage storage;
    private final int consumerId;
    private final int productsToConsume;

    public Consumer(Storage storage, int consumerId, int productsToConsume) {
        this.storage = storage;
        this.consumerId = consumerId;
        this.productsToConsume = productsToConsume;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < productsToConsume; i++) {
                storage.consume(consumerId);
                Thread.sleep((int)(Math.random() * 100));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
