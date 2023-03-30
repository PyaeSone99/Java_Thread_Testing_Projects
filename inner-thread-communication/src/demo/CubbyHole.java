package demo;

public class CubbyHole {
    private int content;
    private boolean available = false;
    public synchronized int get(){
        while (available==false){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        available=false;
        System.out.println(String.format("Consumer got %d",content));
        notifyAll();
        return content;
    }
    public synchronized void put(int data){
        while (available==true){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.content=data;
        available=true;
        System.out.println(String.format("Producer put :: %d",data));
        notifyAll();
    }

}
