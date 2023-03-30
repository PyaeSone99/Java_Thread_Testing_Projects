package demo;

public class Producer extends Thread{
    private CubbyHole cubbyHole;
    private int number;

    public Producer(CubbyHole cubbyHole,int number){
        this.cubbyHole = cubbyHole;
        this.number = number;
    }

    @Override
    public void run() {
        for (int i=0;i<=10;i++){
            cubbyHole.put(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }



}






