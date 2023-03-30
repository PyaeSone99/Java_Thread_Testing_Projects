package demo;

public class    Main2 {
    public static void main(String[] args) {
        TwoString obj = new TwoString();
        new MyThreadClass( "Knock knock","Who is there?",obj);
        new MyThreadClass("I am Dean","Oh coming!",obj);
        new MyThreadClass("Well!Mate","The Country men!Coders",obj);
    }
}

