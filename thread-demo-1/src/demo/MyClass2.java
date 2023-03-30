package demo;

public class MyClass2 implements Runnable{

    public MyClass2(String name){
        Thread t = new Thread(this,name);
        t.start();
    }

    @Override
    public void run() {
        for (int i=0;i<=10;i++){
            System.out.println(String.format("%s :: %s",Thread.currentThread().getName(),i));
            try{
                Thread.sleep(2000);
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }
}
