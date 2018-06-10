package pers.cabin.jichu.a5_designPattern.dm17_IteratorPattern;

/**
 * Created by caiping on 2017/3/3.
 */
public class IteratorPatternDemo {
    public static void main(String[] args) {
        NameRepository namesRepository = new NameRepository();

        for (Iterator iter = namesRepository.getIterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            System.out.println("Name : " + name);
        }
    }
}
