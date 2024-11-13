public class Main {

    private static final int CAPACITY = 5;
    private static final int DOORS = 2;
    private static final int PRODUCER_COUNT = 3;
    private static final int CONSUMER_COUNT = 3;
    private static final int ITEMS_PER_PRODUCER = 5;
    private static final int ITEMS_PER_CONSUMER = 5;

    private static final Storage STORAGE = new Storage(CAPACITY, DOORS);

    public static void main(String[] args) {
        for (int i = 0; i < CONSUMER_COUNT; i++) {
            new Consumer(STORAGE, i, ITEMS_PER_CONSUMER).start();
        }

        for (int i = 0; i < PRODUCER_COUNT; i++) {
            new Producer(STORAGE, i, ITEMS_PER_PRODUCER).start();
        }
    }
}