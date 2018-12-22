package pers.cabin.java.design.dm28_CompositeEntityPattern;

/**
 * Created by caiping on 2017/3/3.
 */
public class CompositeEntityPatternDemo {
    public static void main(String[] args) {
        Client client = new Client();
        client.setData("Test", "Data");
        client.printData();
        client.setData("Second Test", "Data1");
        client.printData();
    }
}
