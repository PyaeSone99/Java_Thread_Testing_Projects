package demo;

public class Main {
    public static void main(String[] args) {
        CubbyHole cubbyHole = new CubbyHole();
        Producer producer = new Producer(cubbyHole,1);
        Consumer consumer = new Consumer(cubbyHole,1);
        producer.start();
        consumer.start();
    }
}
