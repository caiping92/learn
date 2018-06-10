package pers.cabin.jichu.a9_concurrent._thread;

/**
 * Created by caiping on 2017/9/22.
 */
public class Bank {

    /**
     * 账户余额
     */
    private int count = 0;

    public synchronized void  addMoney(int money) {
        count += money;
        System.out.println(System.currentTimeMillis()+" 存进："+money);
    }

    /**
     * 取钱
     */
    public synchronized void drawMoney(int money) {
        if(count-money < 0){
            System.out.println("当前余额不足！！");
            return;
        }
        count -=money;
        System.out.println(+System.currentTimeMillis()+"取出："+money);
    }

    public synchronized void viewMoney() {
        System.out.println(+System.currentTimeMillis()+"还剩："+count);
    }
}
