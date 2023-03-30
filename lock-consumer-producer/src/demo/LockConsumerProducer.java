package demo;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockConsumerProducer {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private static final int LIMIT = 3;
    private ArrayList<Integer> list = new ArrayList<>();

    public void producer(){
        int value = 0;

        try {
            lock.lock();
            for (int i=0;i<=10;i++){
                while(this.list.size()==LIMIT){
                    condition.await();
                }
                System.out.println(
                        String.format("Producer put:%d",value)
                );
                this.list.add(value);
                value++;
                condition.signal();

            }
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }finally {
            lock.unlock();
        }
    }

    public void consumer(){
        try {
            lock.lock();
            for (int i=0;i<=10;i++){
                while (this.list.size()==0){
                    condition.await();
                }
                int value = this.list.remove(0);
                System.out.println(
                        String.format("Consumer consume: %d",value)
                );
                condition.signal();
                Thread.sleep(1500);
            }
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        LockConsumerProducer lockConsumerProducer = new LockConsumerProducer();
        new Thread(lockConsumerProducer::producer).start();
        new Thread(lockConsumerProducer::consumer).start();


    }
}





















