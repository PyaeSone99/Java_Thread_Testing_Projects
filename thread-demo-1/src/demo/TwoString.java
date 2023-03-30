package demo;

public class TwoString {
    public synchronized  void print(String s1,String s2){
        System.out.println(s1);
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        System.out.println(s2);
    }
}
