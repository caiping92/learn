package pers.cabin.jichu.a5_designPattern.dm20_ObserverPattern;

/**
 * Created by caiping on 2017/3/3.
 */
public class BinaryObserver extends Observer {
    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Binary String: "
                + Integer.toBinaryString(subject.getState()));
    }
}
