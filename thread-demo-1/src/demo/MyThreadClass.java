package demo;

public class MyThreadClass implements Runnable{
    private String s1,s2;
    private TwoString twoString;
    public MyThreadClass(String s1,String s2,TwoString twoString){
        this.s1 = s1;
        this.s2 = s2;
        this.twoString = twoString;
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        synchronized (twoString){
            twoString.print(s1,s2);
        }

    }
}
