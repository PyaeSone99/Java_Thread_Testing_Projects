package demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Calculator {
    private int count =0;
    private Lock lock = new ReentrantLock();

    public void increment(){
        for (int i =0;i<10000;i++){
            count++;
        }
    }

    public void firstIncrement(){
        lock.lock();
        try {
            increment();
            Thread.sleep(500);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void secondIncrement(){
        lock.lock();
        try {
            increment();
            Thread.sleep(500);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public int getCount(){
        return count;
    }
}

public class LockDemo{
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Thread t1 = new Thread(calculator::firstIncrement);
        Thread t2 = new Thread(calculator::secondIncrement);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Count :: " + calculator.getCount());

    }
}
