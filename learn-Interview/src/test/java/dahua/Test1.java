package dahua;

/**
 * Created by caiping on 2017/9/23.
 */
public class Test1 extends Thread{

    @Override
    public void run() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("run");
    }

    public static void main(String[] args){
        Test1 test1 = new Test1();
        test1.run();
        System.out.println("main");
    }
}
