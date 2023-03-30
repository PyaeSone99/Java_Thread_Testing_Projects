package demo;

public class MyClass extends Thread{

    public MyClass(String name){
        super(name);
        start();
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
