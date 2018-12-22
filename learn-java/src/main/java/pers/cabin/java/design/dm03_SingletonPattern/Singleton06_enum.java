package pers.cabin.java.design.dm03_SingletonPattern;

/**
 * Created by caiping on 2017/3/2.
 */
public class Singleton06_enum {
    public static void main(String[] args) {
        Resouce instance = Singleton6.INSTANCE.getInstance();
    }
}

class Resouce {

}

enum Singleton6 {
    INSTANCE;
    private Resouce instace;

    Singleton6() {
        instace = new Resouce();
    }

    public Resouce getInstance() {
        return instace;
    }

}